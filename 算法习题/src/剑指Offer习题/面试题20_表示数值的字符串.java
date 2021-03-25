package 剑指Offer习题;

public class 面试题20_表示数值的字符串 {
    /** 题目描述
     * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
     * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
     * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
     */

    public static boolean isNum(String s){
        if(s==null || s.length()==0){
            return false;
        }
        boolean num = false;
        boolean e = false;
        boolean dot = false;

        char[] str = s.trim().toCharArray();

        for (int i = 0; i < s.trim().length(); i++) {
            if(str[i]<='9' && str[i]>='0'){
                num = true;
            }else if(str[i]=='.'){
                if(dot || e) return false;
                dot = true;
            }else if(str[i]=='e' || str[i]=='E'){
                if(!num || e) return false;
                e = true;

                //  12e
                num = false;
            }else if(str[i]=='+' || str[i]=='-'){
                if(!(i==0 || str[i-1]=='e'|| str[i-1]=='E')) return false;
            }else{
                return false;
    }
}
        return num;
    }

    public static void main(String[] args) {
        boolean res = isNum("-1E-16");
        System.out.println(res);
    }
}
