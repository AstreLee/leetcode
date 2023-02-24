import java.util.*;
/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
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
    public Set<Integer> set = new HashSet<>();
    public List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        return findTarget4(root, k);
    }

    // 哈希表 + 深度优先遍历
    public boolean findTarget1(TreeNode root, int k) {
        if (root == null)  return false;
        if (! set.contains(k - root.val)) set.add(root.val);
        else return true;
        return findTarget1(root.left, k) || findTarget1(root.right, k);
    }

    // 哈希表 + 广度优先遍历
    public boolean findTarget2(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (! q.isEmpty()) {
            TreeNode node = q.poll();
            if (! set.contains(k - node.val))  set.add(node.val);
            else return true;
            if (node.left != null)   q.offer(node.left);
            if (node.right != null)   q.offer(node.right);
        }
        return false;
    }

    // 中序 + 双指针（就是转换成前面的那种形式）
    public boolean findTarget3(TreeNode root, int k) {
        // 首先采用中序非递归的方式将BST中的节点按照升序的方式存储在list数组中
        Deque<TreeNode> s = new LinkedList<>();
        while (! s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (! s.isEmpty()) {
                root = s.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        // 然后采用双指针的方式寻找
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) < k) ++i;
            else if (list.get(i) + list.get(j) > k) --j;
            else return true;
        }
        return false;
    }

    // 实际上还可以采取直接在树上进行双指针的方法
    public boolean findTarget4(TreeNode root, int k) {
        Deque<TreeNode> s1 = new LinkedList<>();
        Deque<TreeNode> s2 = new LinkedList<>();
        TreeNode left = root;
        s1.push(left);
        while (left.left != null) {
            s1.push(left.left);
            left = left.left;
        }
        TreeNode right = root;
        s2.push(right);
        while (right.right != null) {
            s2.push(right.right);
            right = right.right;
        }
        // 当left != right的时候继续，实际上也就是没有到中点相遇的时候结束
        while (left != right) {
            if (left.val + right.val < k) {
                left = GetLeft(s1);
            } else if (left.val + right.val > k) {
                right = GetRight(s2);
            } else return true;
        }
        return false;
    }


    public TreeNode GetLeft(Deque<TreeNode> s) {
        TreeNode root = s.pop();
        TreeNode node = root.right;
        while (node != null) {
            s.push(node);
            node = node.left;
        }
        return root;
    }

    public TreeNode GetRight(Deque<TreeNode> s) {
        TreeNode root = s.pop();
        TreeNode node = root.left;
        while (node != null) {
            s.push(node);
            node = node.right;
        }
        return root;
    }
}
// @lc code=end

