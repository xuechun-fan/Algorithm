package 剑指Offer习题;

/**
 * Description：求斐波那契数列的第n项
 */
public class 面试题10_斐波那契数列 {
    //  效率很低的方法
    public static int fib1(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    //  实用的解法
    public static int fib2(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fn_1 = 1, fn_2 = 0, i = 2;
        while(i<n){
            int t = fn_2;
            fn_2 = fn_1;
            fn_1 = t + fn_1;
            i++;
        }
        return fn_1+fn_2;
    }


    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        System.out.println(fib1(30));
        long e = System.currentTimeMillis();
        System.out.println((e - s) + " ms");
        s = System.currentTimeMillis();
        System.out.println(fib2(30));
        e = System.currentTimeMillis();
        System.out.println((e - s) + " ms");

    }
}
