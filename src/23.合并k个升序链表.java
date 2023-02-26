import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    // public ListNode mergeKLists(ListNode[] lists) {
    //     ListNode res = null;
    //     for (int i = 0; i < lists.length; ++i) {
    //         res = mergeTwoLists(res, lists[i]);
    //     }
    //     return res;
    // }

    // public ListNode mergeKLists(ListNode[] lists) {
    //     return merge(lists, 0, lists.length - 1);
    // }

    // // 此时合并lists中low ~ high的链表
    // public ListNode merge(ListNode[] lists, int low, int high) {
    //     if (low == high) {
    //         return lists[low];
    //     } else if (low > high) {
    //         return null;
    //     } else {
    //         int mid = (high - low) / 2 + low;
    //         return mergeTwoLists(merge(lists, low, mid), merge(lists, mid + 1, high));
    //     }
    // }

    
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     ListNode head = new ListNode(0, null);
    //     ListNode tail = head;
    //     while (list1 != null && list2 != null) {
    //         if (list1.val < list2.val) {
    //             tail.next = list1;
    //             tail = list1;
    //             list1 = list1.next;
    //         } else {
    //             tail.next = list2;
    //             tail = list2;
    //             list2 = list2.next;
    //         }
    //     }
    //     tail.next = list1 == null ? list2 : list1;
    //     return head.next;
    // }

    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}
// @lc code=end