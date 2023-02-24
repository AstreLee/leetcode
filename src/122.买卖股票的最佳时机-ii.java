/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // ------------------- 分割线 ----------------------
        // 方法一：使用动态规划的思想
        // dp[i][0]表示第i天交易结束的时候手头里没有股票
        // dp[i][1]表示第i天交易结束的时候手头里有股票
        // dp[i][0] = MAX{dp[i - 1][0], dp[i - 1][1] + price[i]}
        // dp[i][1] = MAX{dp[i - 1][0] - price[i], dp[i - 1][1]}
        // 由于最后一天股票卖出的收益肯定要比不卖出要大，所以dp[i][0]就是我们所要的结果
        // int[][] dp = new int[prices.length][2];
        // // 给第一天初始化一下
        // dp[0][0] = 0;
        // dp[0][1] = -prices[0];
        // for (int i = 1; i < prices.length; ++i) {
        //     dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        //     dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        // }
        // return dp[prices.length - 1][0];
        // ------------------- 分割线 ----------------------


        // ------------------- 分割线 ----------------------
        // 方法二采用贪心的策略
        // 实际上这题的要求就是要我们找x个不相交的区间[si, ej]
        // [si, ej]这个区间的贡献价值为ej - si
        // 这样的区间当然越多越好(但是注意不能相交)
        // 实际上ej - si = (ej - ej-1) + (ej-1 - ej-2) + ... + (ei+1 - ei)
        // 也就是这个区间的贡献等价于这若干个长度为1的互不相交的子区间的贡献
        // 那么问题转换为将原序列划分成若干个长度为1的子序列并且统计最大值
        // 按照贪心的思想只要li+1 - li的值大于0就算是有贡献
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - prices[i - 1] > 0)  ans += prices[i] - prices[i - 1];
        }
        return ans;
    }
}
// @lc code=end

