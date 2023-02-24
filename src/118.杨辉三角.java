import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // -------------------- 分割线 ------------------------
        // 这是第一种解法，但是实际上可以直接在嵌套的List循环里面做
        // // 杨辉三角真的是老朋友了
        int[][] triangle = new int[numRows][];
        // // 如果numRows为负数的话直接返回一个空的list
        // if (numRows < 0) return new ArrayList<List<Integer>>();
        // // 首先初始化杨辉三角每一行的第一个和最后一个元素
        // for (int i = 0; i < numRows; ++i) {
        // triangle[i] = new int[i+ 1];
        // triangle[i][0] = triangle[i][i] = 1;
        // }
        // // 再来初始化杨辉三角中的其它元素
        // for (int i = 2; i < numRows; ++i) {
        // for (int j = 1; j < i; ++j) {
        // triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
        // }
        // }
        // // 接着转化为嵌套List集合，直接转换成二位数组不香吗?
        // List<List<Integer>> list = new ArrayList<List<Integer>>();
        // for (int[] arr : triangle) {
        // List<Integer> listSingle = new ArrayList<>();
        // for (int i : arr) {
        // listSingle.add(i);
        // }
        // list.add(listSingle);
        // }
        // return list;
        // --------------------------------------------------
        // 实际上还可以优化一下

        // ----------------- 分割线 -------------------------
        for (int i = 0; i < numRows; ++i) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i)
                    triangle[i][j] = 1;
                else
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int[] arr : triangle) {
            List<Integer> listSingle = new ArrayList<>();
            for (int i : arr) {
                listSingle.add(i);
            }
            list.add(listSingle);
        }
        return list;
            // ----------------- 分割线 -------------------------
            // 直接在嵌套的List集合里面做
            // List<List<Integer>> ret = new ArrayList<List<Integer>>();
            // for (int i = 0; i < numRows; ++i) {
            // List<Integer> row = new ArrayList<Integer>();
            // for (int j = 0; j <= i; ++j) {
            // if (j == 0 || j == i) {
            // row.add(1);
            // } else {
            // row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
            // }
            // }
            // ret.add(row);
            // }
            // return ret;
    }
}
// @lc code=end
