/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1, null);  // 这就是创建头节点的好处
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }
        // 注意下面没有必要像书上那样再开两个while循环
        // 链表本身就是连接好了的
        tail.next = list1 == null ? list2 : list1;
        return head.next;
    }
}
// @lc code=end
