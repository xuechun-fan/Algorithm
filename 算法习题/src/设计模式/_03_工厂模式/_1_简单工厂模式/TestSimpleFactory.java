package 设计模式._03_工厂模式._1_简单工厂模式;

import 设计模式._03_工厂模式.abstractInterface.Shape;

/**
 * Description：
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        Shape shape = SimpleFactory.getShape("Square");
        shape.draw();
    }
}
