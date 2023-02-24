/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return fun(root, val);
    }

    public TreeNode DFS(TreeNode pt, int val) {
        // 如果pt为空的话，则创建节点
        if (pt == null) {
            return new TreeNode(val, null, null);
        }
        if (pt.val < val) {
            pt.right = DFS(pt.right, val);
        } else {
            pt.left = DFS(pt.left, val);
        }
        return pt;
    }

    public TreeNode fun(TreeNode root, int val) {
        if (root == null)  return new TreeNode(val, null, null);
        TreeNode pt = root;
        while (pt != null) {
            if (pt.val < val) {
                if (pt.right == null) {
                    pt.right = new TreeNode(val, null, null);
                    break;
                } else {
                    pt = pt.right;
                }
            } else {
                if (pt.left == null) {
                    pt.left = new TreeNode(val, null, null);
                    break;
                } else {
                    pt = pt.left;
                }
            }
        }
        return root;
    }
}
// @lc code=end

