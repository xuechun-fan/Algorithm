package LeetCode刷题;

/**
 * Description：给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class Leetcode_633_平方数之和 {
    public static boolean judgeSquareSum(int c) {
        if(c<0) return false;
        //  双指针方法，左边界从0开始，有边界直接取c的平方根
        int i = 0, j = (int)Math.sqrt(c);
        while(i<=j){
            int sum = i*i + j*j;
            if(sum==c) return true;
            else if(sum<c) i++;
            else j--;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = judgeSquareSum(1);
        System.out.println(b);
    }
}
