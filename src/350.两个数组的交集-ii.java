import java.util.*;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // --------------- 分割线 ------------------------
        // 方法一：采用哈希表的方式进行存储，老实说这题一开始真的没有读懂题意
        // List<Integer> list = new ArrayList<>();
        // Map<Integer, Integer> map1 = new HashMap<>();
        // for (int i = 0; i < nums1.length; ++i) {
        //     if (! map1.containsKey(nums1[i])) {
        //         map1.put(nums1[i], 1);
        //     } else {
        //         map1.replace(nums1[i], map1.get(nums1[i]), map1.get(nums1[i]) + 1);
        //     }
        // }
        // for (int j = 0; j < nums2.length; ++j) {
        //     if (map1.containsKey(nums2[j]) && map1.get(nums2[j]) >= 1) {
        //         list.add(nums2[j]);
        //         map1.replace(nums2[j], map1.get(nums2[j]), map1.get(nums2[j]) - 1);
        //     } 
        // }
        // // 将list集合转化成数组
        // int[] ans = new int[list.size()];
        // int count = 0;
        // for (Integer i : list) {
        //     ans[count] = i;
        //     ++count;
        // }
        // return ans;
        // ----------------- 分割线 -------------------

        // ----------------- 分割线 -------------------
        // 方法二：有没有想过将两个数组重新排序后再来？
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j])  {
                list.add(nums1[i]);
                ++i; ++j;
            } else if (nums1[i] < nums2[j])  {
                ++i;
            } else {
                ++j;
            }
        }
        int[] ans = new int[list.size()];
        int count = 0;
        for (Integer item : list) {
            ans[count] = item;
            ++count;
        }
        return ans;
    }   
}
// @lc code=end

