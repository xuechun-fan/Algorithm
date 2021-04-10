package 剑指Offer习题;

import java.util.Stack;

/**
 * Description：
 */
public class 面试题31_栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null && popped==null) return true;
        //  思路：我们直接创建一个栈来模拟就好了
        Stack<Integer> s = new Stack<>();
        int idx = 0;
        for(int num:pushed){
            s.push(num);
            while(!s.isEmpty() && s.peek()==popped[idx]){
                s.pop();
                idx++;
            }
        }
        //  如果顺序是正确的，那么最后栈一定为空
        return s.isEmpty();
    }
}
