package 牛客刷题;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

import java.util.Stack;

public class Z字遍历二叉树 {
    public static List<List<Integer>> z_Traverse(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        List<Integer> ans = null;
        boolean l2r = true;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int size = Math.max(stack1.size(), stack2.size());
            ans = new ArrayList<Integer>();
            while(size>0){
                TreeNode temp = null;
                if(l2r){
                    temp = stack1.pop();
                    if(temp.left!=null){
                        stack2.push(temp.left);
                    }
                    if(temp.right!=null){
                        stack2.push(temp.right);
                    }
                }else{
                    temp = stack2.pop();
                    if(temp.right!=null){
                        stack1.push(temp.right);
                    }
                    if(temp.left!=null){
                        stack1.push(temp.left);
                    }
                }
                ans.add(temp.val);
                size--;
            }
            l2r = !l2r;
            res.add(ans);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, 7, 8), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6, 9, 10)));
        List<List<Integer>> lists = z_Traverse(root);
        System.out.println("[");
        for(List list:lists){
            System.out.println(list.toString());
        }
        System.out.println("]");

    }
}
