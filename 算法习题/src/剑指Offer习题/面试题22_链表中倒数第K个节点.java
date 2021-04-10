package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题22_链表中倒数第K个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null) return null;
        //  双指针法
        ListNode left = head;
        ListNode right = head;
        while(k>0){
            right = right.next;
            k--;
        }
        while(right!=null){
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
