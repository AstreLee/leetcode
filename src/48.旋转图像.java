/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        // int n = matrix.length;
        // for (int i = 0; i < matrix.length / 2; ++i) {
        //     for (int j = i; j < matrix.length - 1 - i; ++j) {
        //         swap(matrix, i, j, n);
        //     }
        //     n -= 1;
        // }

        // ---------------- 分割线 ------------------
        // 实际上还可以先上下翻转，再沿主对角线翻转
        // 线代学得好，算法不会差。。。。。
        for (int i = 0; i < matrix.length / 2; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = temp;
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = i + 1; j < matrix.length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void swap(int[][] nums, int i, int j, int n) {
        int temp = nums[j][n - 1];
        nums[j][n - 1] = nums[i][j];
        int temp1 = nums[n - 1][n - j - 1 + i];
        nums[n - 1][n - j - 1 + i] = temp;
        int temp2 = nums[n - j - 1 + i][i];
        nums[n - j - 1 + i][i] = temp1;
        nums[i][j] = temp2;
    }
}
// @lc code=end

