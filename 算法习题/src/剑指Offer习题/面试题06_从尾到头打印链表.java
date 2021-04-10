package 剑指Offer习题;

import java.util.ArrayList;
import java.util.List;

/**
 * Description：
 */
public class 面试题06_从尾到头打印链表 {
    //  两次遍历的方法
    public static int[] reversePrint(ListNode head) {
        if(head==null) return new int[0];
        //  第一次遍历，统计链表元素数量
        int cnt = 0;
        ListNode tmp = head;
        while(tmp!=null){
            cnt++;
            tmp = tmp.next;
        }
        int[] res = new int[cnt];
        tmp = head;
        while(tmp!=null){
            res[--cnt] = tmp.val;
            tmp = tmp.next;
        }
        return res;
    }

    //  普通的递归方法
//    static List<Integer> list = new ArrayList<>();
//    public static int[] reversePrint(ListNode head) {
//        if(head==null) return new int[0];
//        recur(head);
//        int[] res = new int[list.size()];
//        int idx = 0;
//        for (Integer num : list){
//            res[idx++] = num;
//        }
//        return res;
//    }
//    private static void recur(ListNode head){
//        if(head==null) return;
//        recur(head.next);
//        list.add(head.val);
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.buildList(nums);
        int[] res = reversePrint(head);
        for(int num:res){
            System.out.print(num + "\t");
        }
    }
}
