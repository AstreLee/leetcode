/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // ----------- 分割线 ------------------
        // 方法一：暴力，遍历数组中所有的元素，再调用单独定义的函数
        // 判断是否在一行或者一列或者是小九宫格中重复
        // for (int i = 0; i < 9; ++i) {
        //     for (int j = 0; j < 9; ++j) {
        //         if (! isRepeat(i, j, board) && board[i][j] != '.') return false;
        //     }
        // }
        // return true;
        // ---------------------- 分割线 --------------------

        // ---------------------- 分割线 --------------------
        // 使用两个二维数组和一个三维数组
        // 二维数组rows[i][index]表示第i行中index + 1出现的次数
        // 二维数组cols[i][index]表示第i列中index + 1出现的次数
        // 三维数组subbox[i / 3][j / 3][index]表示第i行和第j列的
        // 元素在所属的小九宫格中出现的次数
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] subbox = new int[9][9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - 48 - 1;
                    // 更新行
                    ++rows[i][index];
                    // 更新列
                    ++cols[j][index];
                    // 更新小九宫格中的内容
                    ++subbox[(i / 3) * 3][(j / 3) * 3][index];
                    // 只有index更新过后才有可能大于1
                    if (rows[i][index] > 1 || cols[j][index] > 1 || subbox[(i / 3) * 3][(j / 3) * 3][index] > 1)  return false;
                }
            }
        }
        return true;
    }

    public boolean isRepeat(int i, int j, char[][] board) {
        // 首先判断一行上是否有重复的内容
        for (int k = 0; k < board[0].length; ++k) {
            if (board[i][k] == board[i][j] && k != j)  return false;
        }

        // 再来判断一列上是否有重复的内容
        for (int k = 0; k < board.length; ++k) {
            if (board[k][j] == board[i][j] && k != i)  return false;
        }

        // 再来判断小九宫格中是否有重复的内容
        // 首先计算board[i][j]所属的小九宫格的行和列
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for (int k = row; k < row + 3; ++k) {
            for (int t = col; t < col + 3; ++t) {
                if (board[i][j] == board[k][t] && k != i && t != j)  return false;
            }
        }

        // 如果上面都没有返回的话，那么说明就是没有重复的元素
        return true;
    }
}
// @lc code=end
