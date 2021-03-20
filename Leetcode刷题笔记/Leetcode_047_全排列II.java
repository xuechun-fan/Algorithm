package LeetCode刷题;

import java.util.*;

public class Leetcode_047_全排列II {
    /**
     * 给定一个可包含重复数字的序列 nums ，
     * 按任意顺序 返回所有不重复的全排列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *
     */
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> line = new ArrayList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums==null || nums.length==0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, visited);
        return res;
    }
    private static void dfs(int[] nums, boolean[] visited){
        if(nums.length==line.size()){
            res.add(new ArrayList<Integer>(line));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i] || (i>0 && nums[i]==nums[i-1] && !visited[i-1])) continue;
            visited[i] = true;
            line.add(nums[i]);
            dfs(nums, visited);
            visited[i] = false;
            line.remove(line.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 0, 3};
        List<List<Integer>> lists = permuteUnique(nums);
        for(List list : lists){
            System.out.print(list);
        }
    }
}
