import javax.sound.sampled.SourceDataLine;

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int count = 1;
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int len = n;
        for (int i = 0; i < n / 2; ++i) {
            matrixFill(matrix, i, len);
            --len;
        }
        if (n % 2 != 0)  matrix[n / 2][n / 2] = n * n;
        return matrix;
    }

    public void matrixFill(int[][] matrix, int pos, int n) {
        // 第一排
        for (int i = pos; i < n; ++i) {
            matrix[pos][i] = count;
            ++count;
        }
        // 最后一列
        for (int i = pos + 1; i < n; ++i) {
            matrix[i][n - 1] = count;
            ++count;
        }
        // 最后一排
        for (int i = n - 2; i >= pos; --i) {
            matrix[n - 1][i] = count;
            ++count;
        }
        // 第一列
        for (int i = n - 2; i > pos; --i) {
            matrix[i][pos] = count;
            ++count;
        }
    }
}
// @lc code=end

