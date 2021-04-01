package 设计模式._03_工厂模式._3_抽象工厂模式.RealFactory;

import 设计模式._03_工厂模式._3_抽象工厂模式.AcstractFactory.AbstractFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.XiaomiComputer;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.XiaomiPhone;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.XiaomiTV;
import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.Product;

/**
 * Description：
 */
public class XiaomiFactory extends AbstractFactory {
    @Override
    public Product createPhone() {
        return new XiaomiPhone();
    }

    @Override
    public Product createComputer() {
        return new XiaomiComputer();
    }

    @Override
    public Product createTV() {
        return new XiaomiTV();
    }
}
