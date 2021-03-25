package LeetCode刷题;

import util.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Leetcode_111_二叉树的最小深度 {
    /**
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     */

    public int minDepth(TreeNode root){
        if(root==null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left==0 || right==0){
            return (left==0 ? right : left) + 1;
        }
        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        int[] nums = new int[2];


    }
}
