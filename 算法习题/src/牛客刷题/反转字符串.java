package 牛客刷题;

import java.util.ArrayList;
import java.util.List;

public class 反转字符串 {
    public static String reverseString(String str){
        int len = str.length();
        if(str==null || len==0){
            return "";
        }

        char[] res = new char[len];
        int left = 0; int right = len-1;
        while(left<=right){
            res[left] = str.charAt(right);
            res[right] = str.charAt(left);
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:res){
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = reverseString("abcde");
        System.out.println(res);
    }
}
