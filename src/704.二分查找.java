/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        // 就是简单的二分查找？
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target)  high = mid - 1;
            else if (nums[mid] < target)  low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
// @lc code=end

