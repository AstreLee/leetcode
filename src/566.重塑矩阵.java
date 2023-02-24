/*
 * @lc app=leetcode.cn id=566 lang=java
 *
 * [566] 重塑矩阵
 */

// @lc code=start
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // -------------------- 分割线 ----------------------------
        // 这是用一维数组进行过度的，实际上比较笨拙
        // 这题比较简单，就是单纯的模拟就行了
        // 首先要看看这样的矩阵能否构成，只有当mat.length * mat[0].legnth == r * c的时候才行
        if (mat.length * mat[0].length != r * c)  return mat;
        else {
            int[] ans = new int[mat.length * mat[0].length];
            int count = 0;
            for (int[] arr : mat) {
                for (int item : arr) {
                    ans[count] = item;
                    ++count;
                }
            }
            int[][] res = new int[r][c];
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    res[i][j] = ans[i * c + j];
                }
            }
            return res;
        }
        // --------------------- 分割线 ------------------------

        // --------------------- 分割线 ------------------------
        // 二维数组arr[i][j] ---> i * 列 + j转化成对应的第几个元素
        // 第x个元素对应到m * n矩阵的位置为x / n; x % n
        // int[][] ans = new int[r][c];
        // if (mat.length * mat[0].length != r * c)  return mat;
        // for (int x = 0; x < r * c; ++x) {
        //     ans[x / c][x % c] = mat[x / mat[0].length][x % mat[0].length];
        // }
        // return ans;
    }
}
// @lc code=end

