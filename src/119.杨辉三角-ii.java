import java.util.*;
/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // List<List<Integer>> list = new ArrayList<>();
        // for (int i = 0; i <= rowIndex; ++i) {
        // list.add(new ArrayList<>());
        // for (int j = 0; j <= i; ++j) {
        // if (j == 0 || j == i) list.get(i).add(1);
        // else {
        // list.get(i).add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
        // }
        // }
        // }
        // return list.get(rowIndex);

        // ------------------------ 分割线 --------------------------
        // 实际上注意到f[i][j]只与f[i - 1][..]有关，所以我们可以使用两个一维数组维护
        // List<Integer> arr1 = new ArrayList<>();
        // List<Integer> arr2 = new ArrayList<>();
        // for (int i = 0; i <= rowIndex; ++i) {
        //     for (int j = 0; j <= i; ++j) {
        //         if (j == 0)
        //             arr2.add(1);
        //         else if (j == i)
        //             arr2.add(1);
        //         else
        //             arr2.add(arr1.get(j - 1) + arr1.get(j));
        //     }
        //     arr1.clear();
        //     for (int k = 0; k <= i; ++k) {
        //         arr1.add(arr2.get(k));
        //     }
        //     if (i == rowIndex)
        //         break;
        //     else
        //         arr2.clear();
        // }
        // return arr2;

        // --------------- 分割线 -----------------------
        // 实际上还可以只使用O(rowIndex)的空间复杂度解决问题
        int[] ans = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == i)  ans[j] = 1;
                else if (j == 0)  ans[j] = 1;
                else ans[j] = ans[j - 1] + ans[j];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i)  list.add(ans[i]);
        return list;
    }
}
// @lc code=end