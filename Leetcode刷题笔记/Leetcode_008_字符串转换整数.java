package LeetCode刷题;

/**
 * 字符串转换整数（aoti)
 */
public class Leetcode_008_字符串转换整数 {
    public static int myAoti(String s){
        /*if(s==null || s.length()==0){
            return 0;
        }
        int len = s.length();

        char[] charArray = s.toCharArray();

        //  1、去掉前导空格
        int index = 0;
        while(index<len && charArray[index]==' '){
            index++;
        }

        //  2、如果已经完成遍历
        if(index==len){
            return 0;
        }

        //  3、如果出现符号字符，仅第一个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if(firstChar=='-'){
            sign = -1;
            ++index;
        }else if(firstChar=='+'){
            ++index;
        }

        //  4、将后续出现的数字字符进行转换
        //  不能使用long类型
        int res = 0;
        while(index<len){
            char curChar = charArray[index];
            //  4.1 先判断不合法的情况
            if(curChar>'9' || curChar<'0'){
                break;
            }
            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (curChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (curChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            //  4.2 合法的情况下才进行下一步转换
            res = res*10 + sign * (curChar - '0');
            index++;
        }
        return res;*/
        if(s==null || s.length()==0){
            return 0;
        }
        int len = s.length();
        int index = 0;
        while(index<len && s.charAt(index)==' '){
            index++;
        }
        if(index==len){
            return 0;
        }

        int sign = 1;
        char firstChar = s.charAt(index);
        if(firstChar=='+'){
            index++;
        }else if(firstChar=='-'){
            sign = -1;
            index++;
        }

        int res = 0;
        while(index<len){
            char curChar = s.charAt(index);
            if(curChar>'9' || curChar<'0'){
                break;
            }

            //  判断是否越界
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && (curChar-'0')>Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }
            if(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && (curChar-'0')>-(Integer.MIN_VALUE%10))){
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (curChar-'0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String s = "-2147483647";
        int ans = myAoti(s);
        System.out.println(ans);
        System.out.println(-(Integer.MIN_VALUE%10));
    }
}
