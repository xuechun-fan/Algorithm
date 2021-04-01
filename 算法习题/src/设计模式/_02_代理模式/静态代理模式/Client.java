package 设计模式._02_代理模式.静态代理模式;

import 设计模式._02_代理模式.Customer;

/**
 * Description:
 */
public class Client {
    public static void main(String[] args) {
        Customer c = new Customer();
        CustomerProxy proxy = new CustomerProxy(c);
        proxy.buy();
    }
}
