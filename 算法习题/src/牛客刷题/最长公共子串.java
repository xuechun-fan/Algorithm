package 牛客刷题;

public class 最长公共子串 {
    public static String longestCommonSubstring(String s1, String s2){
        int l1 = s1.length(), l2 = s2.length();
        if(s1==null || l1==0 || s2==null || l2==0){
            return "";
        }
        int maxLen = 0, index = 0;
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if(maxLen<dp[i+1][j+1]){
                        maxLen = dp[i+1][j+1];
                        index = i + 1;
                    }
                }
            }
        }
        return maxLen==0 ? "" : s1.substring(index-maxLen, index);
    }

    public static void main(String[] args) {
        String str = longestCommonSubstring("sdascabcdegfhgfhdfg", "gfklabciupy");
        System.out.println(str);
    }
}
