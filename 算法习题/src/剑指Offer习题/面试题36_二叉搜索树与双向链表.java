package 剑指Offer习题;

class Solution {
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);
        if(pre==null){
            head = cur;
        }else{
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

public class 面试题36_二叉搜索树与双向链表 {

}
