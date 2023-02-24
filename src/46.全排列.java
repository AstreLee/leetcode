import java.util.*;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public int[] book;  // book作为标记数组
    public List<List<Integer>> permute(int[] nums) {
        // List<List<Integer>> list = new ArrayList<List<Integer>>();
        // book = new int[nums.length];
        // DFS(nums, new ArrayList<>(), list);
        // return list;

        // -------------- 分割线 -----------------------
        // 实际上还可以用维护动态数组的方式
        book = new int[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        DFS(nums, output, list);
        return list;
    }

    public void DFS(int[] nums, List<Integer> temp, List<List<Integer>> list) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (book[i] == 0) {
                // book[i] == 0表示还没有访问过
                book[i] = 1;
                // 添加进数组中
                temp.add(nums[i]);
                // 继续DFS递归
                DFS(nums, temp, list);
                // 递归结束后取消对这个点的标记
                book[i] = 0;
                // 记得temp也要去掉这个数
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void DFS1(int n, List<Integer> output, List<List<Integer>> list, int first) {
        if (first == n) {
            // 如果所有的数都已经添加
            list.add(new ArrayList<>(output));
            return;
        }
        // 可以将first ~ n - 1的数字添加进来
        for (int i = first; i < n; ++i) {
            // 首先将已填数组和待填数组对应位置元素进行交换
            Collections.swap(output, first, i);
            // 开启下一轮添加
            DFS1(n, output, list, first + 1);
            // 和标记数组一样也要交换回来
            Collections.swap(output, first, i);
        }
    }
}
// @lc code=end

