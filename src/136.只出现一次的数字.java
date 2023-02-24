import java.util.*;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // // 最容易想到的应该是哈希表
        // Set<Integer> set = new HashSet<>();
        // // 遍历nums数组
        // for (int i : nums) {
        //     if (! set.contains(i))  set.add(i);
        //     else set.remove(i);
        // }
        // return (int) set.toArray()[0];


        // 方法汇总：
        // 1. 使用set集合，遍历数组，set中没有的就添加进去，有的就将其剔除，最后剩余的就是
        // 2. 使用map字典，统计所有出现的数字和词频，最后返回value为1的那个
        // 3. 统计数组中出现的所有数字，∑然后×2，最后减去数组中所有数字之和就是结果

        // 但是实际上还可以采用异或运算
        // a异或0 = a; a 异或 a = 0; a异或b异或c = a异或c异或b
        // 假设数组中有2 * m + 1个数，其中a1,a2,a3..am个数出现两次
        // (a1异或a1)异或(a2异或a2)...异或(am异或am)异或am+1
        // 最后把括号拆开使用交换律就可以得到这样的结果
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}
// @lc code=end

