package 牛客刷题;

import java.util.*;

public class 括号序列 {
    public static boolean isValid(String s){
        if(s==null || s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }else if(ch=='['){
                stack.push(']');
            }else if(ch=='{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || ch!=stack.pop()){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = ")";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
