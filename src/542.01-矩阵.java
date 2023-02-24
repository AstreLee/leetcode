import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=542 lang=java
 *
 * [542] 01 矩阵
 */

// @lc code=start
class Solution {
    // 定义标记数组
    public int[][] book;
    // 定义举例最近的0的距离
    public int minPath = 0x3f3f3f3f;
    // 定义结果矩阵
    public int[][] ans;
    // 定义方向矩阵
    public int[][] next = {
            { 0, 1 }, // 向右走
            { 0, -1 }, // 向左走
            { 1, 0 }, // 向下走
            { -1, 0 } // 向上走
    };

    public int[][] updateMatrix(int[][] mat) {
        // 初始化book标记数组
        book = new int[mat.length][mat[0].length];
        // 初始化结果矩阵
        ans = new int[mat.length][mat[0].length];
        // 遍历开始
        // for (int i = 0; i < mat.length; ++i) {
        //     for (int j = 0; j < mat[0].length; ++j) {
        //         if (mat[i][j] != 0) {
        //             book[i][j] = 1; // 自己已经走过
        //             BFS(mat, i, j);
        //             ans[i][j] = minPath;
        //             minPath = 0x3f3f3f3f;
        //             // bfs清空所有的标记
        //             for (int k = 0; k < book.length; ++k) {
        //                 Arrays.fill(book[k], 0);
        //             }
        //         }
        //     }
        // }
        // // 返回结果矩阵
        // return ans;
        // BFS1(mat);
        DP(mat);
        return ans;
    }

    // 使用DFS深搜寻找最短路径
    public void DFS(int[][] mat, int x, int y, int path) {
        if (mat[x][y] == 0) {
            minPath = Math.min(path, minPath);
            return;
        }
        // 遍历四个方向
        for (int i = 0; i < 4; ++i) {
            int tx = x + next[i][0];
            int ty = y + next[i][1];
            // 如果越界的话continue
            if (tx >= mat.length || ty >= mat[0].length || tx <= -1 || ty <= -1)
                continue;
            // 看book标记数组
            if (book[tx][ty] == 0) {
                // 没有访问过的继续访问
                book[tx][ty] = 1;
                // 然后继续深搜
                DFS(mat, tx, ty, path + 1);
                // 搜索完成后记得取消数组的标记，方便下次继续访问
                book[tx][ty] = 0;
            }
        }
    }

    // 使用BFS遍历寻找
    public void BFS(int[][] mat, int x, int y) {
        Deque<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        while (!q.isEmpty()) {
            // 首先出队一个元素
            Node node = q.poll();
            // 遍历四个方向
            for (int i = 0; i < 4; ++i) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                int step = node.step + 1;
                // 如果越界的话continue
                if (tx >= mat.length || ty >= mat[0].length || tx <= -1 || ty <= -1) continue;
                // 如果是0的话更新最小值
                if (mat[tx][ty] == 0) {
                    minPath = Math.min(step, minPath);
                    continue;
                }
                // book标记
                if (book[tx][ty] == 0) {
                    book[tx][ty] = 1;
                    q.offer(new Node(tx, ty, step));
                }
            }
        }
    }

    // 实际上上面的BFS算法每次只能更新一个1格子到最近的0的距离
    // 但是实际上我们可以看做是多源点问题，将所有的0全部添加进去
    // 然后从0开始依次向外辐射
    public void BFS1(int[][] mat) {
        // 遍历矩阵，将所有的0全部添加进去
        // 当然首先还是要创建一个队列
        Deque<Node> q = new LinkedList<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 0) {
                    q.offer(new Node(i, j, 0));
                    ans[i][j] = 0;
                }
            }
        }
        // 当队列不空的时候继续
        while (! q.isEmpty()) {
            // 首先出队一个元素
            Node node = q.poll();
            // 再遍历四个方向
            for (int i = 0; i < 4; ++i) {
                int tx = node.x + next[i][0];
                int ty = node.y + next[i][1];
                // 如果越界的话继续
                if (tx >= mat.length || ty >= mat[0].length || tx <= -1 || ty <= -1)  continue;
                // 如果没有访问过并且是1的话就添加进去
                if (book[tx][ty] == 0 && mat[tx][ty] == 1) {
                    book[tx][ty] = 1;  // 首先标记已经走过
                    q.offer(new Node(tx, ty, node.step + 1));
                    ans[tx][ty] = node.step + 1;
                }
            }
        }
    }


    // 当然。。。。。还可以使用动态规划的思想来解题
    public void DP(int[][] mat) {
        // 首先初始化我们的ans数组，将所有结果全部设置为最大值
        for (int i = 0; i < mat.length; ++i) {
            Arrays.fill(ans[i], 0x3f3f3f3f);
        }
        // 然后将矩阵中所有为0的位置相对应的在ans中进行更新
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                if (mat[i][j] == 0)  ans[i][j] = 0;
            }
        }
        int m = mat.length;
        int n = mat[0].length;
        // 最后遍历四种情况
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                }
            }
        }
        // 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = 0; j < n; ++j) {
                if (i + 1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
                }
            }
        }
        // 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i - 1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                }
                if (j + 1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                }
            }
        }
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
                }
            }
        }
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
