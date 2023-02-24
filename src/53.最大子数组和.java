/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        // 实际上采用DP也是可以的, 但是由于DP只和前面位置的数有关系
        // 所以我们也可以用两个变量来维护s
        // 采用滚动数组的思想
        int temp = 0;
        int max = nums[0];
        for (int item : nums) {
            temp = Math.max(temp + item, item);
            max = Math.max(temp, max);
        }
        return max;
    }
}
// @lc code=end
