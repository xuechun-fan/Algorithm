package LeetCode刷题;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_403_青蛙过河 {
    private int[] nums;
    private Set<String> dic = new HashSet<>();
    public boolean canCross(int[] stones) {
        this.nums = stones;
        if(nums==null || nums.length==0) return true;
        return dfs(0, 0);
    }

    private boolean dfs(int cur, int last){
        String tmp = String.valueOf(cur)+String.valueOf(last);
        if(dic.contains(tmp)){
            return false;
        }else{
            dic.add(tmp);
        }
        for(int i=cur+1; i<nums.length; i++){
            int gap = nums[i] - nums[cur];
            if(gap<=last+1 && gap>=last-1){
                if(dfs(i, gap)) return true;
            }else if(gap>last+1){
                break;
            }else{
                continue;
            }
        }
        return cur==nums.length-1;
    }

    @Test
    public void test(){
        int[] nums = new int[]{0,1,3,5,6,8,12,17};
        boolean b = canCross(nums);
        System.out.println(b);
    }
}
