package 剑指Offer习题;

/**
 * Description:
 */
public class 面试题58_翻转单词顺序 {
    public static String reverseWords(String s) {

        if(s==null || s.length()==0) return s;
        s = s.trim();
        StringBuilder res = new StringBuilder();
        int i = s.length()-1;
        int j = i;
        while(i>=0){
            //  找到空格分界处 i
            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }
            res.append(s.substring(i+1, j+1) + " ");
            //  找到下一个单词开始遍历的位置
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String s = reverseWords("I am a stu.");
        System.out.println(s);
    }
}
