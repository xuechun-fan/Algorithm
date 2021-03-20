/**
 * Description:
 */
public class 面试题3_数组中重复的数字 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 2, 3};
        int res = CH02_3_1.test02(nums);
        System.out.println(res);
    }
}

class CH02_3_1{
    /**
     * nums数组中为0~nums.length-1之间的数，找出重复的数。不使用额外空间，时间复杂度O(n)
     * @param nums
     * @param length
     * @return
     */

    //  书上答案
    public static int duplicate(int[] nums, int length){
        if(nums==null || nums.length==0){
            return -1;
        }
        for(int i=0; i<length; i++){
            if(nums[i]<0 || nums[i]>length-1){
                return -1;
            }
        }
        for(int i=0; i<length; i++){
            while(nums[i] != i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        return -1;
    }

    //  自己理解的答案
    public static int test(int[] arr){
        int n = arr.length;
        if(arr==null || n==0){
            return -1;
        }
        int m;
        for(int i=0; i<n; i++){
            if(arr[i]<0 || arr[i]>=n){
                return -1;
            }
            if(arr[i]!=i){
                m = arr[i];
                if(arr[m]==m){
                    return m;
                }
                arr[i] = arr[m];
                arr[m] = m;
            }
        }
        return -1;
    }

    //  上述方法都修改了原数组，现在要求不可以修改原数组，且不借助额外O(n)空间
    public static int test02(int[] arr){
        int n = arr.length;
        if(arr==null || n==0){
            return -1;
        }
        int start = 0, end = n-1;
        while(start<=end){
            int mid = ((end-start)>>1) + start;
            int count = countRange(arr, n, start, mid);
            if(start==end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if(count>mid-start+1){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static int countRange(int[] arr, int length, int start, int end){
        if(arr==null || length==0){
            return 0;
        }
        int count = 0;
        for(int i=0; i<length; i++){
            if(arr[i]<=end && arr[i]>=start){
                count++;
            }
        }
        return count;
    }
}
