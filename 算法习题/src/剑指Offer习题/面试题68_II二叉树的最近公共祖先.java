package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题68_II二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==q || root==p) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }
}
