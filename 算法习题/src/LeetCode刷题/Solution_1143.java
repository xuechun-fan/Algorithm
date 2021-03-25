package LeetCode刷题;

/**
 * 最长公共子序列
 */
public class Solution_1143 {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int max = 0;
        if(s1==null || m==0 || s2==null || n==0){
            return max;
            // return "";
        }
        boolean s1IsShort = m<n ? true : false;
        if(s1IsShort){
            return longest(s1, s2, m, n);
        }else{
            return longest(s2, s1, n, m);
        }
    }
    private int longest(String s1, String s2, int m, int n){
        int max = 0, index = 0;
        int[] dp = new int[m+1];
        for(int i=0; i<m; i++){
            for(int j=index; j<n; j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1] = dp[i] + 1;
                    max = dp[i+1];
                    index = j+1;
                    i++;
                    if(max==i+1){
                        break;
                    }
                }else{
                    dp[i+1] = dp[i];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution_1143 solution = new Solution_1143();
        int ans = solution.longestCommonSubsequence("ezupkr", "ubmrapg");
        System.out.println(ans);
    }
}
