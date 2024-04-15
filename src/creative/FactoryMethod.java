package creative;

/**
 * @author: liuzt
 * @date: 2024/4/15 - 04 - 15 - 20:05
 * @description: creative
 * @version: 1.0
 */
public class FactoryMethod {
    public static void main(String[] args) {
        FMFactory fa = new FactoryA();
        FMProduct product = fa.createProduct();
        product.info();

        FMFactory fb = new FactroyB();
        FMProduct product1 = fb.createProduct();
        product1.info();
/**
 *
 * 现在是将产品、工厂都定义为了接口的形式，如果要输出新的，那就在工厂、产品中都添加新的，这样就不违反开闭原则了。
 * 对扩展开放，对修改关闭。
 */
        FactroyC factroyC = new FactroyC();
        FMProduct product2 = factroyC.createProduct();
        product2.info();


    }
}


interface FMProduct{
    public void info();
}

class FMProductA implements FMProduct{

    @Override
    public void info() {
        System.out.println("产品A");
    }
}

class FMProductB implements FMProduct{

    @Override
    public void info() {
        System.out.println("产品B");
    }
}

class FMProductC implements FMProduct{

    @Override
    public void info() {
        System.out.println("产品C");
    }
}

interface FMFactory{
    public FMProduct createProduct();
}
class FactoryA implements FMFactory{

    @Override
    public FMProduct createProduct() {
        return new FMProductA();
    }
}
class FactroyB implements FMFactory{

    @Override
    public FMProduct createProduct() {
        return new FMProductB();
    }
}


class FactroyC implements FMFactory{

    @Override
    public FMProduct createProduct() {
        return new FMProductC();
    }
}