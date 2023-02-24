import java.util.Deque;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        // 方法一如下，使用队列进行层序遍历
        // // 处理边界情况
        // if (root == null)  return null;
        // // 采用层序遍历的方式
        // Deque<Node> q = new LinkedList<>();
        // // 首先将根节点添加进去
        // q.offer(root);
        // int row = 1;
        // int count = 0;
        // // 当队列不为空的时候继续
        // while (!q.isEmpty()) {
        //     // 首先出队一个元素
        //     Node pt = q.poll();
        //     // 然后count也要更新
        //     ++count;
        //     // 左节点不空添加进去
        //     if (pt.left != null) q.offer(pt.left);
        //     // 右节点不空添加进去
        //     if (pt.right != null) q.offer(pt.right);
        //     // next连接下一个节点
        //     if (count == Math.pow(2, row) - 1)  ++row;
        //     else  pt.next = q.peek();
        // }
        // return root;

        // ------------- 分割线 --------------------
        // 方法二：实际上我们还可以利用已经定义好的next指针
        if (root == null)  return root;
        Node first = root;
        Node head;
        while (first.left != null) {
            head = first;
            while (head != null) {
                // 第一次连接
                head.left.next = head.right;
                // 然后看看head.next是否存在
                if (head.next != null)  head.right.next = head.next.left;
                // head往后移动
                head = head.next;
            }
            first = first.left;
        }
        return root;


        // ----------------------- 分割线 ----------------------
        // 实际上这题也可以用层序遍历的改进算法进行计算
        // 有时间来写一下
    }
}
// @lc code=end
