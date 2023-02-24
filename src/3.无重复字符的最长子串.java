import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 注意这类的算法题的边界情况
        if (s.length() == 0)  return 0;//
        // // 采用类似滑动窗口的方式寻找
        // int maxCount = -1;
        // for (int len = 1; len <= s.length(); ++len) {
        //     int i = 0;
        //     while (i + len - 1 < s.length()) {
        //         String temp = s.substring(i, i + len);
        //         if (! isRepeatString1(temp)) {
        //             if (temp.length() > maxCount)  maxCount = temp.length();
        //         }
        //         ++i;
        //     }
        // }
        // return maxCount;
        // int maxCount = -1;
        // Set<Character> set = new HashSet<>();
        // for (int len = 1; len <= s.length(); ++len) {
        //     int i = 0;
        //     while (i + len - 1 < s.length()) {
        //         String temp = s.substring(i, i + len);
        //         for (int j = 0; j < temp.length(); ++j) {
        //             set.add(temp.charAt(j));
        //         }
        //         if (set.size() == temp.length()) {
        //             if (temp.length() > maxCount)  maxCount = temp.length();
        //         }
        //         set.clear();
        //         ++i;
        //     }
        // }
        // return maxCount;

        // int countMax = 0;
        // Set<Character> set = new HashSet<>();
        // 使用双指针
        // for (int i = 0; i < s.length();) {
        //     if (s.length() - i + 1 < countMax)  break;  
        //     int j = 0;
        //     for (; j < s.length(); ++j) {
        //         set.add(s.charAt(j));
        //         if (set.size() != j - i + 1)  break;
        //     }
        //     int k = i;
        //     for (; k <= j; ++k) {
        //         if (s.charAt(k) == s.charAt(j)) break;
        //     }
        //     if (set.size() > countMax) countMax = set.size();
        //     set.clear();
        //     i = k + 1;
        // }
        // return countMax;

        int countMax = 0;
        int rpt = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));  // i右移一个位置后原来位置删除
            }
            while (rpt < s.length() && ! set.contains(s.charAt(rpt))) {
                set.add(s.charAt(rpt));
                ++rpt;
            }
            // 注意更新max或者min的时候使用Math中内置的函数速度更快
            countMax = Math.max(countMax, rpt - i);
        }
        return countMax;
    }

    // 判断字符串中是否有重复字符，如果是的话返回true，
    // 否则返回false
    public boolean isRepeatString(String str) {
        // 遍历str中的每个字符，看看这个字符正着第一次出现
        // 的位置和倒着第一次出现的位置是否相同
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (str.indexOf(ch) != str.lastIndexOf(ch))  return true;
        }
        return false;
    }
    
    // 换哈希表试试？
    public boolean isRepeatString1(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            set.add(str.charAt(i));
        }
        if (set.size() == str.length())  return false;
        else  return true;
    }
}
// @lc code=endd