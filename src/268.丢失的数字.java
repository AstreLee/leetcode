import java.util.*;
/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // // 注意要先排序
        // Arrays.sort(nums);
        // int low = 0;
        // int high = nums.length - 1;
        // while (low <= high) {
        //     int mid = low + (high - low) / 2;
        //     if (nums[mid] <= mid)  low = mid + 1;
        //     else high = mid - 1;
        // }
        // return low;

        // -------------------- 分割线 ----------------------
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; ++i) {
        //     if (nums[i] != i)  return i;
        // }
        // return nums.length;


        // --------------------- 分割线 ----------------------
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < nums.length; ++i) {
        //     set.add(nums[i]);
        // }
        // for (int i = 0; i <= nums.length; ++i) {
        //     if (! set.contains(i)) return i;
        // }
        // return 0;

        // -------------------- 分割线 -------------------------
        int n = nums.length + 1;
        int originSum = (0 + n - 1) * n / 2;
        int arrSum = 0;
        for (int i = 0; i < n -1; ++i) {
            arrSum += nums[i];
        }
        return originSum - arrSum;
    }
}
// @lc code=end

