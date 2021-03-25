package 剑指Offer习题;

/**
 * Description:
 */
public class 面试题2_实现单例模式 {
    public static void main(String[] args) {
        Test t = Test.getInstance();
        System.out.println(t.age);
        t.age = 10;
        System.out.println(t.age);
        t = Test.getInstance();
        System.out.println(t.age);
    }
}


//  饿汉式
class Singleton{
    private static Singleton singleton = new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton!=null){
            return singleton;
        }else{
            return new Singleton();
        }
    }
}

//  懒汉式
class Singleton2{
    //  双重检测锁方法DCL, 在singleton2实例对象上架volatile关键字是为了避免JVM内部指令重排序优化造成的乱序执行的原因
    /*
    *   INSTANCE  = new SingleTon();
        这个步骤，其实在jvm里面的执行分为三步：
        1.在堆内存开辟内存空间。
        2.在堆内存中实例化SingleTon里面的各个参数。
        3.把对象指向堆内存空间
        JVM可能会按132顺序执行，这样，如果线程1先进入执行1、3还没有执行2，而线程2进来判断instance已经
        不是null，便会直接取走instance，它取走的instance其实还没有初始化参数，所以会出现问题。加
        volatile关键字可以保证JVM内部按顺序执行，避免此问题。
    * */
    private volatile static Singleton2 singleton2 = null;
    private Singleton2() {
    }
    public static Singleton2 getInstance(){
        if(singleton2==null){
            synchronized (Singleton2.class){
                if(singleton2==null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}

//  静态内部类实现单例
class Singleton3{
    private static class InnerClass{
        private static Singleton3 instance = new Singleton3();
    }
    private Singleton3(){}
    public static Singleton3 getInstance(){
        return InnerClass.instance;
    }
}


class Test{
    public int age = 18;
    private static final Test instance = new Test();
    private Test(){}
    public static Test getInstance(){
        return instance;
    }
}