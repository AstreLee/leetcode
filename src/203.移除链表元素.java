/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)  return null;
        ListNode newHead = new ListNode(-1, head);
        ListNode pre = newHead;
        ListNode pt = head;
        while (pt != null) {
            if (pt.val == val) {
                // 看看后面还有几个连续的这样的val节点
                while (pt != null && pt.val == val)  pt = pt.next;
                if (pt == null)  {
                    pre.next = null;
                    return newHead.next;
                } else {
                    pre.next = pt;
                }
            }
            pre = pt;
            pt = pt.next;
        }
        return newHead.next;
        // 讲真头节点真的好用，将链表的操作全部都统一了
    }
}
// @lc code=end

