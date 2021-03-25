package 剑指Offer习题;

/**
 * Description:
 * 笔记：
 *      含有静态内部类的类加载：
 *      启动JVM时，只会加载外部类的静态代码块，不会加载静态内部类；
 *      new 外部类对象时，会先执行外部类参数初始化代码块，接着执行外部类构造器，此时内部类也不会加载；
 *      在调用包含静态内部类的方法时，会第一次加载静态内部类的代码，如果没有new 内部类，同样只是加载
 *      静态内部类的静态代码块和静态变量，如果静态内部类方法涉及了new 内部类的方法，便会执行静态内部类
 *      的参数初始化代码块和静态内部类的构造器。
 *      无论是静态内部类还是外部类，静态代码块都是只加载一次。
 *
 */
public class 测试类加载 {
    public static Inner inner;
    public 测试类加载() {
        System.out.println("外部类---构造函数");
    }

    {
        System.out.println("外部类---参数初始化块");
    }
    static{
        System.out.println("外部类---静态代码块");

    }

    public static void setInner(){
        System.out.println("----------------");
        System.out.println(new Inner().instance);
        System.out.println("----------------");
    }


    public static class Inner{
        public static 测试类加载 instance = new 测试类加载();
        {
            System.out.println("静态内部类---参数初始化块");
        }
        static{
            System.out.println("静态内部类---静态代码块");
        }

        public Inner() {
            System.out.println("静态内部类---构造函数");
        }
    }

    public static void main(String[] args) {
        System.out.println("***********************");
        new 测试类加载();
        System.out.println("***********************");
        测试类加载.setInner();
        测试类加载.setInner();
    }
}

