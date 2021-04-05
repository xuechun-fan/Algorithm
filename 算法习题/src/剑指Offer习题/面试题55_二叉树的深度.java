package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题55_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
