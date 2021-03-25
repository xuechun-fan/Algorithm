package 设计模式._03_工厂模式._3_抽象工厂模式.RealFactory;

import 设计模式._03_工厂模式._3_抽象工厂模式.AcstractFactory.AbstractFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.LenovoComputer;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.LenovoPhone;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.LenovoTV;
import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.Product;

/**
 * Description：
 */
public class LenovoFactory extends AbstractFactory {
    @Override
    public Product createPhone() {
        return new LenovoPhone();
    }

    @Override
    public Product createComputer() {
        return new LenovoComputer();
    }

    @Override
    public Product createTV() {
        return new LenovoTV();
    }
}
