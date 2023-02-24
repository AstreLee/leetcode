/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)  return 0;
        // 最简单的遍历
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                if (nums[i] > nums[i + 1])  return i;
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1])  return i;
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])  return i;
            }
        }
        return 0;
    }
}
// @lc code=end

