package 牛客刷题;

import util.Tool;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树的右视图 {
    public static int[] solve(int[] pre, int[] in){
        if(pre==null || pre.length==0){
            return null;
        }
        TreeNode root = buildTree(pre, in, 0, pre.length-1, 0, pre.length-1);
        return rightVision(root);
    }

    public static TreeNode buildTree(int[] pre, int[] in, int ps, int pe, int is, int ie){
        if(ps>pe){
            return null;
        }
        TreeNode root = new TreeNode(pre[ps]);
        int rootIndex =0;
        while(in[rootIndex]!=root.val){
            rootIndex++;
        }

        root.left = buildTree(pre, in, ps+1, ps+rootIndex-is, is, rootIndex-1);
        root.right = buildTree(pre, in, ps+rootIndex-is+1, pe, rootIndex+1, ie);
        return root;
    }

    public static int[] rightVision(TreeNode root){
        List<TreeNode> dequeue = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dequeue.add(root);
        while(dequeue.size()!=0){
            int size = dequeue.size();
            ans.add(dequeue.get(size-1).val);
            TreeNode t = null;
            while(size>0){
                t = dequeue.remove(0);
                size--;
                if(t.left!=null){
                    dequeue.add(t.left);
                }
                if(t.right!=null){
                    dequeue.add(t.right);
                }
            }
        }
        int[] res = new int[ans.size()];
        int index = 0;
        for(Integer integer : ans){
            res[index++] = integer;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 8, 4, 5, 6, 7, 3};
        int[] in = new int[]{8,2,1,5,7,6,4,3};
        int[] res = solve(pre, in);
        for (int i:
             res) {
            System.out.println(i);
        }



    }
}
