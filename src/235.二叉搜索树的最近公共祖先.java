import java.util.*;
/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // List<TreeNode> list1 = new ArrayList<>();
        // List<TreeNode> list2 = new ArrayList<>();
        // lowestCommonAncestor1(root, p, list1);
        // lowestCommonAncestor1(root, q, list2);
        // // 实际上就是记录下根节点到这个节点的路径
        // // 一但出现分叉，最后一个分叉点就是公共祖先
        // int i = 0;
        // TreeNode ancestor = root;
        // while (i < list1.size() && i < list2.size()) {
        //     if (list1.get(i) != list2.get(i)) break;
        //     else ancestor = list1.get(i);
        //     ++i;
        // }
        // return ancestor;

        // --------------- 分隔线 -----------------------
        // 实际上还可以利用BST树的性质
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) ancestor = ancestor.left;
            else if (p.val > ancestor.val && q.val > ancestor.val) ancestor = ancestor.right;
            else return ancestor;
        }
    }

    public void lowestCommonAncestor1(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == p) list.add(p);
        if (root.val < p.val)  {
            list.add(root);
            lowestCommonAncestor1(root.right, p, list);
        }
        if (root.val > p.val)  {
            list.add(root);
            lowestCommonAncestor1(root.left, p, list);
        }
    }
}
// @lc code=end

