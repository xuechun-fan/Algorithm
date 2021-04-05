package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题50_第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        if(s==null || s.length()==0) return ' ';
        char[] arr = s.toCharArray();
        int[] tmp = new int[26];
        for(char ch:arr){
            tmp[ch-'a']++;
        }
        for(char ch : arr){
            if(tmp[ch-'a']==1){
                return ch;
            }
        }
        return ' ';
    }
}
