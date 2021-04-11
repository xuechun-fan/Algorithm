package LeetCode刷题;

/**
 * Description:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 */
public class Leetcode_045跳跃游戏II {
    public static int jump(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            for(int x = i+1; x<=i+nums[i]; x++){
                if(x>=dp.length) break;
                dp[x] = dp[x]==0? dp[i]+1 : Math.min(dp[i]+1, dp[x]);
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        int res = jump(nums);
        System.out.println(res);
    }
}
