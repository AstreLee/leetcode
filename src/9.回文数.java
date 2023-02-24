/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        // 如果x是负数的话直接返回false
        if (x < 0)  return false;
        // 首先将x转换成字符串
        String str = String.valueOf(x);
        // 如果x的长度是奇数的话
        if (str.length() % 2 != 0) {
            for (int i = str.length() - 1, j = 0; i >= str.length() / 2 && j <= str.length() / 2; --i, ++j) {
                // 只要有不相等的直接返回false
                if (str.charAt(i) != str.charAt(j))  return false;
            }
            return true;
        } else {
            // 当长度为偶数的话
            for (int i = str.length() - 1, j= 0; i >= str.length() / 2 && j <= str.length() / 2 - 1; --i, ++j) {
                // 只要有不相等的就直接返回false
                if (str.charAt(i) != str.charAt(j))  return false;
            }
            return true;
        }
    }
}
// @lc code=end

