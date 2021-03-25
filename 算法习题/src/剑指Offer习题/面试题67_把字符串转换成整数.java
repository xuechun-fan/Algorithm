package 剑指Offer习题;

/**
 * Description:
 */
public class 面试题67_把字符串转换成整数 {
    public static int strToInt(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        int start = 1, sign = 1;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        if(s.charAt(0)=='-') sign = -1;
        else if(s.charAt(0) != '+') start = 0;
        for(int i=start; i<s.length(); i++){
            if(s.charAt(i)<'0' || s.charAt(i)>'9') break;
            if(res>bndry || res==bndry && s.charAt(i)>'7')
                return  sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10 + (s.charAt(i)-'0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        int ans = strToInt("9223372036854775808");
        System.out.println(ans);
    }
}
