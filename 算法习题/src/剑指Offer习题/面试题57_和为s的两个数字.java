package 剑指Offer习题;

import java.util.*;

public class 面试题57_和为s的两个数字 {
    /**
     *输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，则输出任意一对即可。
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *
     */

    //  方法1：
    //  因为数组是排序的，可利用双指针方法
    public int[] twoSum(int[] nums, int target){
        if(nums==null || nums.length==0) return new int[0];
        int l = 0, r = nums.length-1;
        int[] res = new int[2];
        while(l<r){
            if(nums[l]+nums[r]==target){
                res[0] = nums[l];
                res[1] = nums[r];
                break;
            }
            while(l<r && (target>nums[r] || nums[l]+nums[r]>target))
                r--;
            while(l<r && (target>nums[r] || nums[l]+nums[r]<target))
                l++;
        }
        return res;
    }

    public int[] twoSum2(int[] nums, int target){
        if(nums==null || nums.length==0) return new int[0];
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                res[0] = target - num;
                res[1] = num;
                break;
            }
            set.add(num);
        }
        return res;
    }

    // 牛客网版
    public static int[] twoSum3 (int[] nums, int target) {
        // write code here
        if(nums==null || nums.length==0) return new int[0];
        int[] res = new int[2];
        //    Key: 数值  value：索引下标
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
            if(map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]) + 1;
                res[1] = map.get(nums[i]) + 1;
                break;
            }
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int[] ints = twoSum3(nums, 6);
        List<Integer> list = new ArrayList<>();

        System.out.println((int)'0');
        System.out.println((int)'1');
        System.out.println((int)'9');
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
    }
}
