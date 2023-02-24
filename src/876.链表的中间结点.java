/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
    public ListNode middleNode(ListNode head) {
        // 方法一：如果链表像数组一样可以直接通过下标访问该多好
        // 既然这么想，那我们就创建一个等长的一维整形数组，然后遍历链表，将节点数据域保存下来
        // 最后直接返回中间值即可
        // int[] ans = new int[100];
        // ListNode pt = head;
        // int i = 0;
        // while (pt != null) {
        //     ans[i] = pt.val;
        //     ++i;
        //     pt = pt.next;
        // }
        // return ans[i / 2];  // 但是这样的话就返回的是中间的节点值了，就不会节点了。。。。



        // --------------------- 分割线 ------------------------
        // 方法二：这种是省去了数组的方法，时间复杂度为O(1.5N)实际上也就是O(N)，但是相比方法一
        // 来说少了O(N)的存储空间
        // 首先需要知道这个链表中节点的个数
        ListNode pt = head;
        int count = 0;
        while (pt != null) {
            ++count;
            pt = pt.next;
        }
        pt = head;
        for (int i = 1; i <= count / 2; ++i) {
            pt = pt.next;
        }
        return pt;
        // --------------------- 分割线 ------------------------

        // 方法三：采用快慢指针的方式，这个思路真的是秒哇，感觉自己的智商收到了碾压
        // ListNode slow = head;
        // ListNode fast = head;
        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // return slow;
    }
}
// @lc code=end
