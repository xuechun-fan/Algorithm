package 剑指Offer习题;

/**
 * Description：
 */
public class 面试题26_树的子结构 {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null) return false;
        //  这是一种错误的写法，因为A树中节点值可能存在重复，如果当前的值相等，但子结构不同，就会返回false
        //  但在其子结构或者另外一部分的子树中有存在相同的子结构，这时就会出现错误结果
//        return A.val==B.val ? recur(A, B) : (isSubStructure(A.left, B)||isSubStructure(A.right, B));
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    private static boolean recur(TreeNode a, TreeNode b){
        if(b==null) return true;
        if(a==null || a.val!=b.val) return false;
        return recur(a.left, b.left) && recur(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode A = TreeTool.buildTreeByString("[4,2,3,4,5,6,7,8,9]");
        TreeNode B = TreeTool.buildTreeByString("[4,8,9]");
        boolean res = isSubStructure(A, B);
        System.out.println(res);

    }
}
