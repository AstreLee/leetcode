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
        // 这道题是原题。。。不如上面的环形链表
        // 首先处理一下边界情况
        // 等等，这题好像不能再单独创建一个list3。。。
        // 相比于单独创建一个list3，这种方法真的是好的不能再好
        // 真的记住创建头节点的好处哈哈哈哈哈哈
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
