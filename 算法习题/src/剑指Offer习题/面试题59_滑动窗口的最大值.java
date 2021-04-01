package 剑指Offer习题;

import java.util.Deque;
import java.util.LinkedList;

public class 面试题59_滑动窗口的最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null || nums.length==0) return new int[0];
        int[] res = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //  先检查窗口大小
            if(!q.isEmpty() && i-q.peekFirst()>=k){
                q.pollFirst();
            }
            //  保证队列单调非增顺序，且队首始终为窗口内最大值的索引
            while(!q.isEmpty() && nums[i] > nums[q.peekLast()]){
                q.pollLast();
            }
            //  将当前索引添加到队列中
            q.add(i);
            //  判断是否满足窗口大小，并输出到res中保存结果
            if(i-k+1>=0){
                res[i-k+1] = nums[q.peekFirst()];
            }
        }
        return res;
    }
}
