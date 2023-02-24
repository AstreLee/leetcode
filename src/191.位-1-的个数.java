/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 1; i <= 32; ++i) {
            if ((n & 1) == 1)  ++count;
            n >>= 1;
        }
        return count;

        // ---------------------------- 分割线 ------------------------
        // 实际上还是可以利用n & (n - 1)这个式子，这个式子是将n最低位的1清零，这样做可以减少循环次数
        // int ans = 0;
        // while (n != 0) {
        //     n &= n - 1;
        //     ++ans;
        // }
        // return ans;
    }
}
// @lc code=end

