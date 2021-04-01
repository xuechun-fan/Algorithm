package 设计模式._03_工厂模式._3_抽象工厂模式.AcstractFactory;

import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.Product;

/**
 * Description：抽象工厂
 * 每个工厂都可以生产该族内的手机、电视、电脑
 */
public abstract class AbstractFactory {
    public abstract Product createPhone();
    public abstract Product createComputer();
    public abstract Product createTV();
}
