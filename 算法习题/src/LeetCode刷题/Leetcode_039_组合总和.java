package LeetCode刷题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_039_组合总和 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len==0) return res;
        Deque<Integer> path = new LinkedList<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res){
        if(target<0) {  //  为负数时，不再产生新的子节点
            return;
        }
        if(target==0){
            //  当前path是一种结果
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=begin; i<len; i++){
            path.addLast(candidates[i]);
            dfs(candidates, i, len, target-candidates[i], path, res);
            //  状态重置， 即回溯
            path.removeLast();
        }


    }


    @Test
    public void test(){
        int[] nums = new int[]{2, 3, 6, 7};
        int tar = 7;
        List<List<Integer>> lists = new Leetcode_039_组合总和().combinationSum(nums, tar);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }
}