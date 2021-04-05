package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题65_不用加减乘除做加法 {
    public static int add(int a, int b){
        //  不允许加减乘除，肯定就是位运算咯
        while(b!=0){
            int s = a^b;
            b = (a&b)<<1;
            a = s;
        }
        return a;
    }

    public static void main(String[] args) {
        int res = add(2, 5);
        System.out.println(res);
    }
}
