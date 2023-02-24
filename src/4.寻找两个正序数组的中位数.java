/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 首先如果m + n是奇数的话
        if ((nums1.length + nums2.length) % 2 != 0) {
            // 首先定义一个整形变量K，指向合并后的数组的位置
            int k = -1;
            // 定义两个整形变量i和j分别指向nums1和nums2
            int i = 0;
            int j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    ++i;
                    ++k;
                    if (k == ((nums1.length + nums2.length) / 2))
                        return nums1[i - 1];
                } else {
                    ++j;
                    ++k;
                    if (k == ((nums1.length + nums2.length) / 2))
                        return nums2[j - 1];
                }
            }
            // 接下来合并没有合并的
            while (i < nums1.length) {
                ++i;
                ++k;
                if (k == ((nums1.length + nums2.length) / 2))
                    return nums1[i - 1];
            }
            while (j < nums2.length) {
                ++j;
                ++k;
                if (k == ((nums1.length + nums2.length) / 2))
                    return nums2[j - 1];
            }
        } else {
            // 否则的话如果长度为偶数
            int pos1 = -1; // 记录下第一个数的位置
            int pos2 = -1; // 记录下第二个数的位置
            int i = 0;
            int j = 0;
            int k = -1;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    ++i;
                    ++k;
                    if (k == ((nums1.length + nums2.length) / 2 - 1)) {
                        pos1 = nums1[i - 1];
                        continue;
                    }
                    if (k == ((nums1.length + nums2.length)) / 2) {
                        pos2 = nums1[i - 1];
                        return (pos1 + pos2) / 2.0;
                    }
                } else {
                    ++j;
                    ++k;
                    if (k == ((nums1.length + nums2.length) / 2 - 1)) {
                        pos1 = nums2[j - 1];
                        continue; 
                    }
                    if (k == (nums1.length + nums2.length) / 2) {
                        pos2 = nums2[j - 1];
                        return (pos1 + pos2) / 2.0;
                    }
                }
            }
            // 接下来合并没有合并的
            while (i < nums1.length) {
                ++i;
                ++k;
                if (k == ((nums1.length + nums2.length) / 2 - 1)) {
                    pos1 = nums1[i - 1];
                    continue;
                }
                if (k == ((nums1.length + nums2.length)) / 2) {
                    pos2 = nums1[i - 1];
                    return (pos1 + pos2) / 2.0;
                }
            }
            while (j < nums2.length) {
                ++j;
                ++k;
                if (k == ((nums1.length + nums2.length) / 2 - 1)) {
                    pos1 = nums2[j - 1];
                    continue;
                }
                if (k == ((nums1.length + nums2.length)) / 2) {
                    pos2 = nums2[j - 1];
                    return (pos1 + pos2) / 2.0;
                }
            }
        }
        return 0;
}}
// @lc code=end