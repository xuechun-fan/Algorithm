package 剑指Offer习题;

/**
 * Description:
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
 * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，
 * 用来计算一个数字有多少种不同的翻译方法。
 */
public class 面试题46_把数字翻译成字符串 {
    /**
     * 目前这种方法的思路是自顶向下的方式，这种方式类似于建树的过程，会存在大量的重复计算
     * 还有优化的空间，就是剪枝。自底向上？后面有时间再思考一下吧
     */
    public static int translateNum(int num){
        //  如果数字小于10，即只有一位，那么直接返回
        if(num<10) return 1;
        //  将数字转化为字符串
        String s = String.valueOf(num);
        return dfs(s, 0);
    }
    private static int dfs(String s, int i){
        if(i==s.length()) return 1;
        if(i<s.length()-1){
            //  如果后面还有数字
            //  取出当前位和下一位组成的数字
            int t = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
            if(t>=10 && t<=25){
                return dfs(s, i+1) + dfs(s, i+2);
            }
        }
        //  否则就是直接返回下一位开始的递归函数
        return dfs(s, i+1);
    }


    public static int translateNum1(int num){
        //  自底向上试试
        if(num<10) return 1;
        int a = num%10;
        int b = num%100;
        if(b>=10 && b<=25) return translateNum1(num/10) + translateNum1(num/100);
        return translateNum1(num/10);
    }

    public static void main(String[] args) {
        int num = 12258;
        int res = translateNum1(num);
        System.out.println(res);
    }
}
