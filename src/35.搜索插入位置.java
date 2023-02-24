/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        // while结束时，第一点：right一定在left的左面（紧邻），这是由while条件决定的，否则是跳不出来的。 第二点：right右侧数必然是>=target的，left左侧数必然是<target的，，这是由于if条件判断加上left，right的移动引起的。 最后，因为我们要找的是插入位置，就是某位置a左面都小于target，右面（包括a）都大于等于target，那么a就是我们要找的位置。
        // 不管你是存在还是不存在，都是这个位置。
        // 二分查找的变式应用
        // int low = 0;
        // int high = nums.length - 1;
        // while (low <= high) {
        //     int mid = low + (high - low) / 2;
        //     if (nums[mid] < target) low = mid + 1;
        //     else if (nums[mid] > target) high = mid - 1;
        //     else return mid;
        // }
        // return low;

        // 实际上还可以通过加括号的方式
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)  low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }   
}
// @lc code=end

