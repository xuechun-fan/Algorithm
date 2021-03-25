package 牛客刷题;



import java.util.ArrayList;
import java.util.List;

public class 大数加法 {
    public static String solve (String s, String t) {
        // write code here
        if(s==null || s.length()==0){
            return t==null ? "" : t;
        }else if(t==null || t.length()==0){
            //    s 不为null 或者空
            return s;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int l1 = s.length(), l2 = t.length();
        int len = Math.max(l1, l2);
        char[] res = new char[len+1];
        int inc = 0, ans = 0;          //   分别保存进位状态和当前位计算结果
        l1--;
        l2--;
        while(l1>=0 && l2>=0){
            ans = (sc[l1--]-'0') + (tc[l2--]-'0') + inc;
            inc = ans>=10 ? 1 : 0;
            res[len--] = (char) (ans%10+'0');
        }
        while(l1>=0){
            ans = (sc[l1--]-'0') + inc;
            inc = ans>=10 ? 1 : 0;
            res[len--] = (char) (ans%10+'0');
        }
        while(l2>=0) {
            ans = (tc[l2--] - '0') + inc;
            inc = ans>=10 ? 1 : 0;
            res[len--] = (char) (ans % 10 + '0');
        }
        res[len] = inc==1 ? '1' : ' ';
        return String.valueOf(res).trim();
    }

    public static void main(String[] args) {
        String res = solve("123", "926");
        System.out.println(res);
    }
}
