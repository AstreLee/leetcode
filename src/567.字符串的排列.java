import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // 方法一：使用Arrays.sort排序后再比较
        // char[] arr1 = s1.toCharArray();
        // Arrays.sort(arr1);
        // char[] arr2 = new char[s1.length()];
        // int i = 0;
        // int j = s1.length() - 1;
        // for (; j < s2.length(); ++i, ++j) {
        //     arr2 = s2.substring(i, j + 1).toCharArray();
        //     Arrays.sort(arr2);
        //     boolean isSubstring = true;
        //     for (int t = 0; t < s1.length(); ++t) {
        //         if (arr1[t] != arr2[t]) {
        //             isSubstring = false;
        //             break;
        //         }
        //     }
        //     if (isSubstring)  return true;
        // }
        // return false;


        // ------------------ 分割线 ------------------------


        // 方法2，不使用排序，计数可行？
        // 果然计数还是要快很多，但还有没有更优解？
        if (s1.length() > s2.length())  return false;
        int[] ans1 = new int[26];
        int[] ans2 = new int[26];
        for (char c : s1.toCharArray()) {
            ++ans1[c - 97];
        }
        int i = 0;
        int j = s1.length() - 1;
        for (; j < s2.length(); ++i, ++j) {
            for (char c : s2.substring(i, j + 1).toCharArray()) {
                ++ans2[c - 97];
            }
            if (Arrays.equals(ans1, ans2))  return true;
            else Arrays.fill(ans2, 0);
        }
        return false;


        // ----------------- 分割线 -------------------------

        // 实际上面最开始想的那种方法还可以进行优化
        // 没必要说滑动窗口移动的时候再重新计数，只要将加入窗口和离开
        // 窗口的那两个数产生的硬影响对应到数组中就行了
        // int[] ans1 = new int[26];
        // int[] ans2 = new int[26];
        // // 下面这一行异常处理一定需要，不然的话下面会有问题
        // if (s1.length() > s2.length())  return false;
        // for (char c : s1.toCharArray()) {
        //     ++ans1[c - 'a'];
        // }
        // for (int i = 0; i < s1.length(); ++i) {
        //     ++ans2[s2.charAt(i) - 'a'];
        // }
        // if (Arrays.equals(ans1, ans2)) return true;
        // int i = 1;
        // int j = s1.length();
        // for (; j < s2.length(); ++i, ++j) {
        //     // 首先看看两个字符产生的影响
        //     ++ans2[s2.charAt(j) - 'a'];
        //     --ans2[s2.charAt(i - 1) - 'a'];
        //     if (Arrays.equals(ans1, ans2))  return true;
        // }
        // return false;
    }
}
// @lc code=end