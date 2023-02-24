import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 */

// @lc code=start
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // Deque<Character> stack1 = new LinkedList<>();
        // Deque<Character> stack2 = new LinkedList<>();
        // // 首先遍历字符串s
        // for (char c : s.toCharArray()) {
        //     if (c != '#')  stack1.push(c);
        //     else {
        //         if (!stack1.isEmpty())   stack1.pop();
        //     }
        // }
        // // 然后遍历t字符串
        // for (char c : t.toCharArray()) {
        //     if (c != '#')  stack2.push(c);
        //     else {
        //         if (!stack2.isEmpty())   stack2.pop();
        //     }
        // }
        // if (stack1.size() != stack2.size())  return false;
        // while (!stack1.isEmpty()) {
        //     if (stack1.pop() != stack2.pop())  return false;
        // }
        // return true;


        // -------------------- 分割线 ------------------------
        // 实际上这题还可以采用逆序双指针的方法
        
    }
}
// @lc code=end

