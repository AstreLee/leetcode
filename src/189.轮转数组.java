/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // ------- 分割线 ----------
        // 方法一：使用额外的数组空间
        // 这里为什么要使用额外的数组空间呢？
        // 因为我们计算每一个数字轮回后的位置后
        // 如果赋值到原来的位置的话就会导致数据丢失
        // 所以需要一个额外的辅助空间
        // 当然还要注意一下k是可以大于数组的长度的
        // 如果大于数组的长度相当于开启下一轮循环
        // 这个时间复杂度为O(n)，空间复杂度也为O(n)
        // int[] ans = new int[nums.length];
        // // 计算nums每个数字轮回后的位置然后赋值给ans
        // for (int i = 0; i < nums.length; ++i) {
        //     int pos = (i + k) % nums.length;
        //     ans[pos] = nums[i];
        // }
        // for (int i = 0; i < nums.length; ++i) {
        //     nums[i] = ans[i];
        // }
        // -------------------- 分割线 ---------------


        // ------------ 分割线 -------------------
        // 方法二：不申请多余的存储空间，每次将所有的数字平行移动
        // 这个时间复杂度为O(k * n), 空间复杂度为O(1)
        // for (int i = 1; i <= k; ++i) {
        //     int lastNum = nums[nums.length - 1]; // 将最后一个数字记录下来
        //     for (int j = nums.length - 2; j >= 0; --j) {
        //         nums[j + 1] = nums[j];
        //     }
        //     nums[0] = lastNum;
        // }
        // ---------------- 分割线 -------------------


        // --------------- 分割线 -------------------
        // 能不能使用时间复杂度为O(n)，空间复杂度为O(n)的算法呢？
        // 答案当然是可以的，注意到从第一个元素开始，我们每次
        // 计算出相对应的位置，接着保存相对应的位置后再去覆盖
        // int count = 0;
        // for (int i = 0; i < nums.length; ++i) {
        //     int temp = nums[i];
        //     int nextPos = (i + k) % nums.length;
        //     while (true) {
        //         temp = temp + nums[nextPos];
        //         nums[nextPos] = temp - nums[nextPos];
        //         temp = temp - nums[nextPos];
        //         nextPos = (nextPos + k) % nums.length;
        //         ++count;
        //         if (nextPos == i)  break;   
        //     }
        //     nums[i] = temp;
        //     ++count;
        //     if (count == nums.length)  break;
        // }
        // ------------------- 分割线 ------------------
        
        // ------------------- 分割线 ------------------
        // 当然还有数组翻转的方法
        // 1. 首先翻转整个数组
        reverse(nums, 0, nums.length - 1);
        // 2. 然后将0 ~ k % n - 1的数据翻转
        reverse(nums, 0, k % nums.length - 1);
        // 3. 然后将k % n ~ nums.length - 1的数据翻转
        reverse(nums, k % nums.length, nums.length - 1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] += nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            ++start;
            --end;
        }
    }
}
// @lc code=end
