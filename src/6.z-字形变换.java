/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        // 看起来很简单，但是实际写起来就不一定了
        // 通过周期寻找规律
        if (numRows == 1 || numRows >= s.length()) return s;
        // 周期T
        int T = 2 * numRows - 2;
        // 定义最后的结果字符串
        String ans = "";
        // 首先遍历行，然后再遍历周期
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j + i < s.length(); j += T) {  // 当前周期的第一个字符存在
                ans += s.charAt(j + i);  // 获取当前周期的第一个字符
                if (i > 0 && j + T - i < s.length() && i < numRows - 1) {
                    // i > 0是因为每个周期中第一行之后一个元素
                    // j + T - i < s.length()是指第二个元素存在的情况下
                    // i < numRows - 1是指行数在规定范围内
                    ans += s.charAt(j + T - i);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

