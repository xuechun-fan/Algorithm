package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题28_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return recur(root.left, root.right);
    }
    private boolean recur(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return true;
        //  如果只有其中一个节点为null，或者两者都不为null但两节点值不相等，则不对称，返回false
        if(r1==null || r2==null || r1.val!=r2.val) return false;
        return recur(r1.left, r2.right) && recur(r1.right, r2.left);
    }
}
