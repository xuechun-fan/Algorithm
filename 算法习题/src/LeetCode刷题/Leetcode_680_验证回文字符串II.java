package LeetCode刷题;

/**
 * Description：
 */
public class Leetcode_680_验证回文字符串II {
    public static boolean validPalindrome(String s) {
        if(s==null || s.length()<=1) return true;
        char[] arr = s.toCharArray();
        int i=0, j=arr.length-1;
        while(i<j){
            if(arr[i]!=arr[j]){
                //  如果遇到一次不同的字母，那么调用check函数，即要么删除左边的，要么删除右边的
                return check(arr, i+1, j) || check(arr, i, j-1);
            }
            i++;j--;
        }
        return true;
    }
    private static boolean check(char[] arr, int i, int j){
        while(i<j){
            if(arr[i++]!=arr[j--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean res = validPalindrome("abbca");
        System.out.println(res);
    }
}
