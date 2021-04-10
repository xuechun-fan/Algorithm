package 剑指Offer习题;


/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *
 */
public class 面试题21_调整数组顺序使奇数位于偶数前面 {
    public static int[] exchange(int[] nums) {
        if(nums==null || nums.length==0) return nums;
        //  双指针法，类似于快排的分组思想
        int i = 0, j = nums.length-1;
        while(i<j){
            while(i<j && (nums[j]&0x01)==0) j--;
            while(i<j && (nums[i]&0x01)!=0) i++;
            if(i<j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
            i++;j--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        arr = exchange(arr);
        for (int n:
                arr) {
            System.out.print(n + "\t");
        }
    }
}