package LeetCode刷题;

/**
 * Description：
 */
public class 面试题17_04_消失的数字 {
    public int missingNumber(int[] nums){
        //  看到题解中有用到异或的思路，感觉也是很奇妙
        //  异或的特性：相同的数字异或结果为0
        int res = 0;
        for(int i=1; i<=nums.length; i++){
            res ^= i ^ nums[i-1];
        }
        return res;
    }

    //  自己想法
    // public int missingNumber(int[] nums) {
    //     //  求出0-n的累加和减去数组的累加和
    //     //  利用数学公式求出0-n的累加和
    //     int sumN = (nums.length*(nums.length+1))>>1;
    //     int sum = 0;
    //     for(int num:nums){
    //         sum += num;
    //     }
    //     return sumN - sum;
    // }
}
