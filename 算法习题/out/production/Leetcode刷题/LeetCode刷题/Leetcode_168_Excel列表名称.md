# Leetcode_168_Excel列表名称

**题目描述：**

给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
示例 1:

输入: 1
输出: "A"
示例 2:

输入: 28
输出: "AB"
示例 3:

输入: 701
输出: "ZY"

**思路：**

其实第一眼看到这道题就想到了进制转换，记得之前好像做过相反的转换，也就是从字母转换成数字。原理都是基于进制转换思想的。方法也正常想到了除余法。

A = 1	B = 2 ... ... Z = 26

然后开始哐哐一顿敲，结果就发现了问题，这个26进制和正常的26进制还不太一样，正常的26进制范围是 0 - 25 ，这个是 1 - 26 。所以如果不对这点进行处理的话，最后结果就会出现错误。绞尽脑汁（可能自己比较笨吧），还是参考了别人的思路，原来 只需要每次取余之前将原数字减 1 即可，这样余数也就减1了，成为了 0 - 25 范围。详细看下方代码就懂了。

```java
class Solution{
    public String convertToTitle(int columnNumber){
        //	使用StringBuilder来动态插入字符
        StringBuilder res = new StringBuilder();
        while(columnNumber!=0){
            columnNumber--;
            res.append(0, (char)(65+columnNumber%26));
            columnNumber /= 26;
        }
        return res.toString();
    }
}
```

