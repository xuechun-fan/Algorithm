# 牛客网Shopee笔试题_N个一组翻转链表

**解析：**

这道题相对来说就简单点了，就是基于翻转单链表的改版题目，在单链表中，我们以头节点开始，尾节点结束，区间内翻转，而N个一组翻转，我们可以将链表看作 多个链表的翻转与拼接，每个链表包含N个节点，也就是说我们需要确定链表翻转范围，每一个短链表的操作都一样，那么递归就出现了。每次翻转，旧的头节点就变成了尾节点，最终我们需要返回新的头节点，那么想一下，下一层递归返回的是后面翻转好的链表的头节点，那么本层就需要将新的尾节点（即旧的头节点）与下一层的头节点链接起来。这样就可以了。

```java
import java.util.*;
 
public class ListNode {
    int val;
    ListNode next = null;
}
 
public class Solution {
    /**
     * reverse the given linked list
     * @param head ListNode类 the head of the linked list
     * @param n int整型 the N
     * @return ListNode类
     */
    public ListNode reverseLinkedList (ListNode head, int n) {
        // write code here
 
        if(head==null || n==1) return head;
        ListNode tmp = head;
        int t = n;
        while(tmp!=null && t>0){
            tmp = tmp.next;
            t--;
        }
        //if(t>0) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur!=tmp){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseLinkedList(cur, n);
        return pre;
    }
}
```

