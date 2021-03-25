package 牛客刷题.Shopee企业面试题;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class Shopee企业面试题{
    private static void find(int[] nums, int start, int end, List<Integer> res){
        if(start>end) return;
        if(start==end){
            res.add(nums[start]);
            return;
        }
        int root = nums[start];
        int edge;
        for(edge=start+1; edge<=end; edge++){
            if(nums[edge]>root) break;
        }
        find(nums, start+1, edge-1, res);
        find(nums, edge, end, res);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length];
        for(int i=0; i<nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        List<Integer> res = new ArrayList<>();
        find(nums, 0, nums.length-1, res);
        for(Integer n : res){
            System.out.print(n);
            System.out.print(" ");
        }
    }
}