/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)  return head;
        // 使用头结点统一操作
        ListNode newHead = new ListNode(-1, head);
        // 声明辅助指针
        ListNode pr = newHead;
        ListNode pt = head;
        while (pt != null) {
            if (pt.next != null && pt.val == pt.next.val) {
                while (pt.next != null && pt.val == pt.next.val)  pt = pt.next;
                pr.next = pt.next;
            } else {
                pr = pt;
            }
            pt = pt.next;
        }
        return newHead.next;
    }
}
// @lc code=end

