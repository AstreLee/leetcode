import java.util.*;
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    // 1. 声明标记数组
    public int[] book;
    // 2. 声明临时列表空间
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // book = new int[n];
        // int[] nums = new int[k];
        // Set<Set<Integer>> set = new HashSet<Set<Integer>>();
        // DFS(n, k, nums, 0, set);
        // List<List<Integer>> list = new ArrayList<List<Integer>>();
        // for (Set<Integer> item1 : set) {
        //     List<Integer> newList = new ArrayList<>();
        //     for (Integer item2 : item1) {
        //         newList.add(item2);
        //     }
        //     list.add(newList);
        // }
        // return list;

        // ------------------ 分割线 ---------------------

        // 实际上这有点像口罩分配的问题
        // 对于1-n中的每一个整数，都有选择或者不选的可能
        // 既然这样的话我们就分两种情况递归，选中的数往temp中
        // 添加，没有选中的就去掉
        // 这样这递归开始之前加上判断temp.size() == k就行
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        DFS1(1, k, n, list);
        return list;
    }

    // 实际上这个可以看做是在n个数中计算k的全排列，使用集合去重
    public void DFS(int n, int k, int[] nums, int count, Set<Set<Integer>> set) {
        if (count == k) {
            Set<Integer> newSet = new HashSet<>();
            for (int i : nums)  newSet.add(i);
            set.add(newSet);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (book[i] == 0) {
                // 首先标记走过
                book[i] = 1;
                // 然后将数字添加进nums中
                nums[count] = i + 1;
                ++count;
                // 继续递归
                DFS(n, k, nums, count, set);
                // 递归结束记得将标记置0
                book[i] = 0;
                // 然后count也要递减
                --count;
            }
        }
    }

    // 组合问题的标准解法
    // cur表示当前所遍历到的数字
    // 十分典型的回溯
    // 就像把一批口罩分配给两家医院，怎样才能使得两家医院的口罩差的数量最小
    // 这个就是典型的回溯问题，每份口罩都有可能加到两个医院里面：DFS(第一家), DFS(第二家)
    public void DFS1(int cur, int k, int n, List<List<Integer>> list) {
        // 1. 如果temp.size() + n - cur + 1 < k则返回
        if (temp.size() + n - cur + 1 < k)  return;
        // 2. 如果temp.size() = k的话，添加到list中
        if (temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }
        // 3. 如果cur == n + 1的话结束递归
        if (cur == n + 1)  return;
        
        // 接下来就是考虑两种情况：添加和不加
        // 1.1 添加cur
        temp.add(cur);
        // 1.2 递归
        DFS1(cur + 1, k, n, list);
        // 2.1 不添加cur
        temp.remove(temp.size() - 1);
        // 2.2 递归
        DFS1(cur + 1, k, n, list);
    }
}
// @lc code=end

