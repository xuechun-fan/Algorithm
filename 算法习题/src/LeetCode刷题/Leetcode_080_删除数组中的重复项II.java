package LeetCode刷题;

/**
 * Description:
 */
public class Leetcode_080_删除数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int x = 0, t = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[x] && t<2){
                nums[++x] = nums[i];
                t++;
            }else if(nums[i]!=nums[x]){
                t = 1;
                nums[++x] = nums[i];
            }
        }
        return x+1;
    }
}
