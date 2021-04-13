package 面试题积累.多线程相关;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description：
 */
public class P01_两个线程交替打印两个数组元素 {
    public static void main(String[] args) throws InterruptedException {
        char[] digit = "1234567890".toCharArray();
        char[] letter = "ABCDEFGHI".toCharArray();
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (char c : digit) {
                        System.out.println("t1线程打印——————》" + c);
                        c2.signal();
                        c1.await();
                    }
//                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try{
                    for (char c : letter) {
                        System.out.println("t2线程打印======>" + c);
                        c1.signal();
                        c2.await();
                    }
//                    c1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
//        Thread.sleep(500);
        t2.start();

    }
}
