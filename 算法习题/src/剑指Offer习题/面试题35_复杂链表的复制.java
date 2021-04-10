package 剑指Offer习题;

import java.util.List;

/**
 * Description：
 */
public class 面试题35_复杂链表的复制 {
    public ListNode copyRandomList(ListNode head) {
        //  复杂链表复制分为3步来做
        //  copy -->  abc --> a,a',b,b',c,c'
        copy(head);
        //  copyRandom 对a',b',c'的random指针进行复制
        copyRandom(head);
        //  divide: 将复制后的链表从中分割出来
        return divide(head);
    }
    private void copy(ListNode head){
        if(head==null) return;
        ListNode cur = head;
        ListNode next;
        while(cur!=null){
            next = cur.next;
            ListNode node = new ListNode(cur.val);
            cur.next = node;
            node.next = next;
            cur = next;
        }
    }
    private void copyRandom(ListNode head){
        if(head==null) return;
        ListNode oldCur = head;
        ListNode newCur = head.next;
        ListNode next;
        while(newCur!=null){
            newCur.random = oldCur.random==null ? null : oldCur.random.next;
            if(newCur.next==null){
                break;
            }
            oldCur = newCur.next;
            newCur = oldCur.next;
        }
    }
    private ListNode divide(ListNode head){
        if(head==null) return null;
        ListNode newHead = head.next;
        ListNode oldCur = head;
        ListNode newCur = newHead;
        ListNode next;
        while(newCur!=null){
            next = newCur.next;
            oldCur.next = next;
            newCur.next = next==null ? null : next.next;
            oldCur = next;
            if(oldCur==null){
                break;
            }
            newCur = oldCur.next;
        }
        return newHead;
    }
}
