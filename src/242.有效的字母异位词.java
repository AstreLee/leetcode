import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        // 还是使用Map进行处理
        // 为什么这个过不了？？？？？？？？
        // if (s.length() != t.length())  return false;
        // Map<Character, Integer> map1 = new HashMap<>();
        // for (char c : s.toCharArray()) {
        //     if (! map1.containsKey(c)) {
        //         map1.put(c, 1);
        //     } else {
        //         map1.replace(c, map1.get(c) + 1);
        //     }
        // }
        // Map<Character, Integer> map2 = new HashMap<>();
        // for (char c : t.toCharArray()) {
        //     if (! map2.containsKey(c)) {
        //         map2.put(c, 1);
        //     } else {
        //         map2.replace(c, map2.get(c) + 1);
        //     }
        // }
        // for (char c : map1.keySet()) {
        //     if (map2.containsKey(c)) {
        //         if (map1.get(c) != map2.get(c))  return false;
        //     } else {
        //         return false;
        //     }
        // }
        // return true;

        // ------------------ 分割线 -------------------
        // 这实际是上也是计数的问题，可以用数组解决
        int[] ans1 = new int[26];
        int[] ans2 = new int[26];
        for (char c : s.toCharArray()) {
            ++ans1[c - 97];
        }
        for (char c : t.toCharArray()) {
            ++ans2[c - 97];
        }
        for (int i = 0; i < 26; ++i) {
            if (ans1[i] != ans2[i])  return false;
        }
        return true;
        // -----------------  分割线 ---------------------

        // ----------------- 分割线 ----------------
        // 实际上还可以排序哈哈哈哈哈
        // 不过没有数组块
        // if (s.length() != t.length())  return false;
        // char[] arr1 = s.toCharArray();
        // char[] arr2 = t.toCharArray();
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        // return Arrays.equals(arr1, arr2);

        

        // 这里来一个小结：以后这种字符串计数问题都可以采用这种数组计数的方法
        // 当然Map字典也还是要掌握的
    }
}
// @lc code=end

