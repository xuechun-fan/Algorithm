package 剑指Offer习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：
 */
public class TreeTool {
    //  二叉树层序遍历
    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = null;
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            level = new ArrayList<>();
            while(size!=0){
                TreeNode temp = queue.poll();
                level.add((Integer) temp.val);
                size--;
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            res.add(level);
        }
        return res;
    }

    //  按照层序打印二叉树
    public static void levelPrint(TreeNode root){
        List<List<Integer>> res = levelOrder(root);
        for(List<Integer> list:res){
            for (Integer num:
                 list) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }


    //  根据前序和中序序列建立二叉树
    public static TreeNode buildTreeByPreAndIn(int[] preOrder, int[] inOrder){
        return 面试题7_重建二叉树.rebuildTree(preOrder, inOrder);
    }

    //  根据字符串创建二叉树
    public static TreeNode buildTreeByString(String data) {
        if("[]".equals(data) || "[null]".equals(data)) return null;
        data = data.substring(1, data.length()-1);
        String[] nums = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i<nums.length){
            int size = q.size();
            while(i< nums.length && size>0){
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

}
