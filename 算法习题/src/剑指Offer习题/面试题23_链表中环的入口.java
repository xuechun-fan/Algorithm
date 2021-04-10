package 剑指Offer习题;

/**
 * Description：
 * 找出链表的环的入口，如果不存在环，返回null
 */
public class 面试题23_链表中环的入口 {
    public static ListNode findEntranceOfCircle(ListNode head){
        if(head==null) return null;
        //  先判断是否有环
        ListNode low = head, fast = head.next;
        while(fast!=null && fast.next!=null){
            if(low==fast) break;
            low = low.next;
            fast = fast.next.next;
        }
        if(fast==null || fast.next==null){
            //  说明链表中没有环，则直接返回null
            return null;
        }
        //  统计环中节点数量
        fast = fast.next;
        int  cnt = 1;
        while(low!=fast){
            fast = fast.next;
            cnt++;
        }
        low = head;
        fast = head;
        while(cnt>0){
            fast = fast.next;
            cnt--;
        }
        while(low!=fast){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        ListNode res = findEntranceOfCircle(head);
        System.out.println(res==null);
        //  对head链表进行加环处理
        ListNode tmp = head;
        //  假设2为环的入口
        int idx = 1;
        while(idx>0){
            tmp = tmp.next;
            idx--;
        }
        ListNode ent = tmp; //  保存入口
        while(tmp.next!=null){
            tmp = tmp.next;
        }
        //  此时tmp为尾节点
        tmp.next = ent;
        ListNode entranceOfCircle = findEntranceOfCircle(head);
        System.out.println(entranceOfCircle.val);
    }
}
