import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)  return new ArrayList<>();
        if (root.left != null)  postorderTraversal(root.left);
        if (root.right != null)  postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }   
}
// @lc code=end

