package LeetCode刷题;

/**
 * Description：
 */
public class Leetcode_081_搜索旋转排序数组 {
    public static boolean search(int[] nums, int target) {
        // 思路是二分查找，该数组的特点是前后两部分分别都是有序的
        int start = 0, end = nums.length-1;
        while(start<=end){
            int m = (start+end) >> 1;
            if(nums[m]==target) return true;
            if(nums[start]==nums[m]){
                start++;	//排除前面相等的元素，为后续找到两个有序子数组做准备
                continue;
            }
            if(nums[start]<nums[m]){//前半部分有序
                if(nums[start]<=target && nums[m]>target){
                    //说明在前半部分
                    end = m-1;
                }else{
                    start = m+1;
                }
            }else{//后半部分有序
                if(nums[m]<target && nums[end]>=target){
                    start = m+1;
                }else{
                    end = m-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        boolean res = search(nums, 2);
        System.out.println(res);
    }
}
