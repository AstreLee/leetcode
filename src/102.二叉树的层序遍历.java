import java.util.*;
/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // return BFS(root);
    
        // --------------- 分割线 -----------------
        // 实际上还可以使用DFS的思想来解决
        // 每一层使用一个列表，用Level标识第几层，然后深度遍历下去就行
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        DFS(root, 0, list);
        return list;
    }

    public List<List<Integer>> BFS(TreeNode root) {
        // 实际上就是在原有的层序遍历的基础上加以修改
        // 原来的层序遍历每次只出队一个元素
        // 现在我们每次出队就出队一层的元素，这样就可以在
        // 出队完这层后继续出队下一层的
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null)  return list;
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevel = q.size();
            for (int i = 1; i <= currentLevel; ++i) {
                // 首先出队一个元素
                TreeNode temp = q.poll();
                // 然后添加到level中
                level.add(temp.val);
                // 左节点不空就添加左节点
                if (temp.left != null)
                    q.offer(temp.left);
                // 右节点不空就添加右节点
                if (temp.right != null)
                    q.offer(temp.right);
            }
            list.add(level);
        }
        return list;
    }

    public void DFS(TreeNode pt, int level, List<List<Integer>> list) {
        // 这种带level的方法要掌握
        // 实际上我们可以使用深度
        if (pt == null)  return;
        // 如果当前list的长度为level的话，就为这一层创建数组
        if (list.size() == level)  list.add(new ArrayList<>());
        // 将level层的pt节点添加进list数组中
        list.get(level).add(pt.val);
        // 左右结点不空就去遍历左右节点
        if (pt.left != null)  DFS(pt.left, level + 1, list);
        if (pt.right != null)  DFS(pt.right, level + 1, list);
    }
}
// @lc code=end