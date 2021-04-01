package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Tool {

    /**
     * 根据数组生成对应的链表
     * @param arr：输入数组
     * @return ：返回链表头节点
     */
    public static ListNode createList(int[] arr){
        int len = arr.length;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int i = 0;
        while(i<len){
            temp.next = new ListNode(arr[i++]);
            temp = temp.next;
        }
        return head.next;
    }

    public static void traverse(ListNode head){
        if(head==null){
            System.out.println("链表为空！！！");
        }
        ListNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.val + "\t");
            ptr = ptr.next;
        }
        System.out.println();
    }

    public static void levelTraverse(TreeNode root){
        if(root==null){
            return;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(queue.size()!=0){
            int size = queue.size();
            TreeNode t = null;
            while(size>0){
                t = queue.remove(0);
                System.out.print(t.val + "\t");
                size--;
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
            System.out.println();
        }
    }


}
