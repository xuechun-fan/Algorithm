package LeetCode刷题;

import org.junit.Test;

public class Leetcode_137_只出现一次的数字II {
    public int singleNumber(int[] nums) {
        //  有限状态机，三个数相加后按位对3取余为0，所以所有数字相加后按位对3取余结果就是我们需要的数字
        //  取余每位状态有三种情况，0、1、2 。用两位二进制数表示三种状态，00，01，10
        int two = 0, one = 0;
        for(int num:nums){
            one = (one^num) & ~two;
            two = (two^num) & ~one;
        }
        return one;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1, 1, 1, 4, 5, 5, 5};
        int i = singleNumber(nums);
        System.out.println(i);
    }
}