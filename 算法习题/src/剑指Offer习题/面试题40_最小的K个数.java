package 剑指Offer习题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Description：
 */
public class 面试题40_最小的K个数 {
    public static int[] getLeastNumbers(int[] arr, int k) {
        //  最小的K个数的话，有两种方式吧
        //  思路1：常规建立最大堆，保证其容量不超过K
//        PriorityQueue<Integer> q = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
//        int[] res = new int[k];
//        for(int num : arr){
//            q.offer(num);
//            if(q.size()>k) q.poll();
//        }
//        for(int i=0; i<k; i++){
//            res[i] = q.poll();
//        }
//        return res;

        //  思路2：快排思想
        if(k==0) return new int[0];
        int[] res = new int[k];
        int l = 0, r = arr.length-1;
        int idx;
        while(true){
            idx = quickSort(arr, l, r);
            if(idx==k-1){
                break;
            }else if(idx>k-1){
                r = idx-1;
            }else{
                l = idx+1;
            }
        }
        for(int i=0; i<k; i++){
            res[i] = arr[i];
        }
        return res;
    }
    private static int quickSort(int[] nums, int l, int r){
        int base = nums[l];
        int i = l, j = r;
        while(i<j){
            while(i<j && nums[j]>=base) {
                j--;
            }
            while(i<j && nums[i]<=base) {
                i++;
            }
            if(i<j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[l] = nums[j];
        nums[j] = base;
        return j;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,2,0,5};
        int[] leastNumbers = getLeastNumbers(arr, 5);
        for(int num:leastNumbers){
            System.out.print(num + "\t");
        }
    }
}
