package 剑指Offer习题;

/**
 * Description：
 *
 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，
 第13位是1，第19位是4，等等。
 请写一个函数，求任意第n位对应的数字
 */
public class 面试题44_数字序列中某一位的数字 {
    public static int findNthDigit(int n) {
        //  这道题目的关键在于，分析每个范围的数字个数，然后慢慢定位
        int digits = 1;
        long start = 1;
        long counts = 9;
        while(n>counts){
            n -= counts;
            digits++;
            start *= 10;
            counts = start * digits * 9;
        }
        long res = start + (n/digits) - 1;
        int idx = n % digits;
        if(idx==0){
            return String.valueOf(res).charAt(digits-1) - '0';
        }
        return String.valueOf(res+1).charAt(idx-1) - '0';
    }

    public static void main(String[] args) {
        int res = findNthDigit(100);
        System.out.println(res);
    }
}
