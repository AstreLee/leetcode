import java.util.*;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // 首先根据数组中每一个区间的第一个元素进行排序
        // Arrays.sort(intervals, new Comparator<int[]>() {
        //     @Override
        //     public int compare(int[] interval1, int[] interval2) {
        //         return interval1[0] - interval2[0];
        //     }
        // });
        // 实际上还可以使用lambda表达式
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);
        // 我们注意到可以合并的两个区间一定是连续的，可以使用反证法
        // 假设有三个连续的区间ai, aj, ak，起哄ai和ak是不连续的可以合并的区间
        // 且ai和aj, aj和ak是不可以合并的
        // 那么由ai.end < aj.start <= aj.end < ak.start
        // 但是由于ai和ak是可以合并的，所以有ai.end >= ak.start，有矛盾错误
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            // 首先获取第i个区间的左右边界
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < L) merge.add(new int[]{L, R});
            else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], R);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
// @lc code=end

