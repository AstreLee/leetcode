/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 方法一：直接查找
        // for (int i = 0; i < matrix.length; ++i) {
        //     for (int j = 0; j < matrix[0].length; ++j) {
        //         if (matrix[i][j] == target)  return true;
        //     }
        // }
        // return false;



        // 方法二：对每一行使用二分查找
        // for (int[] arr : matrix) {
        //     if (BinarySearch(arr, target) != -1)  return true;
        // }
        // return false;



        // 方法三：Z字形查找
        // 假设当前位置为(i, j)，那么我们就以原矩阵左下角为左下角
        // 以(i, j)为右上角作为新的矩阵进行搜索
        // 若matrix[i][j] == target返回true
        // 若matrix[i][j] > target, 由于列是递增的，所以这个元素的
        // 下面所有元素都比target要大，所以--j
        // 若matrix[i][j] < target，由于行是递增的，所以这个元素的
        // 左边所有元素都比target要小，所以++i
        // 当i或者j出边界的时候循环结束
        // 实际上这种方式就是每次排除了一行或者一列
        // 用行二分的话一次只能排除一半
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target)  return true;
            else if (matrix[i][j] < target) ++i;
            else --j;
        }
        return false;
    }
    
    public int BinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < target)  low = mid + 1;
            else if (arr[mid] > target)  high = mid - 1;
            else return mid;
        }
        return -1;
    }
}
// @lc code=end

