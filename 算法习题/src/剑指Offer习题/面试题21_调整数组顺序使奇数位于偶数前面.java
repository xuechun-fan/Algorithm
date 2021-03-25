package 剑指Offer习题;

import java.util.*;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
public class 面试题21_调整数组顺序使奇数位于偶数前面 {
    public static int[] exchange(int[] nums) {
        if(nums==null || nums.length==0) return nums;
        int l = 0, r = nums.length-1;
        //  快排的思想，变更调整顺序的条件， 一边遍历即可
        while(l<r){
            while(r>l && nums[r]%2!=1){
                r--;    // 从右往左找到第一个奇数
            }
            while(l<r && nums[l]%2!=0){
                l++;    // 从左往右找到第一个偶数
            }
            if(l<r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        Stack<Integer> s = new Stack<>();
        Deque<Integer> q = new LinkedList<>();

        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        exchange(arr);
        for (int n:
             arr) {
            System.out.print(n + "\t");
        }
    }
}