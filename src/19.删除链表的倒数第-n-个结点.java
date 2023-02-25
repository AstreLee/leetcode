import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    // // 方法一：统计所有结点的个数然后在遍历删除
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     // 由于无法知晓待删除的结点是不是首结点，所以我们自己声明一个头结点
    //     // 然后添加到链表当中去，这样不管是删除首结点还是其它结点操作都是一样的
    //     ListNode dummy = new ListNode(0, head);
    //     int length = getLength(head);
    //     ListNode cur = dummy;
    //     // 找到待删除结点的前面一个结点
    //     for (int i = 0; i < length - n; ++i) {
    //         cur = cur.next;
    //     }
    //     // 删除
    //     cur.next = cur.next.next;
    //     // 返回首结点
    //     return dummy.next;
    // }

    // // 获取链表长度
    // private int getLength(ListNode head) {
    //     int count = 0;
    //     while (head != null) {
    //         ++count;
    //         head = head.next;
    //     }
    //     return count;
    // }
    
    // 方法二：利用栈的先进后出、后进先出的特性，将所有的节点压栈，然后依次弹出即可
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode dummy = new ListNode(1, head);
    //     Deque<ListNode> stack = new LinkedList<>();
    //     ListNode cur = dummy;
    //     while (cur != null) {
    //         stack.push(cur);
    //         cur = cur.next;
    //     }
    //     for (int i = 0; i < n; ++i) {
    //         stack.pop();
    //     }
    //     // 此时栈顶元素就是待删除结点的前面一个结点
    //     cur = stack.peek();
    //     // 删除结点
    //     cur.next = cur.next.next;
    //     // 返回首结点
    //     return dummy.next;
    // }

    // 方法三：使用前后指针，开头先让前指针移动n步，而后前指针和后指针同时向后移动
    // 利用两个指针之间的间距一定删除倒数第n个结点
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     // 为了删除方便同样声明头结点
    //     ListNode dummy = new ListNode(0, head);
    //     // 声明前、后指针
    //     ListNode first = dummy;
    //     ListNode second = dummy;
    //     // 让前指针先走n + 1步，这样不是找到待删除的结点，而是找到待删除结点的前一个结点
    //     for (int i = 0; i <= n; ++i) {
    //         first = first.next;
    //     }
    //     // 前后指针同时移动
    //     while (first != null) {
    //         first = first.next;
    //         second = second.next;
    //     }
    //     // 删除结点
    //     second.next = second.next.next;
    //     // 返回首结点
    //     return dummy.next;
    // }

    // 方法四：利用递归回溯的思想找到倒数第i个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        remove(dummy, n);
        return dummy.next;
    }

    private int remove(ListNode pt, int n) {
        if (pt == null) {
            return 0;
        }
        int num = remove(pt.next, n);
        if (num == n) {
            pt.next = pt.next.next;
        }
        return num + 1;
    }
}
// @lc code=end
