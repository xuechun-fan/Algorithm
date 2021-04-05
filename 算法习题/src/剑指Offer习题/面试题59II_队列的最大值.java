package 剑指Offer习题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description：
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的
 * 均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value需要返回 -1
 */
class MaxQueue {
    //  一个普通队列
    private Queue<Integer> q;
    //  一个单调栈，用来实现最大值的功能
    private Deque<Integer> max;
    public MaxQueue() {
        q = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        return max.isEmpty() ? -1 : max.peekFirst();
    }

    public void push_back(int value) {
        //  q的正常入队
        q.offer(value);
        while(!max.isEmpty() && value>max.peekLast()){
            max.pollLast();
        }
        max.offerLast(value);
    }

    public int pop_front() {
        if(q.isEmpty()) return -1;
        int res = q.poll();
        if(res==max.peekFirst()) max.pollFirst();
        return res;
    }
}


public class 面试题59II_队列的最大值 {

}
