package LeetCode刷题;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class
Leetcode_032_最长匹配括号 {
    public int longestValidParentheses(String s) {
        //  使用两个栈分别存储括号和下标
        Deque<Character> q1 = new LinkedList<>();
        Deque<Integer> q2 = new LinkedList<>();
        q1.addLast('x');
        q2.addLast(-1);
        int max = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==')' && q1.peekLast()=='('){
                q1.pollLast();
                q2.pollLast();
                max = Math.max(max, i-q2.peekLast());
            }else{
                q1.addLast(arr[i]);
                q2.addLast(i);
            }
        }
        return max;

    }

    @Test
    public void test(){
        String s = ")()())";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }

}
