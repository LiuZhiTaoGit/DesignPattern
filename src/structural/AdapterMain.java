package structural;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 11:14
 * @description: structural   适配器模式
 * @version: 1.0
 */
public class AdapterMain {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
    }
}


class Target{
    public void Request(){
        System.out.println("这个是目标接口-usb");
    }
}

/**
 * 创建一个适配器，转换中间接口和目标接口
 */
class Adapter extends Target{
    private Adaptee adaptee = new Adaptee();
    @Override
    public void Request(){
        System.out.println("重写的方法，");
        adaptee.SpecificRequest();
    }
}
class Adaptee{
    public void SpecificRequest(){
        System.out.println("这个是之前的接口-typec");
    }
}