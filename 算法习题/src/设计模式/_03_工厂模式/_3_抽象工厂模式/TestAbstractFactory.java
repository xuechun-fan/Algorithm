package 设计模式._03_工厂模式._3_抽象工厂模式;


import 设计模式._03_工厂模式._3_抽象工厂模式.AcstractFactory.AbstractFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.RealFactory.AppleFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.RealFactory.LenovoFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.RealFactory.XiaomiFactory;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.AppleTV;
import 设计模式._03_工厂模式._3_抽象工厂模式.实体类.iPhone;
import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.AppleProduct;
import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.Product;

/**
 * Description：
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        //  比如当前要创建一个联想电脑和小米手机
        AbstractFactory factory = null;

        //  生产联想电脑
        factory = new LenovoFactory();
        Product computer = factory.createComputer();
        computer.printBrand();
        computer.printProductClass();
        System.out.println("----------------------------");
        //  生产小米手机
        factory = new XiaomiFactory();
        Product phone = factory.createPhone();
        phone.printBrand();
        phone.printProductClass();
        System.out.println("----------------------------");
        //  生产Apple全系列产品
        factory = new AppleFactory();
        AppleProduct product = (AppleProduct) factory.createPhone();
        product.printInfo();
        product = (AppleProduct) factory.createComputer();
        product.printInfo();
        product = (AppleProduct) factory.createTV();
        product.printInfo();
        System.out.println("----------------------------");
    }
}
