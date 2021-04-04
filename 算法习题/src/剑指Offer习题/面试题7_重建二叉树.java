package 剑指Offer习题;

/**
 * Description：根据前序和中序序列，重建二叉树
 */
public class 面试题7_重建二叉树 {

    //  重建二叉树
    public static TreeNode rebuildTree(int[] pre, int[] in){
        if(pre==null || pre.length==0 || in==null || in.length==0) return null;
        TreeNode root = rebuildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return root;
    }
    private static TreeNode rebuildTree(int[] pre, int[] in, int ps, int pe, int is, int ie){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(pre[ps]);
        int idx = is;
        //  在中序序列中找到根节点的下标
        while(idx<=ie && in[idx]!=pre[ps]){
            idx++;
        }
        int leftSize = idx-is;  //  左子树节点个数
        root.left = rebuildTree(pre, in, ps+1, ps+leftSize, is, idx-1);
        root.right = rebuildTree(pre, in, ps+leftSize+1, pe, idx+1, ie);
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null , new TreeNode(6)));
        TreeTool.levelPrint(root);
        System.out.println("*****************************");

        int[] preArr = new int[]{1, 2, 4, 5, 3, 6};
        int[] inArr = new int[]{4, 2, 5, 1, 3, 6};
        TreeNode rt = rebuildTree(preArr, inArr);
        TreeTool.levelPrint(rt);
    }
}

