import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    // 首先定义两个栈空间
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    // 再定义一个front变量保存队首元素
    int front;

    // public MyQueue() {

    // }

    // public void push(int x) {
    // // 实际上就是保证每次新添加的元素都在栈底
    // // 首先元素在进队之前，如果s1为空的话，说明新添加进来的x就是栈顶元素
    // if (s1.isEmpty()) front = x;
    // // 然后将s1中的元素全部弹出并压入s2中(如果是空的话当然就不执行)
    // while (! s1.isEmpty()) s2.push(s1.pop());
    // // 然后将新添加进的元素压入s2中
    // s2.push(x);
    // // 再将s2中的元素弹出并压入s1中，实际上s1->s2->s1,s1中的元素本身没有变化，但是保证了新压入的元素在栈底
    // while (! s2.isEmpty()) s1.push(s2.pop());
    // }

    // public int pop() {
    // // 由于题目中已经保证了pop和peek操作针对非空队列的，所以s1为空不需要考虑
    // // 直接让s1中的元素出栈
    // int x = s1.pop();
    // // 注意front指向队首元素也需要更新了，但是pop()之后s1有可能为空，所以要判断一下
    // if (! s1.isEmpty()) front = s1.peek();
    // // 返回弹出的元素x
    // return x;
    // }

    // public int peek() {
    // // peek获取队首元素，这个简单，直接返回front
    // return front;
    // }

    // public boolean empty() {
    // // s1为空队列就为空
    // return s1.isEmpty();
    // }

    // ------------------- 分割线 -----------------

    // 第二种时间复杂度更小的方式
    public MyQueue() {

    }

    public void push(int x) {
        // 入队的时候压入s1
        // 如果s1为空的话赋值front变量
        if (s1.isEmpty())
            front = x;
        // 然后将元素入栈
        s1.push(x);
    }

    public int pop() {
        // 出栈的时候如果s2不为空的话则出栈s2中的元素，否则的话将s1中的元素压入
        if (s2.isEmpty()) {
            while (! s1.isEmpty())
                s2.push(s1.pop());
        }
        int x = s2.pop();
        return x;
    }

    public int peek() {
        // 如果s2不为空的话返回s2的栈顶元素, 否则的话返回front
        if (! s2.isEmpty())  return s2.peek();
        else return front;
    }

    public boolean empty() {
        // 由于队列中的元素是保存在s1和s2中的，所以只需要s1和s2都不为空就行
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
