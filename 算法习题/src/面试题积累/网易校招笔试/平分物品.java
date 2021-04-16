package 面试题积累.网易校招笔试;

import java.util.Scanner;

/**
 * Description：
 */
public class 平分物品 {
    private static int sum;
    private static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            int[] nums = new int[n];
            sum = 0;
            min = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            process(nums);
            System.out.println(min);
        }
    }

    private static void process(int[] nums){
        if(nums==null || nums.length==0) return;
        dfs(nums, 0, 0, 0);
    }

    private static void dfs(int[] nums, int a, int b, int idx){
        if(a==b){
            min = Math.min(min, sum-a-b);
        }
        if(idx==nums.length || a>sum/2 || b>sum/2) return;
        dfs(nums, a+nums[idx], b, idx+1);
        dfs(nums, a, b+nums[idx], idx+1);
        dfs(nums, a, b, idx+1);
    }
}
