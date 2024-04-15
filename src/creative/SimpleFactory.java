package creative;

/**
 * @author: liuzt
 * @date: 2024/4/15 - 04 - 15 - 17:14
 * @description: creative 简单工厂模式
 * @version: 1.0
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product a = Factory.createProduct("A");
        a.info();

        Product b = Factory.createProduct("B");
        b.info();
    }
}



/**
 * 1创建抽象类的方法
 */
abstract class Product{
    public abstract void info();
}

/**
 * 实现类A
 */
class ProductA extends Product{

    @Override
    public void info() {
        System.out.println("实现产品A");
    }
}

/**
 * 实现类B
 */
class ProductB extends Product{

    @Override
    public void info() {
        System.out.println("实现产品B");
    }
}

/**
 * TODO: 如果要添加一个新的产品C，需要在工厂类中进行修改
 */
class ProductC extends Product{

    @Override
    public void info() {
        System.out.println("实现C");
    }
}

/**
 * 核心工厂类
 */
class Factory{
    public static Product createProduct(String type){
        Product product = null;

        switch (type){
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
//                TODO: 问题：   在这里进行修改，这违背了一个原则：  开放封闭原则， 对扩展开放，可以，但是修改了方法，这就不行。
            //  TODO : 解决方法：引申到工厂方法模式
            case "C":
                product = new ProductC();
                break;
            default:
                System.out.println("没有该类型");
                break;
        }
        return product;
    }
}
