package 设计模式._02_代理模式.jdk动态代理模式;

import 设计模式._02_代理模式.BuyCar;
import 设计模式._02_代理模式.Couple;
import 设计模式._02_代理模式.Customer;
import 设计模式._02_代理模式.Marry;

import java.lang.reflect.Proxy;

/**
 * Description:
 */
public class Client {
    public static void main(String[] args) {
        //  jdk动态代理测试
        Customer c = new Customer();
        BuyCar proxy = (BuyCar) Proxy.newProxyInstance(BuyCar.class.getClassLoader(),
                new Class[]{BuyCar.class}, new ProxyHandler(c));
        proxy.buy();

        System.out.println("*************************************");
        Couple couple = new Couple();
        Marry marryProxy = (Marry) Proxy.newProxyInstance(Marry.class.getClassLoader(),
                new Class[]{Marry.class}, new ProxyHandler(couple));
        marryProxy.marry();

    }
}
