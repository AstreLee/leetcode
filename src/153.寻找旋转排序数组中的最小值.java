/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        // 这题和上次的在一次旋转排序数组中寻找target有点区别
        // 只旋转一次，可以保证每次二分的时候都会有一个有序区
        // 但是如果旋转多次的这个性质就不能保证, 原升序数组将
        // 会被打乱成若干升序子数组，这样的话我们可以通过比较
        // nums[high]和nums[mid]的值来寻找最小值
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) high = mid;
            else low = mid + 1;
        }
        return nums[low];

        /*
         * 问题1：为什么nums[mid] < nums[high]的时候是high = mid而不是high = mid - 1;
         * 因为mid同样可能是最小值，比如说：[4, 5, 1, 2, 3]
         * 
         * 问题2：为什么nums[mid] >= nums[high]的时候是low = mid + 1而不是low = mid
         * 举一个例子：[4, 5, 6, 1, 2, 3]这时候恰好是low = mid + 1
         * 但是这样有点牵强，我们不妨想想，如果nums[mid]是最小值的话，那么
         * 一定小于nums[high](这是因为数据没有重复的)，进if而不是else
         * 
         * 问题3：为什么while循环里面不能取=号
         * 举个例子：[*,2,1,*]这样的话low=mid+1恰好指向了1最小值
         * 如果加上了=。就会多一次比较循环，这样的话low = mid + 1
         * 最后返回的结果就应该是low - 1
         */
    }
}
// @lc code=end

