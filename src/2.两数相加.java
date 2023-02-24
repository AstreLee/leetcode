/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 这道题比较简单，假设有两个数n1和n2，那么相加的结果就是(n1 + n2 + carry) mod 10
        // 同样前面一位会向后面的一位进位，进位carry = ((n1 + n2 + carry) / 10)向下取整
        // 定义新的链表的头指针和尾指针
        ListNode head = null;
        ListNode tail = null;
        int carry = 0; // 个位的进位初始化为0
        // 接下来就是遍历l1和l2(如果l1为空的话，就默认为0，否则的话就默认为1)
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            if (head == null) {
                // 如果head==null的时候，就直接创建
                head = new ListNode(sum % 10, null);
                tail = head;
            } else {
                // 当head不为空的时候更新tail
                tail.next = new ListNode(sum % 10, null);
                tail = tail.next;
            }
            // 更新carry
            carry = sum / 10;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 注意最后可能还有进位
        if (carry > 0) {
            tail.next = new ListNode(carry, null);
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
// @lc code=end
