import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 方法一：使用的是之前的两数之和加上遍历
        // 时间复杂度为O(n ^ 2)
        // 这题额和之前的有什么区别？--> 区别就是之前那题数组是无序的，但是这题是有序的
        // 要充分利用数组有序的特性
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < numbers.length; ++i) {
        //     if (map.containsKey(target - numbers[i])) {
        //         return new int[]{map.get(target - numbers[i]) + 1, i + 1};
        //     } else {
        //         map.put(numbers[i], i);
        //     }
        // }
        // return new int[]{};
        // return new int[]{index1, index2};
        
        // --------------- 分割线 ----------------------
        // 方法二：首先固定第一个数的位置，然后第二个数使用二分查找的方法
        // 这个实际上就是通过二分查找将第二次找的时间复杂度降低到O(n * logn)
        // for (int i = 0; i < numbers.length; ++i) {
        //     int low = i + 1;
        //     int high = numbers.length - 1;
        //     while (low <= high) {
        //         int mid = low + (high - low) / 2;
        //         if (numbers[mid] > target - numbers[i])  high = mid - 1;
        //         else if (numbers[mid] < target - numbers[i])  low = mid + 1;
        //         else return new int[]{i + 1, mid + 1};
        //     }
        // }
        // return new int[]{};

        // -------------------- 分割线 -------------------------
        // 方法三：使用双指针的方法
        int i = 0;
        int j = numbers.length - 1;
        while (true) {
            if (numbers[i] + numbers[j] < target) ++i;
            else if (numbers[i] + numbers[j] > target) --j;
            else break;
        }
        return new int[]{i + 1, j + 1};
    }
}
// @lc code=end

