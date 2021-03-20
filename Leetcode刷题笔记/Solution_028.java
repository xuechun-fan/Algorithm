package LeetCode刷题;

/**
 * 实现strStr()函数。
 *
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Solution_028 {
    public static int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0){
            return 0;
        }
        if(haystack==null || haystack.length()==0){
            return -1;
        }
        int l1 = haystack.length(), l2 = needle.length();
        for(int i=0; i<=l1-l2; i++){
            int head = 0, tail = l2 - 1;
            while(head<=tail && haystack.charAt(i+head)==needle.charAt(head)
                    && haystack.charAt(i+tail)==needle.charAt(tail)){
                head++;
                tail--;
            }
            if(head>tail){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "hello", s2 = "ll";
        int res = strStr(s1, s2);
        System.out.println(res);
    }

}
