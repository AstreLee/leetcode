/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // --------------------- 分割线 -------------------
        // 其实这种方法速度还是比较快的，但是还是遍历了两次
        // 首先得知道链表中有多少个节点
        // int count = 0;
        // ListNode pt = head;
        // while (pt != null) {
        // ++count;
        // pt = pt.next;
        // }
        // if (count == n) return head.next; 
        // 这一步很关键，但是实际上可以用添加头节点的方式实现
        // ListNode pr = head;
        // pt = head.next;
        // int i = 1;
        // while (pt != null && i < count - n) {
        // pr = pt;
        // pt = pt.next;
        // ++i; // while里面一定要记得更新循环变量，别再吃这个亏了呜呜呜
        // }
        // if (pt == null) pr.next = null;
        // else pr.next = pt.next;
        // return head;

        // ------------------ 分割线 -----------------
        // 实际上还可以一次遍历，好像还是双指针。。。
        // .next.next....总共n次数下面是否为n
        // ListNode newHead = new ListNode(-1, head);
        // ListNode pr = newHead;
        // ListNode pt = newHead;
        // int count = n;
        // while (pt != null) {
        //     count = n;
        //     pr = pt;
        //     while (count > 0) {
        //         pr = pr.next;
        //         --count;
        //     }
        //     if (pr.next == null) {
        //         pt.next = pt.next.next;
        //         break;
        //     }
        //     pt = pt.next;
        // }
        // return newHead.next;
        // --------------------------------------
        // 上面这道题真的是吧头节点给玩透了

        // 实际上这题还可以用栈来求解
    }
}
// @lc code=end
