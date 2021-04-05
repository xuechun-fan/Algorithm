package 剑指Offer习题;

/**
 * Description：统计一个数字在排序数组中出现的次数。
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 */
public class 面试题53_在排序数组中查找数字 {
    public int search(int[] nums, int target) {
        //  简单的思维就是遍历一遍，然后统计次数就ok，但是这就忽略了数组有序这个重要的性质
        //  说到数组有序，并且是查找相关的问题，显然就是二分查找了
        //  对于本道题，是基于二分查找，先找到这个数字，然后想办法左右延申，统计次数
        int i=0, j=nums.length-1;
        int times = 0;
        while(i<=j){
            int m = (i+j)>>1;
            if(nums[m]==target){
                //  找到该数字了，那么开始左右延申统计
                //  向左延申
                int idx = m;
                while(idx>=0 && nums[idx]==target){
                    idx--;
                    times++;
                }
                //  向右延申
                idx = m+1;
                while(idx<nums.length && nums[idx]==target){
                    idx++;
                    times++;
                }
                break;
            }else if(nums[m]<target) i = m+1;
            else j = m-1;
        }
        return times;
    }
}
