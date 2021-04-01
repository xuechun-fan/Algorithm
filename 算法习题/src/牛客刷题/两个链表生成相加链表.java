package 牛客刷题;

import util.ListNode;
import util.Tool;

import java.util.Stack;

public class 两个链表生成相加链表 {


    public static void main(String[] args) {
        int[] n1 = new int[]{9,3,7};
        int[] n2 = new int[]{6,3};
        ListNode h1 = Tool.createList(n1);
        ListNode h2 = Tool.createList(n2);
        ListNode res = addInList(h1, h2);
        Tool.traverse(res);
    }

    public static ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1==null || head2==null){
            return head1==null ? head2 : head1;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode n1 = head1, n2 = head2;

        while(n1!=null){
            s1.push(n1);
            n1 = n1.next;
        }
        while(n2!=null){
            s2.push(n2);
            n2 = n2.next;
        }
        return s1.size()>s2.size() ? addCore(s1, s2) : addCore(s2, s1);
    }
    private static ListNode addCore(Stack<ListNode> s1, Stack<ListNode> s2){
        int inc = 0, ans = 0;
        ListNode t = null;
        while(s1.size()!=0 && s2.size()!=0){
            t = s1.pop();
            ans = t.val + s2.pop().val + inc;
            inc = ans>=10 ? 1 : 0;
            t.val = ans % 10;
        }
        while(s1.size()!=0){
            t = s1.pop();
            ans = t.val + inc;
            inc = ans>=10 ? 1 : 0;
            t.val = ans % 10;
        }
        if(inc==1){
            ListNode head = new ListNode(inc);
            head.next = t;
            return head;
        }
        return t;
    }

}
