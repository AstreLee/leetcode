import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {
    // 定义标记数组
    public int[][] book;
    // 定义方向数组
    public int[][] next = {
        {-1, 0},  // 向上走
        {1, 0},  // 向下走
        {0, -1}, // 向左走
        {0, 1}  // 向右走
    };
    // 定义sr, sc落地点处的元素
    int colorSource;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // ------------ 分割线 ------------------
        // // 初始化book数组
        // book = new int[image.length][image[0].length];
        // // 初始colorSource颜色
        // colorSource = image[sr][sc];
        // // 先将自己染色
        // image[sr][sc] = color;
        // // 自己已经走过了
        // book[sr][sc] = 1;
        // // DFS深搜开始
        // DFS(image, sr, sc, color);
        // // 最后返回结果
        // return image;
        // ------------------- 分割线 -------------------------

        // 接下来我们采用广搜的方式进行染色
        // 初始化book数组
        book = new int[image.length][image[0].length];
        // 初始colorSource颜色
        colorSource = image[sr][sc];
        // 先将自己染色
        image[sr][sc] = color;
        // 自己已经走过了
        book[sr][sc] = 1;
        // BFS深搜开始
        BFS(image, sr, sc, color);
        // 返回数组
        return image;
    }

    // 采用DFS遍历的方式染色
    public void DFS(int[][] image, int x, int y, int color) {
        for (int i = 0; i < 4; ++i) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            // 判断tx, ty是否越界
            if (tx >= image.length || ty >= image[0].length || tx <= -1 || ty <= -1)  continue;
            // 判断tx, ty是否在陆地
            if (image[tx][ty] != colorSource)  continue;
            // 判断tx, ty是否访问过，如果没有的话则继续
            if (book[tx][ty] == 0) {
                book[tx][ty] = 1;  // 表示已经访问过
                image[tx][ty] = color;  // 染色
                DFS(image, tx, ty, color);  // 由于不需要找最短路径，所以不用重新置0
            }
        }
    }

    // 采用BFS的方法遍历染色
    public void BFS(int[][] image, int sr, int sc, int color) {
        Queue<Node> q = new LinkedList<>();
        // 首先我们将原点sr和sc入队
        q.offer(new Node(sr, sc));
        // 当队列不为空的时候循环继续
        while (! q.isEmpty()) {
            // 首先q出队一个元素
            Node node = q.poll();
            // 遍历四个方向
            for (int i = 0; i < 4; ++i) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                // 首先看看有没有越界
                if (tx >= image.length || ty >= image[0].length || tx <= -1 || ty <= -1) continue;
                // 再来看看是不是陆地(也就是image[tx][ty] == colorSource吗)
                if (image[tx][ty] != colorSource)  continue;
                // 如果没有走过的话就添加进队列中
                if (book[tx][ty] == 0) {
                    image[tx][ty] = color;
                    book[tx][ty] = 1;
                    q.offer(new Node(tx, ty)); 
                }
            }
        }
    }
}

class Node {
    // image中每一个节点的属性
    int x;  // 表示x横轴的坐标
    int y;  // 表示y纵轴的坐标

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
// @lc code=end