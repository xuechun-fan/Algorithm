package 设计模式._03_工厂模式._3_抽象工厂模式.实体类;

import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.AppleProduct;

/**
 * Description：
 */
public class AppleTV extends AppleProduct {
    @Override
    public void printProductClass() {
        System.out.println("Apple 电视机");
    }

    @Override
    public void printInfo() {
        this.printBrand();
        this.printProductClass();
    }
}
