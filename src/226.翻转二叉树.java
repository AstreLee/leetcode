import java.util.*;
/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

import javax.swing.tree.TreeNode;

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        // 递归还是不熟。。。。。。
        // if (root == null)  return root;
        // TreeNode left = invertTree(root.left);
        // TreeNode right = invertTree(root.right);
        // root.left = right;
        // root.right = left;
        // return root;

        // ------------------ 分割线 --------------------------
        if (root == null)  return root;
        BFS2(root);
        return root;
    }

    public void BFS1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()) {
            TreeNode pt = q.poll();
            TreeNode temp = pt.left;
            pt.left = pt.right;
            pt.right = temp;
            if (pt.left != null)  q.offer(pt.left);
            if (pt.right != null)  q.offer(pt.right);
        }
    }

    public void BFS2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()) {
            int currentSize = q.size();
            for (int i = 0; i < currentSize; ++i) {
                TreeNode pt = q.poll();
                TreeNode temp = pt.left;
                pt.left = pt.right;
                pt.right = temp;
                if (pt.left != null)  q.offer(pt.left);
                if (pt.right != null)  q.offer(pt.right);
            }
        }
    }
}
// @lc code=end
