package 剑指Offer习题;

import java.util.PriorityQueue;

/**
 * Description：
 */

class MedianFinder {
    //  需要创建两个堆，一个大顶堆，一个小顶堆
    //  大顶堆用来存放较小的那部分数据
    //  小顶堆用来存放较大的那部分数据
    //  控制每次新加数据都首选加到小顶堆中，这样两堆数据个数只有两种情况，一种相等，另外一种是小顶堆数据个数比大顶堆数据个数大1
    /**
     * case1：两堆数据个数相等，此时中位数是两堆顶元素的平均值
     * case2：两堆数据个数差一，此时中位数是小顶堆的堆顶元素
     */
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.min = new PriorityQueue<>();
        this.max = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
    }

    public void addNum(int num) {
        //  首选放入小顶堆
        if(min.size()==max.size()){
            min.offer(num);
            max.offer(min.poll());
        }else{
            max.offer(num);
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if(max.size()==0) return -1.0;
        return (min.size()==max.size()) ? (min.peek()+max.peek())/2.0 : max.peek();
    }
}

public class 面试题41_数据流中的中位数 {

}