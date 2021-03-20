import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 */
public class 面试题48_最长不含重复字符的子字符串 {
    public static int lengthOfLongestSubstring(String s){
        if(s==null || s.length()==0) return 0;
        int tmp=0, max=0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int start = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            tmp = i-start>tmp ? tmp+1 : i-start;
            max = Math.max(max, tmp);
        }
        return max;
    }
    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("abcdaabderfs");
        System.out.println(res);
    }
}
