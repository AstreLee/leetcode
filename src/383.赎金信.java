import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 这不是单纯的找子串的问题
        // 实际上就是要求ransonNote中的每个字符都要在magazine中出现过
        // 使用两个map存储各自的个数？
        // 方法可行但是太慢了
        // Map<Character, Integer> map1 = new HashMap<>();
        // for (int i = 0; i < ransomNote.length(); ++i) {
        //     if (! map1.containsKey(ransomNote.charAt(i))) {
        //         map1.put(ransomNote.charAt(i), 1);
        //     } else {
        //         map1.replace(ransomNote.charAt(i), map1.get(ransomNote.charAt(i)) + 1);
        //     }
        // }
        // Map<Character, Integer> map2 = new HashMap<>();
        // for (int i = 0; i < magazine.length(); ++i) {
        //     if (! map2.containsKey(magazine.charAt(i))) {
        //         map2.put(magazine.charAt(i), 1);
        //     } else {
        //         map2.replace(magazine.charAt(i), map2.get(magazine.charAt(i)) + 1);
        //     }
        // }
        // for (char c : map1.keySet()) {
        //     if (map2.containsKey(c)) {
        //         if (map2.get(c) < map1.get(c))  return false;
        //     } else {
        //         return false;
        //     }
        // }
        // return true;

        // ----------------- 分割线------------------
        // 实际上这就是在统计字符的个数，而且告诉了是小写字母
        // 所以可以用一个数组解决问题，上面的Map是正确的思路但是
        // 太复杂了，还有，字符串转成字符数组处理速度可能更快
        // 不是所有情况下使用哈希表都很快，哈希表查询的速度确实快
        // 但是不要忘记了哈希表的建立也是需要时间的
        // 能用数组代替的就尽量使用数组代替
        int[] ans = new int[26];  // 26个英文字母
        for (char c : magazine.toCharArray()) {
            ++ans[c - 97];
        }
        for (char c : ransomNote.toCharArray()) {
            --ans[c - 97];
            if (ans[c - 97] < 0)  return false;
        }
        return true;
    }
}
// @lc code=end

