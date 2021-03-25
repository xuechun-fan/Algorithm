package LeetCode刷题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class Solution_015 {
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<3){
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
//        quickSort(nums, 0, nums.length-1);
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                return res;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i + 1, right = n - 1;
            while(left<right){
                List<Integer> ans = new ArrayList<>();
                if(nums[i] + nums[left] + nums[right] == 0){
                    ans.add(nums[left]);
                    ans.add(nums[i]);
                    ans.add(nums[right]);
                    res.add(ans);
                    while(left<right && nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    private static void quickSort(int[] nums, int left, int right){
        if(left>=right){
            return;
        }
        int start = left, end = right;
        int base = nums[start];
        while (left<right){
            while(right>start && nums[right]>=base){
                right--;
            }
            while(left<end && nums[left]<=base){
                left++;
            }
            if(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[start] = nums[right];
        nums[right] = base;
        quickSort(nums, start, right-1 );
        quickSort(nums, right+1, end );
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr1 = {0,0,0};
        List<List<Integer>> lists = threeSum(arr1);
        for(List list:lists){
            for(Object n:list){
                System.out.print(n + "\t");
            }
            System.out.println();
        }
    }
}
