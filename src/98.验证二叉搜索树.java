import java.util.*;
/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public long pr = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root);
    }
    

    // 使用递归的方式判断，老实说这个并不是很好想
    public boolean isValidBST(TreeNode root, long low, long high) {
        // 如果root==null返回true
        if (root == null)  return true;
        // 如果当前root节点值小于等于low或者大于等于high返回false
        if (root.val <= low || root.val >= high)  return false;
        // 否则的话递归遍历左子树和右子树
        // 注意左子树上的所有值要比root.val小，所以high更新为root.val
        // 注意右子树上的所有值要比root.val大，所以low更新为root.val
        return isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
    }

    // 注意BST的中序序列一定是升序序列，所以我们可以采用
    // 中序遍历的方式，每次遍历到的节点值一定比前面一个节点值大的方式
    public boolean isValidBST1(TreeNode root) {
        Deque<TreeNode> s = new LinkedList<>();
        // pr指向刚才访问过的结点值
        long pr = Long.MIN_VALUE;
        while (! s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (! s.isEmpty()) {
                TreeNode top = s.pop();
                if (top.val <= pr)  return false;
                else {
                    pr = top.val;
                    root = top.right;
                }
            }
        }
        return true;
    }

    // 中序遍历还可以采用递归的方式进行
    public boolean isValidBST2(TreeNode root) {
        boolean lflag = true, rflag = true;
        if (root.left != null) {
            lflag = isValidBST(root.left);
        }
        if (root.val <= pr)  return false;
        else pr = root.val;
        if (root.right != null) {
            rflag =  isValidBST(root.right);
        }
        return lflag && rflag;
    }
}
// @lc code=end

