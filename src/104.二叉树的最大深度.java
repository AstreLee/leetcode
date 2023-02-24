import java.util.*;
/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        // // 采用递归的方式
        // if (root == null)  return 0;
        // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

        // -------------------- 分割线 ------------------------
        return BFS(root);
    }

    // 实际上还可以采用拓展的BFS方法, 不同于一般的BFS
    // 拓展的BFS是将每一层的节点全部出列
    // 我们只需要记录下拓展的次数就行
    public int BFS(TreeNode root) {
        if (root == null)  return 0;
        Queue<TreeNode> q = new LinkedList<>();
        // 将根节点入队
        q.offer(root);
        // 声明整形变量ans记录扩展的次数
        int ans = 0;
        while (! q.isEmpty()) {
            int currentSize = q.size();
            for (int i = 1; i <= currentSize; ++i) {
                TreeNode temp = q.poll();
                // 出队一个元素后看看左右元素是否为空
                if (temp.left != null)  q.offer(temp.left);
                if (temp.right != null)  q.offer(temp.right);
            }
            ans += 1;
        }
        return ans;
    }
}
// @lc code=end

