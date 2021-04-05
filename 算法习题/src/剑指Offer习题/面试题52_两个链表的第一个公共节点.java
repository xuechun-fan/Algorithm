package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题52_两个链表的第一个公共节点 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode n1 = headA;
        ListNode n2 = headB;
        while(n1!=n2){
            n1 = n1==null ? headB : n1.next;
            n2 = n2==null ? headA : n2.next;
        }
        return n1;
    }
}
