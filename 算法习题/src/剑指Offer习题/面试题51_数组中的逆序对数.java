package 剑指Offer习题;

/**
 * Description:
 */
public class 面试题51_数组中的逆序对数 {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，
     * 则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     * 示例 1:
     *
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     */
    private int[] tmp;
    public int reversePairs(int[] nums) {
        if(nums==null || nums.length<2) return 0;
        //  逆序对的话，考虑到归并排序
        this.tmp = new int[nums.length];
        return mergeSort(nums, 0, nums.length-1);
    }

    private int mergeSort(int[] nums, int l, int r){
        if(l>=r) return 0;
        //  递归分组
        int m = (l+r)>>1;
        int res = mergeSort(nums, l, m) + mergeSort(nums, m+1, r);
        //  合并，注意 m 是左半数组最后一个元素的下标
        //  复制数据到临时数组中
        for(int i=l; i<=r; i++) tmp[i] = nums[i];
        int i = l, j = m+1;
        for(int k=l; k<=r; k++){
            if(i==m+1) nums[k] = tmp[j++];
            else if(j==r+1 || tmp[i]<=tmp[j]) nums[k] = tmp[i++];
            else{
                nums[k] = tmp[j++];
                res += m-i+1;
            }
        }
        return res;
    }
}
