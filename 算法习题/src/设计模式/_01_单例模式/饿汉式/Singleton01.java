package 设计模式._01_单例模式.饿汉式;

/**
 * Description：饿汉式
 */
public class Singleton01 {
    private static Singleton01 instance = new Singleton01();
    private Singleton01(){}
    public static Singleton01 getInstance(){
        return instance;
    }
}
