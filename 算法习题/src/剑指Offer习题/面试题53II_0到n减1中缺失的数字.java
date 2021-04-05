package 剑指Offer习题;

/**
 * Description：
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class 面试题53II_0到n减1中缺失的数字 {
    /**
     * 这道题让我想起了一个关于二分边界条件的设置问题。
     * 一般来讲，while条件必须为 i<=j ，否则就会出现问题。
     */
    public int missingNumber(int[] nums) {
        //  本身数字就是递增有序的，所以要想到二分法
        int i = 0, j = nums.length-1;
        while(i<=j){
            int m = (i+j)>>1;
            if(nums[m]==m) i = m+1;
            else{
                j = m-1;
            }
        }
        return i;
    }
}
