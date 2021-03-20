public class 面试题18_删除链表节点 {
    public static void main(String[] args) {

//        traverse(head);
//        testP1();
        testP2();
    }

    /**  题目1：删除链表的结点
         描述：在O(1)的时间内删除链表节点
     给定单向链表的头指针和一个节点的指针，定义一个函数在O（1）时间内删除该节点。
    */
    public static ListNode deleteNode(ListNode head, ListNode toBeDel){

        //  当链表为空
        if(head==null){
            return null;
        }
        if(head==toBeDel){              //  要删除的节点为头节点
            return head.next;
        }else if(toBeDel.next==null){   //  要删除的节点为尾节点
            ListNode pre = head;
            while(pre.next!=toBeDel){
                pre = pre.next;
            }
            pre.next = null;
        } else{                         //  当要删除的节点位于链表中间，即非头节点和尾节点，则采用复制策略
            ListNode next = toBeDel.next;
            toBeDel.val = next.val;
            toBeDel.next = next.next;
        }
        return head;
    }
    //  问题 1 测试函数
    public static void testP1(){
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ListNode head1 = createList(arr);
        ListNode head2 = createList(arr);
        ListNode head3 = createList(arr);
        ListNode del1 = head1;
        ListNode del2 = head2.next.next.next;
        ListNode del3 = head3.next.next.next.next.next.next;
        ListNode[] list = {del1, del2, del3};
        ListNode[] heads = {head1, head2, head3};
        for(int i=0; i<3; i++){
            traverse(deleteNode(heads[i], list[i]));
        }
    }


    /**
        题目2： 删除链表中重复的节点
     描述:
        删除重复的节点，比如：  1， 2， 3， 3， 4， 4， 5
        删除结果为： 1， 2， 5
     1, 1, 2, 3 --> 2, 3
     1, 1, 1 --> null
        需要考虑三种情况，重复节点在头节点、中间节点、尾节点这三种情况都要加以考虑
     */
    public static ListNode deleteDuplicate(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode node = head;
        while(node!=null){
            ListNode next = node.next;
            boolean flag = false;
            if(next!=null && next.val==node.val){
                flag = true;
            }

            if(!flag){
                pre = node;
                node = node.next;
            }else{
                int value = node.val;
                ListNode toBeDelNode = node;
                while(toBeDelNode!=null && toBeDelNode.val==value){
                    next = toBeDelNode.next;
                    toBeDelNode = next;
                }
                if(pre==null){
                    head = next;
                }else{
                    pre.next = next;
                }
                node = next;
            }
        }
        return head;
    }
    //  问题 2 测试函数
    public static void testP2(){
        int[] arr1 = {1, 2, 3, 3, 4, 4, 5};
        int[] arr2 = {1, 1, 3, 3, 4, 4, 5};
        int[] arr3 = {1, 2, 3, 3, 4, 4};
        int[] arr4 = {1, 1};
        int[][] arrS = {arr1, arr2, arr3, arr4};
        for (int i = 0; i < 4; i++) {
            traverse(deleteDuplicate(createList(arrS[i])));
        }
    }



    /**
     * 工具函数
     */
    //  根据数组创建链表
    public static ListNode createList(int[] arr){
        if(arr==null || arr.length==0){
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        int i = 1;
        while(i<arr.length){
            temp.next = new ListNode(arr[i]);
            i++;
            temp = temp.next;
        }
        return head;
    }

    //  遍历输出链表
    public static void traverse(ListNode head){
        if(head==null){
            System.out.println("链表为空");
        }else{
            System.out.println("*********************************");
            while(head!=null){
                System.out.print(head.val + "\t");
                head = head.next;
            }
            System.out.println();
            System.out.println("*********************************");
            System.out.println();
        }
    }
}
