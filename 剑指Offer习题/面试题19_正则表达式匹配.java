public class 面试题19_正则表达式匹配 {
    /**
        请实现一个函数用来匹配包含 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，
        而 '*' 表示它前面的字符可以出现任意次（含 0 次）。在本题中，匹配是指字符串的所有字符匹配
        整个模式。例如，字符串 “aaa” 与模式 "a.a" 和 "ab*ac*a" 匹配，但与 "aa.a" 和 "ab*a" 均不匹配。
     */

    //  剑指 Offer 版本，比较容易理解
    public boolean isMatch(String s, String p) {
        /**         动态规划法，不是特别好理解      **/
        int m = s.length(), n = p.length();
        //  创建动态规划数组，dp[i][j]代表s的前i个字符与p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[m+1][n+1];
        //  空字符串与空字符串是匹配的
        dp[0][0] = true;
        //  初始化首行
        //  首行为dp[0][i]:空字符串与p的前i个字符是否匹配，只有当p的偶数位全部为 '*' 的时候，才会都为true，意味着p的每个奇数位的字符都匹配0次
        //  dp[0][i-2]：前面的模式是否满足偶数位都为 '*'
        for(int i=2; i<=n; i+=2){
            dp[0][i] = dp[0][i-2] && p.charAt(i-1)=='*';
        }

        //  首列dp[i][0]：非空字符串与空模式串匹配一定false，不用处理

        //  状态转移，从s和i的第一个字符开始匹配
        //  其实就是填充dp矩阵的过程
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                dp[i][j] =
                        //  首先判断当前位是否是 '*'
                        p.charAt(j-1)=='*'
                                ?
                                //  如果是 '*'， 则判断匹配次数
                                //  dp[i][j-2]的值赋给dp[i][j]：意思是忽略p的'*'和'*'前面的一位，也就是该'*'匹配0次
                                //  dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')的意思是dp[i-1][j]是模式不变，考虑前面的状态，再匹配一次当前s的字符，累加起来就是多次匹配的功能，可以画dp矩阵图就能理解了
                                dp[i][j-2] || dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')
                                :
                                //  如果不是'*',就简单的根据上一字符匹配状况和当前字符是否匹配即可
                                dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.');
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String s = "a";
        String p = "ab*";
        面试题19_正则表达式匹配 tool = new 面试题19_正则表达式匹配();
        boolean match = tool.isMatch(s, p);
        System.out.println(match);
    }
}
