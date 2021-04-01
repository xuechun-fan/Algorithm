package 剑指Offer习题;

public class 面试题64_求1到n的和 {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、
     * if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public static int numSums(int n){
        //  使用 与运算的短路效应来替代判断的效果
        boolean x = n>1 && (n+=numSums(n-1))>0;
        return n;
    }

    public static void main(String[] args) {
        int res = numSums(6);
        System.out.println(res);
    }
}
