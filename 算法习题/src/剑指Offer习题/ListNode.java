package 剑指Offer习题;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode random;

    public ListNode(int val) {
        this.val = val;
    }


    //  根据数组建立链表
    public static ListNode buildList(int[] nums){
        if(nums==null || nums.length==0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode tmp = head;
        for(int i=1; i<nums.length; i++){
            tmp.next = new ListNode(nums[i]);
            tmp = tmp.next;
        }
        return head;
    }

    //  遍历打印链表
    public static void printList(ListNode head){
        if(head==null){
            System.out.println("链表为空！");
        }
        ListNode tmp = head;
        while (tmp!=null){
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }


}
