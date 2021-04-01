package 设计模式._02_代理模式.静态代理模式;

import 设计模式._02_代理模式.BuyCar;
import 设计模式._02_代理模式.Customer;

/**
 * Description:
 */
public class CustomerProxy implements BuyCar {
    Customer c;

    public CustomerProxy(Customer c) {
        this.c = c;
    }

    @Override
    public void buy() {
        //  前置扩展
        System.out.println("代理办理相关手续，，，");
        //  实际调用被代理类的业务方法
        c.buy();
        //  后置扩展
        System.out.println("代理办完手续，交付车主。。。");
    }
}
