package 设计模式._03_工厂模式._1_简单工厂模式;

import 设计模式._03_工厂模式.abstractInterface.Shape;
import 设计模式._03_工厂模式.entities.Circle;
import 设计模式._03_工厂模式.entities.Rectangle;
import 设计模式._03_工厂模式.entities.Square;

/**
 * Description：
 */
public class SimpleFactory {
    public static Shape getShape(String s){
        if("Circle".equals(s)){
            return new Circle();
        }else if("Rectangle".equals(s)){
            return new Rectangle();
        }else{
            return new Square();
        }
    }
}
