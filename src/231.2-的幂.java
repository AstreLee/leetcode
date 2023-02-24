/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        // int i = 0;
        // while (true) {
        //     if (Math.pow(2, i) > n)  break;
        //     if (Math.pow(2, i) == n)  return true;
        //     ++i;
        // }  
        // return false;

        // ------------------- 分割线 ------------------
        // 使用位运算
        // 这里不能用int做位移，因为所设置的范围会超过int的范围
        // 这样的话位移就会超出范围
        // 这个位运算本质上emmm... 还是在循环里面
        // 实际上我们可以进一步挖掘二进制数字的规律
        // long i = 1;
        // while (i <= n) {
        //     if (i == n)  return true;
        //     i <<= 1;
        // }
        // return false;


        // ---------------------- 分割线 -----------------
        // 一个2的幂次方的数转化为二进制后有且仅有一个1
        // 假设是a100...0这样的形式(a表示若干高位，全部是0)
        // 那么n - 1 = a011...1这样的话n & (n - 1)就为0
        // return n > 0 && (n & (n - 1)) == 0;

        // -------------- 分割线 ----------------
        // 实际上a100..0这样的形式转换成负数的话，在计算机中存放的补码形式为
        // a非100..0，这样的话n & (-n) == n
        return n > 0 && ((n & (-n)) == n);
    }
}
// @lc code=end

