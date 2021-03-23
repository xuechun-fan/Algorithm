# Shopee笔试题_通配符匹配

给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

1. 任何左括号 ( 必须有相应的右括号 )。
2. 任何右括号 ) 必须有相应的左括号 ( 。
3. 左括号 ( 必须在对应的右括号之前 )。
4. \* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
5. 一个空字符串也被视为有效字符串。

## 解析：

我们可以创建两个辅助栈 sc 和 ss，ss 用来存储左括号 '(' 的下标，另一个 ss 用来存储 '*' 的下标，然后每次遇到右括号 ')'，则优先弹出sc 栈顶的 '(' 的下标，如果此时sc栈为空则弹出 ss 栈中 '\*' 的下标 " 此时 '\*' 匹配其后面出现的右括号 "，如果此时两栈都为空，则直接返回false。
如果遍历结束，两栈都不为空，则判断 ss 栈中 '\*' 的下标是否大于sc 栈顶的 '(' 的下标，如果满足，则两栈同时弹出，否则结束循环。
返回值：如果经过以上操作，sc 栈顶的元素的下标全部弹出了，则说明匹配成功。（ss栈中如果还有元素，则视为匹配空字符）

代码：

```java
import java.util.*; 
public class Solution {
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean checkValidString (String s) {
        // write code here
        if(s==null || s.length()==0) return true;
        Stack<Integer> sc = new Stack<>();
        Stack<Integer> ss = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==')'){
                if(sc.isEmpty() && ss.isEmpty()) return false;
                else if(!sc.isEmpty()) sc.pop();
                else ss.pop();
            }else if(arr[i]=='('){
                sc.push(i);
            }else{
                ss.push(i);
            }
        }
        while(!sc.isEmpty() && !ss.isEmpty() && ss.peek()>sc.peek()){
            sc.pop();
            ss.pop();
        }
        return sc.isEmpty();
    }
}

```

