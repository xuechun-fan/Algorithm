package 面试题积累.拼多多笔试题;


import java.util.Scanner;

/**
 * Description：
 * 给定一个数组A，输出其最长的尖峰子数组长度
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        process(nums);
    }
    private static void process(int[] nums){
        if(nums.length<3){
            System.out.println(0);
            return;
        }
        int n = nums.length;
        int i = 1;
        int cur = 0;
        int max = 0;
        int up = 1, down = 1;
        while(i<n){
            while(i<n && nums[i]==nums[i-1]){
                i++;
            }
            while(i<n && nums[i]>nums[i-1]){
                up++;
                i++;
            }
            while(i<n && nums[i]<nums[i-1]){
                down++;
                i++;
            }
            int t = Math.min(up, down) * 2 - 1;
            cur = t>=3 ? t : 0;
            max = Math.max(max, cur);
            up = 1;
            down = 1;
        }
        System.out.println(max);
    }
}
