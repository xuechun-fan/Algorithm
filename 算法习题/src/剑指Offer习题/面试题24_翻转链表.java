package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题24_翻转链表 {
    public static ListNode reverseList(ListNode head) {
        if(head==null) return null;
        //  常规迭代解法
        ListNode cur = head;
        ListNode pre = null;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        if(head==null || head.next==null) return head;
        //  想想递归解决的思路
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 5});
        ListNode.printList(head);
        ListNode.printList(reverseList2(head));

    }
}
