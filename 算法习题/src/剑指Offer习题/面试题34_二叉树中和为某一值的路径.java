package 剑指Offer习题;

import java.util.*;

/**
 * Description：
 */
public class 面试题34_二叉树中和为某一值的路径 {
    private static List<List<Integer>> res = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int target){
        if(root==null) return res;
        dfs(root, target);
        return res;
    }
    private static void dfs(TreeNode root, int target){
        if(root==null) return;
        path.add(root.val);
        target -= root.val;
        //  要判断叶子节点和当前值是否满足路径要求
        if(root.left==null && root.right==null && target==0){
            res.add(new ArrayList<>(path));
        }
        //  如果存在负数target，就不可以这样剪枝。
//        if(target<0){
//            path.remove(path.size()-1);
//            return;
//        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeTool.buildTreeByString("[5,4,18,3,5,20,1,7,null,null,5]");
        List<List<Integer>> res = pathSum(root, 19);

        for (List<Integer> list : res){
            System.out.println(list);
        }
    }
}
