/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        int j;
        int i = 0;
        while (i < s.length()) {
            j = i;
            while (j < s.length() && s.charAt(j) != ' ')
                ++j;
            if (j == s.length()) {
                s = s.substring(0, i) + reverse(s.substring(i, j));
            } else {
                if (i == 0)
                    s = reverse(s.substring(0, j)) + s.substring(j, s.length());
                else
                    s = s.substring(0, i) + reverse(s.substring(i, j)) + s.substring(j, s.length());
            }
            i = j + 1;
        }
        return s;
    }

    public String reverse(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }
        return new String(arr);
    }
}
// @lc code=end