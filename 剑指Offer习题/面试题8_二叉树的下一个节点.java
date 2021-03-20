/**
 * Description：
 */
public class 面试题8_二叉树的下一个节点 {

    //  二叉树的下一个节点
    public static <T> TreeNode<T>  findNext(TreeNode<T> cur){
        if(cur==null){
            return null;
        }
        TreeNode<T> next = null;
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
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");
        TreeNode<String> i = new TreeNode<>("i");

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
        TreeNode<String> res = findNext(g);
        System.out.println("下一个：" + (res==null?"该节点已是最后一个节点":res.val));
    }
}
