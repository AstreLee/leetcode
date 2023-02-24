/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        // --------------- 分割线 ---------------------
        // 方法一：使用两个标记数组
        // int m = matrix.length;
        // int n = matrix[0].length;
        // boolean[] rows = new boolean[m];  // rows[i]=true表示第i行有0元素
        // boolean[] cols = new boolean[n];  // cols[i]=true表示第i列有0元素
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         if (matrix[i][j] == 0) {
        //             rows[i] = cols[j] = true;
        //         }
        //     }
        // }
        // for (int i = 0; i < m; ++i) {
        //     for (int j = 0; j < n; ++j) {
        //         if (rows[i] || cols[j]) {
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // ------------------- 分割线 -------------------------------

        // ------------------- 分割线 -------------------------------
        // 方法二：使用第一行第一列作为标记数组，但是这样的话就会导致第一行和第一列中的数据被覆盖
        // 所以需要两个标志变量标识一下第一行或者第一列是否有0存在
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flagrows = false, flagcols = false;
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0)  flagcols = true;
        }
        for (int i = 0; i <n; ++i) {
            if (matrix[0][i] == 0)  flagrows = true;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagrows) {
            for (int i = 0; i < n; ++i)  matrix[0][i] = 0;
        }
        if (flagcols) {
            for (int i = 0; i < m; ++i)  matrix[i][0] = 0;
        }
    }
}
// @lc code=end

