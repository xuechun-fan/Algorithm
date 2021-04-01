package 设计模式._02_代理模式;

/**
 * Description:
 */
public class Customer implements BuyCar{
    @Override
    public void buy() {
        System.out.println("顾客来到4s店，找到代理商。。。");
    }
}
