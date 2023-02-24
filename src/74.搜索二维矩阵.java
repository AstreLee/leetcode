/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 首先确定行数
        int row = 0;
        int i = 0;
        for (; i < matrix.length; ++i) {
            if (matrix[i][0] > target)  {
                if (i != 0) {
                    row = i - 1;
                    break;
                }
                else break;
            }
            if (matrix[i][0] == target) {
                if (i != 0) {
                    row = i;
                    break;
                }
                else break;
            }
        }
        if (i == matrix.length)  row = matrix.length - 1;
        // 接下来确定列数
        for (int j = 0; j < matrix[0].length; ++j) {
            if (matrix[row][j] == target)
                return true;
        }
        return false;
    }
}
// @lc code=end