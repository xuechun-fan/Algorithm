package LeetCode刷题;
import util.TreeNode;

public class Leetcode_671_二叉树中第二小的节点 {
    /**
     * 给定一个非空特殊的二叉树，每个节点都是正数，
     * 并且每个节点的子节点数量只能为0。如果一个节点有两个子节点的话，
     * 那么该节点的值等于两个子节点中较小的一个。
     *
     * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
     *
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。
     * 如果第二小的值不存在的话，输出 -1 。
     */
    long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root){
        if(root==null) return -1;
        int min = root.val;
        dfs(root, min);
        if(ans==Long.MAX_VALUE) return -1;
        return (int)ans;
    }
    private void dfs(TreeNode root, int min){
        if(root==null) return;
        if(root.val>min && root.val<ans) ans = root.val;
        dfs(root.left, min);
        dfs(root.right, min);
    }

}
