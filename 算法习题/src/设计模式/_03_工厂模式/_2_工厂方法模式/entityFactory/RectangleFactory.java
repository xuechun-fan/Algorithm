package 设计模式._03_工厂模式._2_工厂方法模式.entityFactory;

import 设计模式._03_工厂模式.abstractInterface.Shape;
import 设计模式._03_工厂模式.entities.Rectangle;
import 设计模式._03_工厂模式._2_工厂方法模式.abstractFactory.AbstractFactory;

/**
 * Description：
 */
public class RectangleFactory extends AbstractFactory {
    @Override
    public Shape getShape() {
        return new Rectangle();
    }
}
