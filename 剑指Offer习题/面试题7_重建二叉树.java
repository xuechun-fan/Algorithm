/**
 * Description：根据前序和中序序列，重建二叉树
 */
public class 面试题7_重建二叉树 {

    //  重建二叉树
    public static <T> TreeNode<T> rebuildTree(T[] pre, T[] in, int ps, int pe, int is, int ie){
        if(pre==null || pre.length==0 || in==null || in.length==0 || ps > pe || is > ie){
            return null;
        }
        T rootVal = pre[ps];
        TreeNode<T> root = new TreeNode<T>(rootVal);
        int i;
        for (i = is; i <= ie; i++) {
            if(in[i]==rootVal){
                break;
            }
        }
        root.left = rebuildTree(pre, in, ps+1, ps+i-is, is, i-1);
        root.right = rebuildTree(pre, in, ps+i-is+1, pe, i+1, ie);
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<Integer> (2, new TreeNode<Integer> (4, null, new TreeNode<Integer> (7, null, null)), null),
                new TreeNode<Integer> (3, new TreeNode<Integer> (5, null, null), new TreeNode<Integer> (6, new TreeNode<Integer> (8, null, null), null)));
        TreeTool.levelPrint(root);
        System.out.println("*****************************");

        Integer[] preArr = new Integer[]{1, 2, 4, 7, 3, 5, 6, 8};
        Integer[] inArr = new Integer[]{4, 2, 7, 1, 5, 3, 6, 8};
        TreeNode<Integer> rt = rebuildTree(preArr, inArr, 0, preArr.length-1, 0, inArr.length-1);
        TreeTool.levelPrint(rt);
    }
}

