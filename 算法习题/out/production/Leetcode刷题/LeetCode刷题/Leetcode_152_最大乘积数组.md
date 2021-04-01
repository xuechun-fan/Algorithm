# 

# Leetcode_152_最大乘积数组

题目描述：

给你一个整数数组 `nums` ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

**思路：**动态规划法

假设创建 dp[nums.length]  的数组，每个元素代表截至到 i 位置的最大乘积，这样可以轻松推出状态方程，当前位置的最大值取决于当前值和前一位的最大值，即 dp[i] = Math.max ( dp[i-1] * nums[i], nums[i] )。但是这个方程只适用于nums数组中全为非负整数的情况，假设 nums = {2， 4， 5， -2， -3} ，按照这种方程得到 dp = {2，8，40，-2，6} 。因为在 遇到 nums[1] = -2 的时候产生了负数，这样的话就会导致结果错误，但是后面还有负数-3，那么我们之前得到的负的乘积乘上当前的负数-3，结果就会变成最大的正数240 。负负得正，所以呢，我们不仅需要维护一个最大值变量，还要维护一个最小值变量，这样用来处理遇到负数的情况。

```java
class Solution{
    public int maxProduct(int[] nums){
        int iMax = nums[0], iMin = nums[0], res = nums[0];
        for(int i=1; i<nums.length; i++){
            //	创建临时变量保存上一时刻的 iMax iMin
            int im = iMax, in = iMin;
            //	更新 iMax 和 iMin
            iMax = Math.max(nums[i], Math.max(nums[i]*im, nums[i]*in));
            iMin = Math.min(nums[i], Math.min(nums[i]*im, nums[i]*in));
            //	结果当然是之前的最大值和当前较大的值去比较
            res = Math.max(res, iMax);
        }
        return res;
    }
}
```

