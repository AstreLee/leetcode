import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
class Solution {
    // 定义标记数组
    int[][] book;
    // 定义移动数组
    int[][] next = {
        {0, 1},  // 向右走
        {0, -1},  // 向左走
        {1, 0},  // 向下走
        {-1, 0}  // 向上走
    };
    public int orangesRotting(int[][] grid) {
        // 和01矩阵有点像，使用多源点的思想
        return BFS(grid);
    }

    // 多源广度优先搜索，哈哈，居然写出来了，不过还是借鉴了之前的01矩阵的思想
    // 如果不采用这种多源点的BFS的话，而是对每个腐烂的橘子都采用BFS，时间会
    // 长很多
    public int BFS(int[][] grid) {
        // 首先初始化book标记数组
        book = new int[grid.length][grid[0].length];
        // 创建队列
        Deque<Node> q = new LinkedList<>();
        // 遍历矩阵，将烂橘子也就是值为2的全部添加进去
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2)  {
                    q.offer(new Node(i, j, 0));
                    book[i][j] = 1;
                }
            }
        }
        int minMiute = 0;
        // 当队列不为空的时候继续
        while (! q.isEmpty()) {
            // 首先出队一个元素
            Node node = q.poll();
            // 记录下step
            minMiute = node.step;
            // 遍历四个方向
            for (int i = 0; i < 4; ++i) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                // 如果出界的话继续
                if (tx >= grid.length || ty >= grid[0].length || tx <= -1 || ty <= -1)  continue;
                // 如果没有访问过并且有橘子的话就添加进去
                if (book[tx][ty] == 0 && grid[tx][ty] == 1) {
                    book[tx][ty] = 1;
                    grid[tx][ty] = 2;
                    q.offer(new Node(tx, ty, node.step + 1));
                }
            }
        }
        // 再重新遍历一遍我们的矩阵
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1)  return -1;
            }
        }
        return minMiute;
    }
}

class Node {
    int x;
    int y;
    int step;

    public Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
// @lc code=end
