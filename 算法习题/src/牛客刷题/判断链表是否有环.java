package 牛客刷题;

import util.ListNode;

public class 判断链表是否有环 {
    public static boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode first = head, second = head.next;
        while(first.next!=null && second.next!=null && second.next.next!=null){
            if(first==second){
                return true;
            }
            first = first.next;
            second = second.next.next;
        }
        return first==null;

    }

    public static ListNode createList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode list = head;
        for (int i = 1; i < arr.length; i++) {
            list.next = new ListNode(arr[i]);
            list = list.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        ListNode head = createList(arr);
//        LeetCode刷题.牛客刷题.ListNode list = head;
//        while(list!=null){
//            System.out.print(list.val + "\t");
//            list = list.next;
//        }
        boolean hasCircle = hasCycle(head);
        System.out.println(hasCircle);
    }
}

