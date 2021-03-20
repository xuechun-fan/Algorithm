/**
 * Description：
 */
public class 面试题15_二进制中1的个数 {
    //  二进制中1的个数
    public static int countOf1(int num){
        if(num==0){
            return 0;
        }
        int flag = 1;
        int count = 0;
        while (flag!=0){
            if((num & flag) == flag){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    //  二进制中1的个数 比较好的解法
    public static int countOf1_(int n){
        if(n==0){
            return 0;
        }
        int count = 0;
        while(n!=0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    //  判断一个数是否是2的整数次方
    public static boolean is2pow(int n){
        return ((n & (n-1))==0)?true:false;
    }

    //  输入两个数字m和n，求m需要改变几位才可以变成n
    public static int countsOfChange(int m, int n){
        int res = m ^ n;
        return countOf1_(res);
    }

    public static void main(String[] args) {
        System.out.println("63的二进制表示形式中1的个数： " + countOf1_(63));

        //  测试判断一个数是否是2的整数次方
        System.out.println("64是2的整数次方： " + is2pow(64));
        System.out.println("63是2的整数次方： " + is2pow(63));
        System.out.println("m需要改变几位才可以变成n： " + countsOfChange(10, 13));

    }
}
