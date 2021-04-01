package LeetCode刷题;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 */
public class Leetcode_5682_所有子字符串美丽值之和 {
    public static int beautySum(String s) {
        if(s.length()<=1) return 0;
        char[] arr = s.toCharArray();
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                res += Sum(arr, i, j);
            }
        }
        return res;

    }

    private static int Sum(char[] arr, int a, int b){
        //  最多有26个字母，map的size为26
        Map<Character, Integer> dic = new HashMap<>();

        for(int i=a; i<=b; i++){
            dic.put(arr[i], 1+dic.getOrDefault(arr[i], 0));
        }
        int max = 1, min = 500;
        for(Map.Entry<Character, Integer> entry:dic.entrySet()){
            if(entry.getValue()>max) max=entry.getValue();
            if(entry.getValue()<min) min=entry.getValue();
        }
        return max-min;
    }

    public static void main(String[] args) {
        String str = "aa";
        int i = beautySum(str);
        System.out.println(i);
    }
}
