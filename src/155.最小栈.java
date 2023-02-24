import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {
    // 定义两个栈空间
    public Deque<Integer> s;
    public Deque<Integer> minStack;

    public MinStack() {
        s = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int x) {
        // 首先将数据压入s1中
        s.push(x);
        // 再来更新我们的最小栈s2
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }
    
    public void pop() {
        // s和minStack要同时出栈
        s.pop();
        minStack.pop();
    }
    
    public int top() {
        // 在s非空的情况下返回栈顶元素
        if (! s.isEmpty()) {
            return s.peek();
        }
        // s为空的话返回-1
        return -1;
    }   
    
    public int min() {
        // 返回最小栈的顶部元素就行
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

