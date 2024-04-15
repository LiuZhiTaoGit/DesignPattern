package creative;

/**
 * @author: liuzt
 * @date: 2024/4/15 - 04 - 15 - 20:05
 * @description: creative    提供一个创建一系列相关或相互依赖对象的接口，而无需指定他们具体的类。  就是说一个能搞好几个
 * @version: 1.0
 */
public class AbstractFactory {
    public static void main(String[] args) {
        new AFFactory1().createProductA().info();

        new AFFactory1().createProductB().info();

        new AFFactroy2().createProductA().info();

        new AFFactroy2().createProductB().info();


    }
}


interface AFProductA{
    public void info();
}

class AFProductA1 implements AFProductA{


    @Override
    public void info() {
        System.out.println("AFPA1");
    }
}

class AFProductA2 implements AFProductA{

    @Override
    public void info() {
        System.out.println("AFPA2");
    }
}


interface AFProductB{
    public void info();
}

class AFProductB1 implements AFProductB{


    @Override
    public void info() {
        System.out.println("AFPB1");
    }
}

class AFProductB2 implements AFProductB{

    @Override
    public void info() {
        System.out.println("AFPB2");
    }
}




interface AFFactory{
    public AFProductA createProductA();
    public AFProductB createProductB();
}

class AFFactory1 implements AFFactory{


    @Override
    public AFProductA createProductA() {
        return new AFProductA1();
    }

    @Override
    public AFProductB createProductB() {
        return new AFProductB1();
    }
}

class AFFactroy2 implements AFFactory{


    @Override
    public AFProductA createProductA() {
        return new AFProductA2();
    }

    @Override
    public AFProductB createProductB() {
        return new AFProductB2();
    }
}
