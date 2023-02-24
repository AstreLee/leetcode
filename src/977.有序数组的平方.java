import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        // 最直白的方式就是分别平方然后sort
        // 方法一：暴力法
        // for (int i = 0; i < nums.length; ++i) {
        //     nums[i] = nums[i] * nums[i];
        // }
        // Arrays.sort(nums);
        // return nums;

        // --------------- 分割线 ---------------
        // 方法二：让i指向最后一个负数，让j指向第一个正数
        // int[] ans = new int[nums.length];
        // int j = 0;
        // int i = 0;
        // int k = 0;
        // for (; j < nums.length; ++j) {
        //     if (nums[j] >= 0)  break;
        // }
        // i = j - 1;
        // while (i >= 0 && j < nums.length) {
        //     if (Math.abs(nums[i]) < nums[j]) {
        //         ans[k] = nums[i] * nums[i];
        //         ++k; --i;
        //     } else {
        //         ans[k] = nums[j] * nums[j];
        //         ++k; ++j;
        //     }
        // }
        // while (i >= 0) {
        //     ans[k] = nums[i] * nums[i];
        //     ++k; --i;
        // }
        // while (j < nums.length) {
        //     ans[k] = nums[j] * nums[j];
        //     ++k; ++j;
        // }
        // return ans;
        // ------------- 分割线 ----------------------

        // 还有另外一种双指针的思想：倒着来
        int[] ans = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        int k = nums.length - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > nums[j]) {
                ans[k] = nums[i] * nums[i];
                ++i; --k;
            } else {
                ans[k] = nums[j] * nums[j];
                --j; --k;
            }
        }
        return ans;
    }
}
// @lc code=end

