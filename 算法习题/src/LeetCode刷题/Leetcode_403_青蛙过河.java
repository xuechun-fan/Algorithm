package LeetCode刷题;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_403_青蛙过河 {
    private int[] nums;
    private Set<String> dic = new HashSet<>();
    public boolean canCross(int[] stones) {
        if(stones==null || stones.length==0) return true;
        this.nums = stones;
        return recur(0, 0);
    }

    private boolean recur(int idx,int last){
        String tmp = new StringBuilder(String.valueOf(idx)).append(String.valueOf(last)).toString();
        if(dic.contains(tmp)){
            return false;
        }
        dic.add(tmp);
        for(int i=idx+1; i<nums.length; i++){
            int gap = nums[i] - nums[idx];
            if(gap<=last+1 && gap>=last-1){
                if(recur(i, gap)){
                    return true;
                }
            }else if(gap>last+1){
                break;
            }else{
                continue;
            }
        }
        return idx==nums.length;
    }

    @Test
    public void test(){
        boolean cross = canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11});
        System.out.println(cross);
    }
}