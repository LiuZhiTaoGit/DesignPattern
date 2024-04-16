package structural;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 11:34
 * @description: structural   桥接模式
 * @version: 1.0
 */
public class BridgeMain {
    public static void main(String[] args) {
        Car xiaomi = new Xiaomi();
        Color red = new Red();
        xiaomi.setName("小米");
        xiaomi.setColor(red);
        xiaomi.Operation();
    }
}


abstract class Car{
    private String name;
    protected Color color;

    public Car() {
    }

    public Car(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void Operation();
}

class Xiaomi extends Car{

    @Override
    public void Operation() {
        color.OperationImp(this.getName());
    }
}


interface Color{
    public void OperationImp(String name);
}

class Red implements Color{

    @Override
    public void OperationImp(String name) {
        System.out.println(name + "red");
    }
}

class Bule implements Color{

    @Override
    public void OperationImp(String name) {
        System.out.println(name + "blue");
    }
}