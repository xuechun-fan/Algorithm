package 牛客刷题;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 实现二叉树先序中序后序遍历 {
    public static int[][] threeOrders (TreeNode root) {
        // write code here
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        traverse(root, ans);
        int len = ans.get(0).size();
        int[][] res = new int[3][len];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < len; j++) {
                res[i][j] = ans.get(i).get(j);
            }
        }
        return res;

    }
    private static void traverse(TreeNode root, List<List<Integer>> ans){
        if(root==null){
            return;
        }
        ans.get(0).add(root.val);

        traverse(root.left, ans);

        ans.get(1).add(root.val);

        traverse(root.right, ans);

        ans.get(2).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));
        int[][] res = threeOrders(root);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }

    }
}

