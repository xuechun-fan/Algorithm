package 剑指Offer习题;

/**
 * Description：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class 面试题55II_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return depth(root)!=-1;
    }

    private int depth(TreeNode root){
        if(root==null) return 0;
        int left = depth(root.left);
        if(left==-1) return -1;
        int right = depth(root.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<2 ? 1+Math.max(left, right) : -1;
    }
}
