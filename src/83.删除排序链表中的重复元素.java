/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
        // ------------ 分割线 ---------------
        // 这是使用了额外的指针作为辅助存储空间，实际上只用一个指针也行
        // if (head == null)  return null;
        // if (head.next == null)  return head;
        // ListNode pt = head.next;
        // ListNode pr = head;
        // while (pt != null) {
        //     if (pt.val == pr.val) {
        //         while (pt != null && pt.val == pr.val) pt = pt.next;
        //     }
        //     pr.next = pt;
        //     if (pt == null)  return head;
        //     else {
        //         pr = pt;
        //         pt = pt.next;
        //     }
        // }
        // return head;
        // ---------------- 分割线 ------------------
        

        // 方法二：只使用一个指针，不过实际上都是一次遍历
        // 方法一是找出所有重复的，方法二的话代码要简洁不少
        if (head == null)  return null;
        ListNode pt = head;
        while (pt.next != null) {
            if (pt.val == pt.next.val)  pt.next = pt.next.next;
            else pt = pt.next;
        }
        return head;
    }
}
// @lc code=end

