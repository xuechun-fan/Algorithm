package 剑指Offer习题;

/**
 * Description：输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class 面试题43_1到n整数中1出现的次数 {
    public static int countDigitOne(int n) {
        //  思路：类似于解密码箱一样，固定某一位，根据其他位能组成的数字的范围确定当前位出现1的可能次数
        //  然后对每一位进行同样的操作，把结果累加即可
        int res = 0;
        int digit = 1;
        int low = 0;
        int cur = n % 10;
        int high = n / 10;
        while(low<n){
            if(cur==0){
                res += high * digit;
            }else if(cur==1){
                res += high * digit + low + 1;
            }else{
                res += (high+1) * digit;
            }
            //  更新各个状态变量
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high = high / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int res = countDigitOne(231);
        System.out.println(res);
    }
}
