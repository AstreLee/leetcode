import java.util.*;
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

import javax.swing.tree.TreeNode;

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
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // if (root == null)  return false;
        // DFS(root, targetSum);
        // return flag;
        
        // --------------------- 分割线 ---------------------------
        if (root == null)  return false;
        return BFS(root, targetSum);
    }

    public void DFS(TreeNode pt, int targetSum) {
        if (pt == null)  return;
        if (pt.left == null && pt.right == null) {
            // 是叶子结点的情况下
            targetSum -= pt.val;  // 注意叶子结点也要减
            if (targetSum == 0) flag = true;
            return;
        }
        // 否则不是叶子结点
        targetSum -= pt.val;
        // 遍历左子树和右子树
        DFS(pt.left, targetSum);
        DFS(pt.right, targetSum);
    }

    public boolean BFS(TreeNode pt, int targetSum) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> path = new LinkedList<>();  // path队列用来记录路径
        q.offer(pt);
        path.offer(pt.val);
        int level = 0;
        while (! q.isEmpty()) {
            TreeNode top = q.poll();
            int temp = path.poll();
            // 注意是要到叶子结点才进行比较
            if (top.left == null && top.right == null) {
                if (temp == targetSum)  return true;
            }
            if (top.left != null) {
                q.offer(top.left);
                path.offer(temp + top.left.val);
            }
            if (top.right != null) {
                q.offer(top.right);
                path.offer(temp + top.right.val);
            }
        }
        return false;
    }
}
// @lc code=end

