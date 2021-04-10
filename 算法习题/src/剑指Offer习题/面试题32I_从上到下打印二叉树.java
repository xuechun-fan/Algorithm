package 剑指Offer习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：
 */
public class 面试题32I_从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            res.add(tmp.val);
            if(tmp.left!=null) q.offer(tmp.left);
            if(tmp.right!=null) q.offer(tmp.right);
        }
        int[] level = new int[res.size()];
        int idx = 0;
        for(Integer value : res){
            level[idx++] = value;
        }
        return level;
    }
}
