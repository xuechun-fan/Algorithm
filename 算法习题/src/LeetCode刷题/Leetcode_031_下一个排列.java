package LeetCode刷题;

import org.junit.Test;

import java.util.Arrays;

public class Leetcode_031_下一个排列 {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0) return;
        int len = nums.length;
        int i = len-2, j = len-1, k = len-1;
        //  从后向前找第一个升序对
        for(;i>=0 && nums[i]>=nums[j]; i--, j--){

        }
        if(i>=0){// 不是最后一个排列
            //  从后向前找到第一个
            while(k>j && nums[k]<=nums[i])
                k--;
            //  交换i 和 k
            int t = nums[i];
            nums[i] = nums[k];
            nums[k] = t;
        }
        //  对j之后的元素进行排序
        Arrays.sort(nums, j, len);
    }

    @Test
    public void test(){
        int[] nums = new int[]{1, 5, 1};
        nextPermutation(nums);
        for(int num:nums){
            System.out.print(num + "\t");
        }
    }
}