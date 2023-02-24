/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] 二叉搜索树中的搜索
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
    public TreeNode searchBST(TreeNode root, int val) {
        return search1(root, val);
    }

    public TreeNode search(TreeNode pt, int val) {
        // 如果pt == null则返回null
        if (pt == null)  return null;
        // 如果pt.val == val返回pt
        else if (pt.val == val)  return pt;
        else if (pt.val < val)  return search(pt.right, val);
        else return search(pt.left, val);
    }

    // 递归和迭代的时间差不多
    // 但是迭代的空间复杂度要好很多
    // 注意如果是一颗普通的二叉树只能采用DFS
    // 递归的方式搜索所有的节点看看是否满足
    // 只是恰好BST树有这样的性质所以可以使用
    // 这样的迭代法
    public TreeNode search1(TreeNode pt, int val) {
        while (pt != null) {
            if (pt.val == val)  return pt;
            else if (pt.val < val)  pt = pt.right;
            else pt = pt.left;
        }
        return null;
    }
}
// @lc code=end

