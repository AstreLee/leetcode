/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        // 首先进行异边界情况处理
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        while (true) {
            cur.next = cur2;
            cur1.next = cur2.next;
            cur2.next = cur1;
            
            if (cur1.next == null || cur1.next.next == null) {
                break;
            } else {
                cur = cur1;
                cur1 = cur.next;
                cur2 = cur.next.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

