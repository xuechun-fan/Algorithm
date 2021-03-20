/**
 * Description：
 */
public class 面试题6_从尾到头打印链表 {
    //  根据数组创建链表
    public static MyNode createList(int[] arr){
        if(arr==null || arr.length==0){
            return null;
        }
        MyNode head = new MyNode(arr[0]);
        MyNode temp = head;
        for(int i=1; i<arr.length; i++){
            temp.setNext(new MyNode(arr[i]));
            temp = temp.next;
        }
        return head;
    }

    //  顺序打印链表
    public static void traverseList(MyNode head){
        if(head==null){
            return;
        }
        System.out.print("\t" + head.ele);
        traverseList(head.next);
    }
    //  逆序打印链表
    public static void reversePrintList(MyNode head){
        if(head==null){
            return;
        }
        reversePrintList(head.next);
        System.out.print("\t" + head.ele);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        MyNode list = createList(arr);
        traverseList(list);
        System.out.println("\n**********************");
        reversePrintList(list);
    }

}

class MyNode{
    public int ele;
    public MyNode next;

    public MyNode(int ele) {
        this.ele = ele;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}