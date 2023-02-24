/*
 * @lc app=leetcode.cn id=123 lang=java
 *
 * [123] 买卖股票的最佳时机 III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 定义四个变量来维护第i天结束的状态
        // buy1表示第一次买入后的最大利润
        // sell1表示第一次出售的最大利润
        // buy2表示第二次买入的最大利润
        // sell2表示第二次出售的最大利润
        int buy1 = prices[0];
        int sell1 = 0;
        int buy2 = prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; ++i) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }
}
// @lc code=end

