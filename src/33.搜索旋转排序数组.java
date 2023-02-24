/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)  return -1;
        if (nums.length == 1)  return nums[0] == target ? 0 : -1;
        // return search1(nums, target);
        return search2(nums, target);
    }

    // 时间复杂度为O(N)的最简单的做法
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target)  return i;
        }
        return -1;
    }

    // 实际上还可以使用二分查找的方式进行
    // 我们注意到不管数组的长度如何，只要从中间切就一定至少有一半是有序的
    // 这就告诉我们在常规的二分查找的基础上加上是否有序的判断
    // 如果nums[0] < nums[mid]，说明0 ~ mid之间是有序区
    // 我们在这中间比较target，发现target在这个范围中，那么后面的比较就都是在有序区里面
    // 否则的话就到无序区里面，在无序区里面接续二分在有序区中比较直到找到我们想要的结果
    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)  return mid;
            if (nums[0] <= nums[mid]) {
                // 0 ~ mid之间为有序区域
                if (nums[0] <= target && target < nums[mid])  high = mid - 1;
                else low = mid + 1;
            } else {
                // mid ~ n - 1为有序区
                if (nums[mid] < target && target <= nums[nums.length - 1])  low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
// @lc code=end