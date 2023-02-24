/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        //------------------ 分割线 -------------------------
        // 方法一：暴力美学(这种方法会超时)
        // int maxProfit = 0;
        // for (int i = 0; i < prices.length - 1; ++i) {
        //     for (int j = i + 1; j < prices.length; ++j) {
        //         if (prices[j] - prices[i] > maxProfit)  maxProfit = prices[j] - prices[i];
        //     }
        // }
        // return maxProfit;
        //------------------ 分割线 ----------------------------


        //----------------------- 分割线 ----------------------------
        // 有没有更快的方法呢？
        // 实际上我们每天都可以出售股票，假设我们第i天出售股票
        // 那么想要利益最大化的话就要知道第i天之前的最低买入价格
        // 我们用minInput这个变量维护第i天前的最低买入价格
        // 在一次遍历的时候每次维护一下minInput并且计算一下最大利润再比较一下就行了
        int minInput = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            minInput = Math.min(prices[i], minInput);
            maxProfit = Math.max(prices[i] - minInput, maxProfit);
        }
        return maxProfit;
    }
}
// @lc code=end

