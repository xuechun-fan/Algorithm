package LeetCode刷题;

/**
 * 合并 k 个升序链表
 */
public class Solution_023 {

    //  方法1：顺序合并
    public static ListNode mergeKLists(ListNode[] lists){
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }
    public static ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a==null || b==null){
            return a!=null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while(aPtr!=null && bPtr!=null){
            if(aPtr.val < bPtr.val){
                tail.next = aPtr;
                aPtr = aPtr.next;
            }else{
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;

        }
        tail.next = aPtr==null ? bPtr : aPtr;
        return head.next;
    }

    //  方法2：分治法
    public static ListNode mergeKListsRecursive(ListNode[] lists){
        return merge(lists, 0, lists.length-1);
    }
    public static ListNode merge(ListNode[] lists, int l, int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid = (l+r)>>1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(0, new ListNode(3, new ListNode(6)));
        ListNode l2 = new ListNode(1, new ListNode(12, new ListNode(28)));
        ListNode l3 = new ListNode(5, new ListNode(12, new ListNode(18)));

        ListNode[] lists = {l1, l2, l3};

        ListNode ans = mergeKListsRecursive(lists);
        ListNode temp = ans;
        while(temp!=null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }

    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
