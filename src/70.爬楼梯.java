/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // 假设f(i)为爬到第i层的种数
        // f(i) = f(i - 1) + f(i - 2)
        return f(n);
    }

    // 递归会超时，可以考虑使用动态规划
    // public int f(int i) {
    //     if (i == 1)  return 1;
    //     else if (i == 2)  return 2;
    //     else return f(i - 1) + f(i - 2);
    // }

    public int f(int n) {
        if (n == 1)  return 1;
        if (n == 2)  return 2;
        int a, b;
        a = 1;
        b = 2;
        for (int i = 3; i <= n; ++i) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
// @lc code=end

