import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        // ------------------ 有一说一这种方法真的emmm.....-----------
        // if (s.length() == 1) return 0;
        // // 最直观的想法：就是遍历每一个字符，看看后面是不是有重复的
        // for (int i = 0; i < s.length(); ++i) {
        // boolean isRepeat = false;
        // for (int j = 0; j < s.length(); ++j) {
        // if (s.charAt(i) == s.charAt(j) && i != j) {
        // isRepeat = true;
        // break;
        // }
        // }
        // if (! isRepeat) return i;
        // }
        // return -1;
        // ----------------- 分割线 -------------------------

        // ----------------- 分割线 -------------------------
        // 使用map哈希表试一下，前面表示字符，后面表示位置
        // 这还是太慢了？？？
        // 实际上这是使用哈希表存放索引值的方法
        // 哈哈，第一次和答案想的一模一样
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (! map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                map.replace(s.charAt(i), map.get(s.charAt(i)), -1);
            }
        }
        int index = s.length();
        for (char c : map.keySet()) {
            if (map.get(c) >= 0 && map.get(c) <= index)  index = map.get(c);
        }
        if (index == s.length())  return -1;
        return index;
        // --------------- 分割线 ----------------

        // --------------- 分割线 ----------------
        // 实际上还可以使用哈希表存放词频
        // Map<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < s.length(); ++i) {
        //     if (! map.containsKey(s.charAt(i))) {
        //         map.put(s.charAt(i), 1);
        //     } else {
        //         map.replace(s.charAt(i), map.get(s.charAt(i)) + 1);
        //     }
        // }
        // // 再来遍历s中的每一个字符
        // for (int i = 0; i < s.length(); ++i) {
        //     if (map.get(s.charAt(i)) == 1)  return i;
        // }
        // return -1;
    }
}
// @lc code=end
