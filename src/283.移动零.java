/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        // 很典型的双指针的问题
        // 指针i指向当前最后一个非零元素，指针j用于遍历
        // int i = 0;
        // int j = 0;
        // while (j < nums.length) {
        // if (nums[j] != 0) {
        // // 只要j指向的元素不是非零元素，就赋值给i
        // nums[i] = nums[j];
        // // 注意赋值完毕后i要递增
        // ++i;
        // }
        // // 不管是不是0，j都是要递增的
        // ++j;
        // }
        // // 最后将从i ~ nums.length - 1的数字全部赋值为0
        // while (i < nums.length) {
        // nums[i] = 0;
        // ++i;
        // }

        // -------------- 分割线 --------------------
        // 实际上还有一种改进的办法,最后不用补末尾的0
        // i指针指向最后一个非零元素后面一个元素
        // j指针用于遍历
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                // ----------------------------
                // nums[i] = nums[i] + nums[j];
                // nums[j] = nums[i] - nums[j];
                // nums[i] = nums[i] - nums[j];
                // ----------------------------
                // 注意如果交换的时候涉及到同一位置交换
                // 不能使用上面这种方式，只能使用临时变量
                swap(nums, i, j);
                ++i;
            }
            ++j;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end