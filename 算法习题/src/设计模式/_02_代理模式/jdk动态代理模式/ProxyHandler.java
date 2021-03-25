package 设计模式._02_代理模式.jdk动态代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
*   Description:   
*/
public class ProxyHandler implements InvocationHandler {
    Object proxied = null;

    public ProxyHandler(Object obj) {
        this.proxied = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //  前置扩展处理
        System.out.println("前置扩展。。。");
        //  这里就是转调被代理类的方法
        Object obj = method.invoke(proxied, null);
        //  后置扩展
        System.out.println("后置扩展。。。");
        return obj;
    }
}
