package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题27_二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        //  思路比较简单了，每一层递归都是在将当前节点的左右子树对换
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
