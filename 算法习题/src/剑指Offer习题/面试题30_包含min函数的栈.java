package 剑指Offer习题;

import java.util.Stack;

/**
 * Description：
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)
 */

class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if(min.isEmpty()) min.push(x);
        else min.push(x<min.peek() ? x : min.peek());
    }

    public void pop() {
        if(s.isEmpty()) return;
        s.pop();
        min.pop();
    }

    public int top() {
        if(s.isEmpty()) return -1;
        return s.peek();
    }

    public int min() {
        return min.isEmpty() ? -1 : min.peek();
    }
}

public class 面试题30_包含min函数的栈 {

}
