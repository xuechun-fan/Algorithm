package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题54_二叉搜索树的第K大节点 {
    private int res;
    private int k;
    public int kthLargest(TreeNode root, int k) {
        /**
         *  首先考虑BST特点，中序遍历是从小到大有序的，而题目现在要求找第k大
         *  那么显而易见就要想如何实现从大到小有序遍历咯
         *  正常中序遍历：左--->根--->右
         *  现在需要反向思考： 右--->根--->左
         *  这样就是降序了
         */
        //  首先搭建出反向中序遍历框架
        this.k = k;
        reverseInorder(root);
        return res;
    }

    private void reverseInorder(TreeNode root){
        if(k==0 || root==null) return;
        reverseInorder(root.right);
        k--;
        if(k==0) {
            res = root.val;
            return;
        }
        reverseInorder(root.left);
    }
}
