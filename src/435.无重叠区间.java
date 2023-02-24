import java.util.*;
/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 能够重合的区间一定是连续的，这个证明在之前类似的一道题中已经说过了
        // 这样的话我们只用遍历原来的数组中的每一个二元组
        // 然后看看右边界和下一个左边界之间的关系
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])  return -1;
                else if (o1[0] > o2[0])  return 1;
                else return o1[1] - o2[1];
            }
        });
        // 然后如果第一个元素相同的话，后面所有同类的全部去掉
        int delCount = 0;
        int j = 0;
        for (int i = 0; i < intervals.length && j < intervals.length;) {
            if (intervals[i][0] == intervals[j][0]) {
                while (j < intervals.length && intervals[i][0] == intervals[j][0]) ++j;
                delCount += j - i - 1;
            } else {
                if (intervals[i][1] > intervals[j][0]) {
                    int k = j;
                    while (j < intervals.length && intervals[k][0] == intervals[j][0]) ++j;
                    delCount += j - k;
                } else {
                    i = j;
                }
            }
        }
        return delCount;
    }
}
// @lc code=end

