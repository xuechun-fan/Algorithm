package 剑指Offer习题;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class 面试题42_连续子数组最大和 {
    public static int maxSubArray(int[] nums) {
        /**
         * 动态规划思路
         * 时间O(n)、空间O(n)
         */
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubArray_Optimization(int[] nums) {
        /**
         * 动态规划思路
         * 对动态规划数组进行优化，因为当前的值只和前一个时刻的值相关，所以用一个变量last来记录
         * 这样只需要O(1)的空间资源
         */
        if(nums.length==1) return nums[0];
        int max = nums[0];
        int last = nums[0];
        for(int i=1; i<nums.length; i++){
            last = last>0 ? last+nums[i] : nums[i];
            max = Math.max(max, last);
        }
        return max;
    }
}
