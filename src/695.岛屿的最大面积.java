import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    // 定义标记数组
    public int[][] book;
    // 定义行走方向
    public int[][] next = {
        {0, 1},  // 向右走
        {0, -1},  // 向左走
        {1, 0},  // 向下走
        {-1, 0}  // 向上走
    };
    // 定义岛屿最大面积变量maxArea
    public int maxArea = 0;
    // 定义在遍历过程中的变量area
    // 注意这里如果在函数传递过程中，可能会出现问题？
    public int area = 1;

    public int maxAreaOfIsland(int[][] grid) {
        // // 首先初始化我们的book数组
        // book = new int[grid.length][grid[0].length];
        // // 然后就要开始遍历图中的所有节点
        // for (int i = 0; i < grid.length; ++i) {
        //     for (int j = 0; j < grid[0].length; ++j) {
        //         // 记得遍历之前自己是已经走过的了
        //         // 如果grid[i][j] == 1的话就开始DFS并且没有走过
        //         if (grid[i][j] == 1 && book[i][j] == 0)  {
        //             book[i][j] = 1;
        //             DFS(grid, i, j);
        //         }
        //         area = 1;
        //     }
        // }
        // return maxArea;
        
        // ----------------------- 分割线 -------------------------------
        // 首先初始化book数组
        book = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1 && book[i][j] == 0) {
                    book[i][j] = 1;
                    BFS(grid, i, j);    
                }
                area = 1;
            }
        }
        return maxArea;
    }

    // 定义DFS寻找岛屿最大面积
    public void DFS(int[][] grid, int x, int y) {
        // 如果只有一个节点的话下面这一句很重要
        maxArea = Math.max(area, maxArea);
        // 遍历四个方向
        for (int i = 0; i < 4; ++i) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            // 如果越界则换方向
            if (tx >= grid.length || ty >= grid[0].length || tx <= -1 || ty <= -1)  continue;
            // 如果不是陆地的话换方向
            if (grid[tx][ty] != 1)  continue;
            // 如果节点没有被访问过的话则继续访问
            if (book[tx][ty] == 0) {
                // 首先area递增
                ++area;
                // area和maxArea作比较取最大值
                maxArea = Math.max(area, maxArea);
                // 这个点标记走过
                book[tx][ty] = 1;
                // 继续递归
                DFS(grid, tx, ty);
            }
        }
    }

    // 定义BFS寻找岛屿面积的最大值
    public void BFS(int[][] grid, int x, int y) {
        // 既然能够进来说明至少有一个面积
        maxArea = Math.max(area, maxArea);
        // 首先初始化一个队列
        Queue<Node> q = new LinkedList<>();
        // 然后将我们传入的这个节点进队列
        q.offer(new Node(x, y));
        // 当队列不为空的时候我们继续
        while (! q.isEmpty()) {
            // 首先出队元素
            Node node = q.poll();
            // 遍历四个方向
            for (int i = 0; i < 4; ++i) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                // 越界继续
                if (tx >= grid.length || ty >= grid[0].length || tx <= -1 || ty <= -1)  continue;
                // 不是陆地的话继续
                if (grid[tx][ty] != 1)  continue;
                // 否则的话看book标记数组这一点有没有访问过
                if (book[tx][ty] == 0) {
                    // 首先将该点标记
                    book[tx][ty] = 1;
                    // 然后area递增
                    ++area;
                    // 更新maxArea
                    maxArea = Math.max(maxArea, area);
                    // 将这个点进队列
                    q.offer(new Node(tx, ty));
                }
            } 
        }
    } 
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// @lc code=end

