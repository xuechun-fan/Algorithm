package 面试题积累.便利蜂笔试题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Description：
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        int[] nums = new int[strs.length];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        int k = Integer.parseInt(sc.nextLine());
        int[] res = process(nums, k);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int num : res){
            sb.append(String.valueOf(num));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println(sb.toString());
//        System.out.println();
//        System.out.println(k);
    }

    public static int[] process(int[] nums, int k){
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()]){
                q.pollLast();
            }
            q.offer(i);
            //  检查区间
            if(i-q.peekFirst()==k){
                q.pollFirst();
            }
            //  更新结果集
            if(i>=k-1){
                res[idx++] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
