import java.util.*;
/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // // 方法一：使用map
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i : nums) {
        //     if (! map.containsKey(i)) {
        //         map.put(i, 1);
        //     } else {
        //         map.replace(i, map.get(i) + 1);
        //     }
        // }
        // int ans = 0;
        // for (int i : nums) {
        //     if (map.get(i) > nums.length / 2) {
        //         ans = i;
        //         break;
        //     }
        // }
        // return ans;

        // ------------------------- 分割线 ----------------------------
        // 方法二：可以将数组排序后再查找
        // if (nums.length == 1)  return nums[0];
        // Arrays.sort(nums);
        // int ans = 0;
        // for (int i = 0; i < nums.length; ) {
        //     if (i < nums.length - 1 && nums[i + 1] == nums[i]) {
        //         int j = i + 1;
        //         while (j < nums.length && nums[j] == nums[i]) ++j;
        //         if (j - i > nums.length / 2) {
        //             ans = nums[i];
        //             break;
        //         }
        //         i = j;
        //     } else ++i;
        // }
        // return ans;


        // ---------------------- 分割线 ---------------------------
        // !!!!!!!!真的是榆木脑袋，大于n / 2排序后不就是中间的数字？？？
        // Arrays.sort(nums);
        // return nums[nums.length / 2];

        // ---------------------- 分割线 --------------------------
        // 实际上还可以采用分治的办法
        // 可以证明如果a元素在数组中出现的次数大于长度的一半
        // 那么至少是左边或者右边的众数
        // return MaiorityNum(nums, 0, nums.length - 1);
        return Moore(nums);
    }

    public int CountRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; ++i) {
            if (nums[i] == num)  ++count;
        }
        return count;
    }

    public int MaiorityNum(int[] nums, int low, int high) {
        // 如果分治最后只有一个数字的话那么众数就是自己
        if (low == high)  return nums[low];
        int mid = (high - low) / 2 + low;
        // 获取左半部分的众数
        int left = MaiorityNum(nums, low, mid);
        // 获取右半部分的众数
        int right = MaiorityNum(nums, mid + 1, high);
        // 如果左半部分和右半部分的众数是相等的，那么就是low和high之间的众数
        if (left == right) {
            return left;
        }
        // 否则的话在low和high中选出合适的众数
        int countLeft = CountRange(nums, left, low, high);
        int countRight = CountRange(nums, right, low, high);
        return countLeft > countRight ? left : right;
    }

    // 还可以采用Moore摩尔投票法
    // 摩尔投票法采用一个candidate指向我们的候选人
    // count用来表示候选人所获得的票数
    // 我们依次遍历数组，当count=0的时候就将对应元素赋值给candidate
    // 否则的话如果等于自己，那自己肯定要支持自己所以++count
    // 如果不是自己，那么其它候选人肯定要反对，所以--count
    // 如果count=0就要换届选举，因为Majority的数量一定大于一半
    // 所以最后剩下的一定是最多的那个众数
    public int Moore(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int i : nums) {
            if (count == 0)  candidate = i;
            count += (i == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
// @lc code=end

