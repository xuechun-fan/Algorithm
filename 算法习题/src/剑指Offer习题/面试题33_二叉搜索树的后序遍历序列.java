package 剑指Offer习题;

/**
 * Description：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * 示例 1：
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 示例 2：
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class 面试题33_二叉搜索树的后序遍历序列 {
    public static boolean verifyPostorder(int[] postorder) {
        //  分析后序遍历的特点
        //  左 -》 右 -》 根
        //  那么序列最后一个数据一定是根节点的值
        //  序列中前一部分为左子树的节点，需满足均小于根节点，后一部分为右子树的节点，需要均大于根节点
        //  由此，递归的思路就出来了
        if(postorder==null || postorder.length<=1) return true;
        return dfs(postorder, 0, postorder.length-1);
    }

    private static boolean dfs(int[] nums, int l, int r){
        if(l>=r) return true;
        //  找到根节点
        int root = nums[r];
        //  创建索引变量，记录下标
        int idx = l;
        //  检查左子树边界下标
        while(idx<r && nums[idx]<root) idx++;
        //  记录下来边界值
        int bnd = idx;
        //  检查右子树下标
        while(idx<r && nums[idx]>root) idx++;
        //  如果idx此时能够遍历到r位置，说明当前序列没问题，则继续递归检查其子序列，否则直接返回false
        return idx==r ? dfs(nums, l, bnd-1)&&dfs(nums, bnd, r-1) : false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 7, 5};
        boolean b = verifyPostorder(nums);
        System.out.println(b);
    }


}
