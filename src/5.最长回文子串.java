/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        // 这是原来的想法，会超时，时间复杂度是O(N^3)
        // int maxSize = 0;
        // StringBuilder sbf = new StringBuilder("");
        // // 接下来就是从每个字符开始进行遍历
        // for (int i = 0; i < s.length(); ++i) {
        // for (int j = i + 1; j <= s.length(); ++j) {
        // if (isHuiwenString(s.substring(i, j)) && j - i > maxSize) {
        // maxSize = j - i;
        // sbf.delete(0, s.length());
        // sbf.append(s.substring(i, j));
        // }
        // }
        // }
        // return new String(sbf);

        // -------------------- 分割线 -------------------------------
        // 这是第一种参考解法
        // 首先获取字符串的长度
        int len = s.length();
        if (len <= 1)
            return s; // 一个字符本身就是回文字符串
        boolean[][] dp = new boolean[len][len]; // 创建二维bool数组,dp[i][j]表示从下标i到下标j如果是回文字符串的话dp[i][j]就是true, 否则的话就是false
        // 首先单个字符一定是回文字符
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }
        int start = 0; // start记录下最长回文子串的起始位置
        int maxLen = 1; // maxLen记录下最长回文子串的长度，因为字符串至少要有一个字符，所以长度从1开始
        // 从2开始遍历长度，这里一定要先遍历长度，如果先遍历起始位置的话
        // 不妨考虑下aaaa的预期结果和实际结果是否一致
        // 而且dp动态规划的核心思想也就是根据i+1和j-1中间的结果
        // 长度为i的子串的依赖于i-2的子串结果
        for (int L = 2; L <= len; ++L) {
            for (int i = 0; i < len; ++i) {
                // 根据长度和左边界获取右边界
                int j = i + L - 1;
                if (j >= len)
                    break; // 如果j超过右边界的范围的话就退出当前循环，实际上后面i循环也没有用了
                // 然后判断i和j对应的位置的字符的对应关系
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    // 首先如果长度<=3的时候直接就是true,不需要考虑中间的情况
                    if (L <= 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1]; // 否则的话就是根据中间的字符判断
                }
                // 如果构成回文子串并且Len长度大于maxLen的长度的时候更新起始位置和maxLen
                if (dp[i][j] && L > maxLen) {
                    maxLen = L;
                    start = i;
                }
            }
        }
        // 接下来就是返回最长回文子串
        return s.substring(start, start + maxLen);

        // 这个时间
        // ------------------ 分割线 ----------------------

    }

    // public boolean isHuiwenString(String str) {
    // // 首先如果str的长度为偶数的话
    // if (str.length() % 2 == 0) {
    // for (int i = 0, j = str.length() - 1; i <= str.length() / 2 - 1 && j >=
    // str.length() / 2; ++i, --j) {
    // if (str.charAt(i) != str.charAt(j))
    // return false;
    // }
    // return true;
    // } else {
    // for (int i = 0, j = str.length() - 1; i <= str.length() / 2 - 1 && j >=
    // str.length() / 2 + 1; ++i, --j) {
    // if (str.charAt(i) != str.charAt(j))
    // return false;
    // }
    // return true;
    // }
    // }
}
// @lc code=end
