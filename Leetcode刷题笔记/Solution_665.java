package LeetCode刷题;

/**
    非递减数列
 */
public class Solution_665 {
    public static boolean checkPossibility(int[] nums){
        if(nums==null){
            return false;
        }
        int len = nums.length;
        int count = 0;
        for (int i = 1; i < len; i++) {
            if(nums[i] < nums[i-1]){
                if(i==1 || nums[i] < nums[i-2]){
                    nums[i] = nums[i-1];
                }
//                else{
//                    nums[i-1] = nums[i];
//                }
                count++;
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}
