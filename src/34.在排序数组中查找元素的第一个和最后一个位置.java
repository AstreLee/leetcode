/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)  return new int[]{-1, -1};
        // 使用二分查找就行
        boolean flag = false;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] == target) {
                low = mid + 1;
                flag = true;
            } else high = mid - 1;
        }
        if (! flag) {
            // 如果flag为false，说明中间没有找到相等的
            return new int[]{-1, -1};
        } else {
            // 否则的话从high开始往左遍历
            int lastIndex = high;
            while (high >= 0 && nums[high] == target) --high;
            if (high + 1 == lastIndex) return new int[]{lastIndex, lastIndex};
            else return new int[]{high + 1, lastIndex};
        }
        // 二分不难，但是细节很磨人
    }
}
// @lc code=end

