package LeetCode刷题;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Description：
 */
public class 前K个高频元素 {
    public static void main(String[] args) {
//        [4,1,-1,2,-1,2,3]
//        2

        int[] nums = new int[]{4,1,-1,2,-1,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, k);
        System.out.println();
    }


    public static int[] topKFrequent(int[] nums, int k) {
        if(k<1 || nums==null || nums.length==0) return new int[0];
        Map<Integer, Integer> dic = new HashMap<>();    //  Map， key为数值，value为出现次数
        int[] res = new int[k];
        for(int num:nums){
            if(!dic.containsKey(num)){
                dic.put(num, 1);
            }else{
                dic.put(num, dic.get(num)+1);
            }
        }
        //  建立最小堆，最小堆存放的是Map的Entry键值对，按照value即该num出现的次数升序排列
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        for(Map.Entry<Integer, Integer> entry : dic.entrySet()){
            if(minHeap.size()<k){
                minHeap.offer(entry);
            }else{
                if(minHeap.peek().getValue()<entry.getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        while(!minHeap.isEmpty()){
            res[--k] = minHeap.poll().getKey();
        }
        return res;
    }
}
