package LeetCode刷题;

import java.util.HashSet;
import java.util.Set;

/**
 * Description：
 */
public class Leetcode_345_翻转字符串中元音字母 {
    public static String reverseVowels(String s) {
        if(s==null || s.length()<=1) return s;
        char[] arr = s.toCharArray();
        Set<Character> dic = new HashSet<>();
        dic.add('a');dic.add('e');dic.add('i');dic.add('o');dic.add('u');
        dic.add('A');dic.add('E');dic.add('I');dic.add('O');dic.add('U');
        int i=0, j=arr.length-1;
        while(i<j){
            //  双指针扫描到符合条件的位置
            while(i<j && !dic.contains(arr[j])) j--;
            while(i<j && !dic.contains(arr[i])) i++;
            if(i<j){
                //  交换位置
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                //  并更新指针
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
