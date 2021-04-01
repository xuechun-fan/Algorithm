package LeetCode刷题;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 最长公共前缀
 */
public class Solution_014 {
    public static String longestCommonPrefix(String[] strs){
        if(strs==null || strs.length==0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int end = 0;
            while(end<Math.min(ans.length(), strs[i].length()) && ans.charAt(end)==strs[i].charAt(end)){
                end++;
            }
            if(end<ans.length()){
                ans = ans.substring(0, end);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String a = "abcsdsad";
        String b = "abcgfdghfdh";
        String c = "absdfds";
        String[] strs = {a, b, c};
        String ans = longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
