package 设计模式._03_工厂模式._3_抽象工厂模式.实体类;

import 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口.XiaomiProduct;

/**
 * Description：
 */
public class XiaomiPhone extends XiaomiProduct {
    @Override
    public void printProductClass() {
        System.out.println("手机！");
    }
}
