/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        // 反转链表采用头插法不就OK？
        // 首先处理边界情况
        if (head == null)
            return null;
        ListNode newHead = new ListNode(-1, head);
        ListNode pt = head.next;
        // 注意第一个节点就是最后一个节点, 这里一定要清空，不然的话就是环路，下面这一步没有的话就会形成环路
        head.next = null;
        ListNode nextPt = null;
        while (pt != null) {
            nextPt = pt.next;
            pt.next = newHead.next;
            newHead.next = pt;
            pt = nextPt;
        }
        return newHead.next;
    }
}
// @lc code=end
