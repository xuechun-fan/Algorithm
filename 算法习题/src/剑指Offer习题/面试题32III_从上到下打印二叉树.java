package 剑指Offer习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class 面试题32III_从上到下打印二叉树 {
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
                if(res.size()%2==0){
                    //  正序装入level容器
                    level.add(tmp.val);
                }else{
                    //  反序装入
                    level.add(0, tmp.val);
                }
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
                size--;
            }
            res.add(level);
        }
        return res;
    }
}
