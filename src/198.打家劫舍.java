/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // 隔项动态规划？
        // 设f(i)为第i间房屋获取的最大值
        // f(i) = Math.max(f(i - 1), f(i - 2) + i);
        // 这是因为房屋有偷和不偷两种状态
        int[] f = new int[nums.length];
        if (nums.length == 1)  return nums[0];
        fun(f, nums);
        return f[f.length - 1];

        // ---------------- 分割线 --------------------
        // if (nums.length == 1)  return nums[0];
        // return fun1(nums);
    }

    public void fun(int[] f, int[] nums) {
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
    }

    public int fun1(int[] nums) {
        // 使用两个变量维护数组
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; ++i) {
            int temp = b;
            b = Math.max(a + nums[i], b);
            a = temp;
        }
        return b;
    }
}
// @lc code=end

