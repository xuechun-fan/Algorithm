import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Description：实现队列的两个函数：
 *          1、public void appendTail(T element)
 *          2、public <T> T deleteHead()
 */
public class 面试题9_用两个栈实现队列 {

    public static void testCQueue(){
        CQueue<Integer> queue = new CQueue<>();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.appendTail(4);
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(6);
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.deleteHead());
        }
        queue.deleteHead();     //  测试异常
    }

    public static void testCStack(){
        CStack<Integer> stack = new CStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.pop());
        stack.add(4);
        while(stack.size()!=0){
            System.out.println(stack.pop());
        }
        stack.pop();

    }

    public static void main(String[] args) {
        testCStack();
    }
}

//  两个栈实现一个队列
class CQueue<T>{
    private Stack<T> s1;
    private Stack<T> s2;

    public CQueue() {
        this.s1 = new Stack<T>();
        this.s2 = new Stack<T>();
    }

    public void appendTail(T element){
        s1.add(element);
    }

    public T deleteHead(){
        if(s1.size()==0 && s2.size()==0){
            throw new RuntimeException("队列中没有元素可以删除！");
        }
        if(s2.size()==0){
            while(s1.size()!=0){
                s2.add(s1.pop());
            }
        }
        return s2.pop();
    }
}

class CStack<T>{
    private Queue<T> q1;
    private Queue<T> q2;
    private int size = 0;

    public CStack() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }

    public int size() {
        return size;
    }

    public void add(T element){
        if(q1.size()==0 && q2.size()==0){
            q1.add(element);
        }else if(q1.size()==0){
            q2.add(element);
        }else{
            q1.add(element);
        }
        size++;
    }

    public T pop(){
        if(q1.size()==0 && q2.size()==0){
            throw new RuntimeException("栈中没有元素可以删除：");
        }
        size--;
        if(q1.size()==0){
            while(q2.size()!=1){
                q1.add(q2.remove());
            }
            return q2.remove();
        }
        while(q1.size()!=1){
            q2.add(q1.remove());
        }
        return q1.remove();
    }

}