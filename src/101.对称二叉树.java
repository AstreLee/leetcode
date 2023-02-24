import java.util.*;
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        // return check(root, root);

        // ---------------- 分割线 -----------------

        return BFS(root, root);
    }
    
    // 第一种方式使用递归
    public boolean check(TreeNode pt1, TreeNode pt2) {
        // 满足对称二叉树就是要pt1和pt2对应的值相等
        // 并且pt1左子树和pt2的右子树也是对称的
        // pt1的右子树和pt2左子树也是对称的
        
        // 1. 首先如果pt1和pt2均为空的话那么肯定true
        if (pt1 == null && pt2 == null)  return true;
        // 2. 如果pt1或者pt2二者只有一个为null, 那么返回false
        if (pt1 == null || pt2 == null)  return false;
        // 3. 否则的话就是递归返回节点值的比较
        return pt1.val == pt2.val && check(pt1.left, pt2.right) && check(pt1.right, pt2.left);
    }

    // 第二种方式使用迭代，也是利用BFS队列维护
    public boolean BFS(TreeNode pt1, TreeNode pt2) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pt1);
        q.offer(pt2);
        while (! q.isEmpty()) {
            TreeNode temp1 = q.poll();
            TreeNode temp2 = q.poll();
            if (temp1 == null && temp2 == null) continue;
            if (temp1 == null || temp2 == null || temp1.val != temp2.val)  return false;
            // 将temp1的左子树和temp2的右子树进队
            q.offer(temp1.left);
            q.offer(temp2.right);
            
            q.offer(temp1.right);
            q.offer(temp2.left);
        }
        return true;
    }
}
// @lc code=end

