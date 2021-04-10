package 剑指Offer习题;

import java.util.List;

/**
 * Description：
 */
public class 面试题25_合并两个排序的链表 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null || l2==null) return l1==null ? l2 : l1;
        //  当两链表均不为空时，开始合并
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if(l1!=null){
            tmp.next = l1;
        }
        if(l2!=null){
            tmp.next = l2;
        }
        tmp = dummy.next;
        dummy = null;
        return tmp;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildList(new int[]{1, 2, 5});
        ListNode l2 = ListNode.buildList(new int[]{2, 6});
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(mergeTwoLists(l1, l2));
    }
}
