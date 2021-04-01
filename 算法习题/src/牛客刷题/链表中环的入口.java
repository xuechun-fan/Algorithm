package 牛客刷题;

import util.ListNode;

public class 链表中环的入口 {
    public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode meetNode = meetingNode(head);
        if(meetNode==null){
            return null;
        }
        ListNode temp = meetNode.next;
        int lengthOfCycle = 1;
        while(temp!=meetNode){
            lengthOfCycle++;
            temp = temp.next;
        }
        meetNode = head;
        temp = head;
        while(lengthOfCycle>0){
            meetNode = meetNode.next;
            lengthOfCycle--;
        }
        while(temp!=meetNode){
            meetNode = meetNode.next;
            temp = temp.next;
        }
        return temp;
    }
    private static ListNode meetingNode(ListNode head){
        ListNode fast = head.next, low = head, temp = null;
        while(fast!=null && fast.next!=null){
            if(fast==low){
                temp = fast;
                break;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        ListNode ans = detectCycle(n1);
        System.out.println(ans.val);
        String s = "";
    }

}
