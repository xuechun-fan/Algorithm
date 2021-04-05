package 剑指Offer习题;

/**
 * Description：
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.left.parent = this;
        this.right.parent = this;
    }
    public TreeNode(int val, int left, int right){
        this.val = val;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
        this.left.parent = this;
        this.right.parent = this;
    }


    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
