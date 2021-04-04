package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题8_二叉树的下一个节点 {

    //  二叉树的下一个节点
    public static TreeNode findNext(TreeNode cur){
        if(cur==null){
            return null;
        }
        TreeNode next = null;
        if(cur.right!=null){    //  当前节点有右子树的情况
            next = cur.right;
            while(next.left!=null){
                next = next.left;
            }
            return next;
        }
        if(cur==cur.parent.left){
            next = cur.parent;
            return next;
        }else if(cur==cur.parent.right){
            next = cur;
            while(next.parent!=null){
                if(next.parent.parent==null){
                    return null;
                }
                if(next.parent == next.parent.parent.left){
                    next = next.parent;
                    break;
                }
                next = next.parent;
            }
        }


        return next;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = h;
        e.right = i;
        c.left = f;
        c.right = g;

        b.parent = a;
        c.parent = a;
        d.parent = b;
        e.parent = b;
        h.parent = e;
        i.parent = e;
        f.parent = c;
        g.parent = c;

        TreeTool.levelPrint(a);
        TreeNode res = findNext(g);
        System.out.println("下一个：" + (res==null?"该节点已是最后一个节点":res.val));
    }
}
