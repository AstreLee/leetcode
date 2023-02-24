import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        // 因为括号是成双的出现，所以如果s的长度为奇数必不可能配对
        if (s.length() % 2 != 0)
            return false;
        // 还是得用栈空间模拟，不能用回文串的方式解决，比如说{}[]()
        Deque<Character> stack = new LinkedList<Character>();
        // 用字典存储对应的字符
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        // 循环开始
        for (char c : s.toCharArray()) {
            if (! map.containsKey(c)) {
                // 如果是左括号的话不管栈是否为空都可以进栈
                stack.push(c);
            } else {
                // 如果是有括号
                // 1. 如果栈空间为空则直接返回false;
                if (stack.isEmpty())  return false;
                // 2. 如果栈空间不空就取栈顶元素进行比较
                char topC = stack.peek();
                if (topC == map.get(c)) stack.pop();
                else return false; 
            }
        }
        // 考虑到有可能全部是左括号，或者左括号没有匹配完
        if (! stack.isEmpty()) return false;
        return true;
    }
}
// @lc code=end
