package 剑指Offer习题;

/**
 * Description:
 */
public class 面试题05_替换空格 {
    public static String replaceSpace(String s) {
        if(s==null || "".equals(s)) return "";
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        for(char ch : arr){
            if(ch==' '){
                res.append("%20");
            }else{
                res.append(ch);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String res = replaceSpace("We are happy!");
        System.out.println(res);
    }
}
