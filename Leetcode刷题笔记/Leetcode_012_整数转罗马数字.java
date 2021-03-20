package LeetCode刷题;

import java.util.HashMap;
import java.util.Map;

/**
 * 012：整数转罗马数字
 */
public class Leetcode_012_整数转罗马数字 {
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for(int i=0; i<values.length && num>0; i++){
            while(values[i]<=num){
                num = num - values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Integer i = 39;
        String res = intToRoman(i);
        System.out.println(res);
    }
}
