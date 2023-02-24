import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // ----------------- 判断链表中是否有环的经典算法 ----------------
        // --------- 这种又重复元素的问题最容易想到的就是采用哈希表
        // 如果没有环的话，那么pt指针指向null就结束并且返回false
        // 如果有环的话，那么pt指针指向的节点添加进哈希表的时候就会有
        // 重复,这个时候就会返回false
        // Set<ListNode> set = new HashSet<>();
        // ListNode pt = head;
        // while (pt != null) {
        // if (! set.contains(pt)) set.add(pt);
        // else return true;
        // pt = pt.next;
        // }
        // return false;

        // ----------------- 分割线 -------------------
        // 实际上还可以采用快慢指针的思想
        // pr每次移动一格，pt每次移动两格,如果不存在环的话，那么
        // pt就会最先到null，否则的话pt就会追上pr
        // 如果head为空或者head只有一个节点的边界情况先考虑
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            // 这里要先判断fast再判断fast.next
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

// @lc code=end
