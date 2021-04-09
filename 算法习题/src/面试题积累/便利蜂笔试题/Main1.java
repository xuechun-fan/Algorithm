package 面试题积累.便利蜂笔试题;

import java.util.Scanner;
import java.util.Stack;

/**
 * Description：
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        String res = process(arr);
        System.out.println(res);
    }
    public static String process(char[] arr){
        if(arr==null) return "";
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='}'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek()!='{'){
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                //  数字情况
                StringBuilder num = new StringBuilder();
                int times = 0;
                while(!stack.isEmpty() && stack.peek()<='9' && stack.peek()>='0'){
                    num.insert(0, stack.pop());
                }
                times = Integer.parseInt(num.toString());

                String s = sb.toString();
                if(times!=0){
                    for (int j = 1; j < times; j++) {
                        sb.append(s);
                    }
                }
                s = sb.toString();
                for (int j = 0; j < s.length(); j++) {
                    stack.push(s.charAt(j));
                }
            }else{
                stack.push(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            if(stack.peek()<='9' && stack.peek()>='0'){
                //  数字情况
                int times = 0;
                while(!stack.isEmpty() && stack.peek()<='9' && stack.peek()>='0'){
                    sb.insert(0, stack.pop());
                }
                times = Integer.parseInt(sb.toString());
                sb.delete(0,sb.length());
                String s = sb.toString();
                for (int j = 1; j < times; j++) {
                    sb.append(s);
                }
                s = sb.toString();
                if(s==null || s.length()==0){
                    return String.valueOf(times);
                }
                return s;
            }
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
