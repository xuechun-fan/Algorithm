package 设计模式._03_工厂模式._3_抽象工厂模式.抽象接口;

/**
 * Description：
 */
public abstract class AppleProduct implements Product{
    @Override
    public void printBrand() {
        System.out.println("我是苹果生产的：");
    }
    public abstract void printInfo();
}
