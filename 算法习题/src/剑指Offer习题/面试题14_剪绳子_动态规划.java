package 剑指Offer习题;

import java.util.Map;

/**
 * Description：
 */
public class 面试题14_剪绳子_动态规划 {
    public static int maxProductAfterCutting_1(int length){
        if(length<2){
            return 0;
        }
        if(length==2){
            return 1;
        }
        if(length==3){
            return 2;
        }
        int[] products = new int[length+1];
        for (int i = 0; i <= 3; i++) {
            products[i] = i;
        }
        int max = 0;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                int product = products[j]*products[i-j];
                if(max<product){
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[length];
    }

    //  贪婪算法
    public static int maxProductAfterCutting_2(int length){
        if(length<2){
            return 0;
        }
        if(length==2){
            return 1;
        }
        if(length==3){
            return 2;
        }

        int timesOf3 = length/3;
        if(length - timesOf3*3 == 1){
            timesOf3--;
        }
        int timesOf2 = (length-timesOf3*3)/2;
        return ((int)Math.pow(3, timesOf3)) * ((int)Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting_2(8));
    }
}
