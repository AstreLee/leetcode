import javax.xml.namespace.QName;

/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 第一种方式就是遍历32位
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 32; ++i) {
            sb.append(1 & n);
            n >>>= 1;
        }
        // 用Java写位运算的时候注意会有溢出的问题
        // 最好是先用Long再转化成Int
        return (int) Long.parseLong(new String(sb), 2);
    }
}
// @lc code=end

