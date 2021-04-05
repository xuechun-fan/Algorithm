package 剑指Offer习题;

/**
 * Description：给定一棵二叉树和其中的一个节点，找出中序遍历的下一个节点，树的定义除了left和right指针，还有parent指针
 */
public class 面试题8_二叉树的下一个节点 {

    //  找出二叉树的下一个节点
    public static TreeNode findNext(TreeNode cur){
        //  根据当前节点的情况分析
        //  中序遍历的特点是： 左 --> cur --> 右
        //  也就是说，每次遍历到的节点，其左子树一定是遍历过的了，下一个节点要么在其右子树上，要么往上层退出递归
        if(cur.right!=null){
            //  如果该节点有左子树，那么下一个节点一定是其右子树中的最左边的节点
            TreeNode tmp = cur.right;
            while(tmp.left!=null){
                tmp = tmp.left;
            }
            return tmp;
        }
        //  如果当前节点没有右子树，则需要向上寻找
        //  这里还是要分两种情况的，一种是当前节点是其父节点的左子节点，这时，下一个节点就是其父节点
        if(cur.parent.left==cur) return cur.parent;
        //  另外一种情况是当前节点是其父节点的右子树，这种就比较麻烦
        //  其实仔细分析，出现这种情况的原因是因为，当前节点是其所在的最小左子树已经遍历完了，需要向上跳出了，所以
        //  必须向上找到第一个满足下述情况的节点，这个节点必须满足它是它父节点的左子节点
        TreeNode res = cur;
        while(res != res.parent.left){
            res = res.parent;
        }
        return res.parent;
    }

    public static void main(String[] args) {
        /**
         *             1
         *          /    \
         *        2       3
         *      /  \    /  \
         *     4   5  -1    6           -1:null节点
         */
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        root.left = n2; root.right = n3; n2.parent = root; n3.parent=root;
        n2.left = n4; n2.right=n5; n4.parent=n2; n5.parent=n2;
        n3.right=n6; n6.parent=n3;
        TreeNode tmp = null;
        //  有右子节点
        tmp = findNext(n2);
        System.out.println(tmp.val);
        //  没有右子节点，但当前节点是其父节点的左子节点
        tmp = findNext(n4);
        System.out.println(tmp.val);
        //  没有右子节点，当前节点是其父节点的右子节点
        tmp = findNext(n5);
        System.out.println(tmp.val);
        //  输入为根节点呢？
        tmp = findNext(root);
        System.out.println(tmp.val);

    }
}
