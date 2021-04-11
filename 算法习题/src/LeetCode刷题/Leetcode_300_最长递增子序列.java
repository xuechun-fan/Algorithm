package LeetCode刷题;
/**
 * Description:
 */
public class Leetcode_300_最长递增子序列 {
    public static int lengthOfLIS(int[] nums){
        //  好吧，我承认，之前对这类题一直有恐惧感，最长上升子序列和最长公共子序列问题
        //  但是今天，不看之前的代码，重新根据理解自己写一遍，试试把
        if(nums==null || nums.length==0) return 0;
        int[] res = new int[nums.length];
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            //  找到nums[i]在res数组中应该存放的位置
            int l = 0, r = idx;
            while(l<r){
                int m = (l+r)>>1;
                if(res[m]<nums[i]){
                    l = m+1;
                }else{
                    r = m;
                }
            }
            res[l] = nums[i];
            if(l==idx) idx++;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        int res = lengthOfLIS(arr);
        System.out.println(res);
    }
}
