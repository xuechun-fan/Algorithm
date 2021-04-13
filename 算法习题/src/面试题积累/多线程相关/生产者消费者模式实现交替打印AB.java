package 面试题积累.多线程相关;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description：
 */


public class 生产者消费者模式实现交替打印AB {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        A ta = new A(service);
        ta.start();
        Thread.sleep(100);
        B tb = new B(service);
        tb.start();
    }
}


class MyService{
    private ReentrantLock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private boolean isA = false;

    public void printA(){
        lock.lock();
        try{
            while (isA==false){
                a.await();
            }
            System.out.println("A");
            isA = false;
            a.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try{
            while (isA==true){
                a.await();
            }
            System.out.println("B");
            isA = true;
            a.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
class A extends Thread{
    private MyService service;

    public A(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.printA();
        }
    }
}

class B extends Thread{
    private MyService service;

    public B(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.printB();
        }
    }
}