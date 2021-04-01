package 剑指Offer习题;

/**
 * Description：
 */
public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right, TreeNode<T> parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
