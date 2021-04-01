# Leetcode_044_通配符匹配

给定一个字符串 (`s`) 和一个字符模式 (`p`) ，实现一个支持 `'?'` 和 `'*'` 的通配符匹配。

```
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
```

两个字符串**完全匹配**才算匹配成功。

**说明:**

- `s` 可能为空，且只包含从 `a-z` 的小写字母。
- `p` 可能为空，且只包含从 `a-z` 的小写字母，以及字符 `?` 和 `*`。

**示例 1:**

```
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
```

**示例 2:**

```
输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
```

**示例 3:**

```
输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
```

**示例 4:**

```
输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
```

**示例 5:**

```
输入:
s = "acdcb"
p = "a*c?b"
输出: false
```

### 解析

采用动态规划思想，那么首先就要规定动态规划表的意义：dp [ i ] [ j ] 代表 s 的前 i 个字符 和 p 的前 j 个字符匹配情况。

那么计算dp [ i ] [ j ] 的时候要考虑当前字符的情况

当前 p 的字符分为三种情况

- '?'
- '*'
- 'a-z'

1. 如果当前模式字符为 '?' ，那么 dp [ i ] [ j ] 就可以直接从 dp [ i-1 ] [ j-1 ] 的状态转移过来
2. 如果当前模式字符为 '*' ，就要考虑当前的 '\*' 匹配0次 或多次的情况。dp [ i-1 ] [ j ] 代表当前模式字符 '\*' 匹配，也就是 dp[ i ] [ j ] 的值从 dp [ i ] [ j-1 ] 转移过来，或者匹配多次，那就是从 dp [ i-1 ] [ j ] 的状态转移过来。
3. 如果当前模式字符为 'a-z' ，那么 dp [ i ] [ j ] 就可以根据 dp [ i-1 ] [ j-1 ] 的状态 和当前字符是否匹配来决定

接下来见代码：

```java
public boolean isMatch(String s, String p) {
    if((s==null || "".equals(s)) && (p==null || "".equals(p))) return true;
    if((s!=null || s.length()!=0) && (p==null || p.length()==0)) return false;

    int m = s.length(), n = p.length();
    //  dp[i][j] 代表 s 的前 i 个字符和 p 的前 j 个字符匹配
    boolean[][] dp = new boolean[m+1][n+1];
    dp[0][0] = true;
    //  初始化首行，即s前 0 个字符和p的匹配情况
    for(int i=1; i<=n; i++){
        if(p.charAt(i-1)!='*') break;
        dp[0][i] = true;
    }
    for(int i=1; i<=m; i++){
        for(int j=1; j<=n; j++){
            if(p.charAt(j-1)=='?') dp[i][j] = dp[i-1][j-1];
            else if(p.charAt(j-1)=='*') dp[i][j] = dp[i][j-1] || dp[i-1][j];
            else{
                dp[i][j] = dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1);
            }
        }
    }
    return dp[m][n];
}
```

