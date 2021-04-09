package 剑指Offer习题;

import java.util.LinkedList;
import java.util.Queue;

public class 面试题37_序列化二叉树 {
    /**
     * 这道题核心思想在于二叉树层序遍历的使用，两种方式有一点细节不太一样，整体思路都是BFS
     */
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            res.append(tmp==null ? "null" : tmp.val);
            res.append(",");
            if(tmp!=null){
                q.offer(tmp.left);
                q.offer(tmp.right);
            }
        }
        res.deleteCharAt(res.length()-1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null || "[]".equals(data) || "[null]".equals(data)) return null;
        data = data.substring(1, data.length()-1);
        String[] nums = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<nums.length){
            int size = q.size();
            while(size>0){
                TreeNode tmp = q.poll();
                if(tmp!=null){
                    tmp.left = "null".equals(nums[i]) ? null : new TreeNode(Integer.parseInt(nums[i]));
                    q.add(tmp.left);
                    i++;
                    tmp.right = "null".equals(nums[i]) ? null : new TreeNode(Integer.parseInt(nums[i]));
                    q.add(tmp.right);
                    i++;
                }
                size--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        String res = serialize(root);
        System.out.println(res);

        System.out.println("--------------------------------");
        TreeNode newRoot = deserialize("[1,2,3,null,null,4,5]");
        TreeTool.levelPrint(newRoot);
    }
}














