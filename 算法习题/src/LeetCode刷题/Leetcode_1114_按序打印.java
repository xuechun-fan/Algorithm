package LeetCode刷题;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Leetcode_1114_按序打印 {

    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(()->{
            while(true){
                try {
                    foo.first();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A--------").start();
        new Thread(()->{
            while(true){
                try {
                    foo.second();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B=============").start();
        new Thread(()->{
            while(true){
                try {
                    foo.third();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C++++++++++++++++++++++++++").start();
    }
}


class Foo {
    static Lock lock;
    static Condition c1;
    static Condition c2;
    static Condition c3;
    static int flag = 0;
    public Foo() {
        lock = new ReentrantLock();
        c1 = lock.newCondition();
        c2 = lock.newCondition();
        c3 = lock.newCondition();
    }

    public void first() throws InterruptedException {
        lock.lock();
        while(flag!=0){
            c2.signal();
            c1.await();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        System.out.println(Thread.currentThread().getName() + "first...");

        flag = (flag+1)%3;
        c2.signal();
        lock.unlock();
    }

    public void second() throws InterruptedException {
        lock.lock();
        while(flag!=1){
            c3.signal();
            c2.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        System.out.println(Thread.currentThread().getName() + "second...");
        flag = (flag+1)%3;
        c3.signal();
        lock.unlock();
    }

    public void third() throws InterruptedException {
        lock.lock();
        while(flag!=2){
            c1.signal();
            c3.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        System.out.println(Thread.currentThread().getName() + "third...");
        flag = (flag+1)%3;
        c1.signal();
        lock.unlock();
    }
}