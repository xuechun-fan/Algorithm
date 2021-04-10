package 剑指Offer习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class 面试题32II_从上到下打印二叉树 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> level;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return res;
        //  基本思想是BFS层序遍历，在添加新的结果集时改动一点细节即可
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            level = new ArrayList<>();
            while(size>0){
                TreeNode tmp = q.poll();
                level.add(tmp.val);
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
                size--;
            }
            res.add(level);
        }
        return res;
    }
}
