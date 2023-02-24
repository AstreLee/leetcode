import java.util.List;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // if (triangle == null)  return 0;
        // List<List<Integer>> list = new ArrayList<>();
        // // 首先初始化前面两层的元素
        // list.add(new ArrayList<>());
        // list.get(0).add(triangle.get(0).get(0));
    
        // // 从第二层开始
        // for (int i = 1; i < triangle.size(); ++i) {
        //     list.add(new ArrayList<>());
        //     // 从第一列开始
        //     for (int j = 0; j <= i; ++j) {
        //         // j==0 或者 j==i的时候没有选择
        //         if (j == 0)  list.get(i).add(triangle.get(i).get(0) + list.get(i - 1).get(j));
        //         else if (j == i)  list.get(i).add(triangle.get(i).get(j) + list.get(i - 1).get(j - 1));
        //         else {
        //             // 只有j不在头尾的时候才有机会选择
        //             int numLeft = list.get(i - 1).get(j - 1);
        //             int numRight = list.get(i - 1).get(j);
        //             int num = triangle.get(i).get(j);
        //             list.get(i).add(numLeft < numRight ? numLeft + num : numRight + num);
        //         }
        //     }
        // }

        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < triangle.get(triangle.size() - 1).size(); ++i) {
        //     min = Math.min(list.get(list.size() - 1).get(i), min);
        // }
        // return min;

        // -------------------------- 分割线 ---------------------------------------
        // 优化方法
        return fun1(triangle);
    }

    public int fun1(List<List<Integer>> list) {
        // 这个和背包问题的一维数组空间优化实际上是有点像的
        // 遍历到(i, j)位置的时候，数组的f[0] ~ f[j]全部是前面i - 1行的
        // 而f[j + 1] ~ f[i]则是第i行更新覆盖过的
        // 这就是为什么要倒着来
        // 使用一维数组优化空间复杂度
        int[] f = new int[list.size()];
        // 初始化f[0]
        f[0] = list.get(0).get(0);
        for (int i = 1; i < list.size(); ++i) {
            f[i] = f[i - 1] + list.get(i).get(i);
            for (int j = i - 1; j >= 1; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + list.get(i).get(j);
            }
            f[0] += list.get(i).get(0);
        }
        int min = f[0];
        for (int i = 1; i < list.size(); ++i) {
            min = Math.min(min, f[i]);
        }
        return min;
    }
}
// @lc code=end

