package 设计模式._03_工厂模式._3_抽象工厂模式.RealFactory;

import 设计模式._03_工厂模式._3_抽象工厂模式.AcstractFactory.AbstractFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.AppleTV;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.Mac;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.iPhone;
import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.Product;

/**
 * Description：
 */
public class AppleFactory extends AbstractFactory {
    @Override
    public iPhone createPhone() {
        return new iPhone();
    }

    @Override
    public Mac createComputer() {
        return new Mac();
    }

    @Override
    public AppleTV createTV() {
        return new AppleTV();
    }
}
