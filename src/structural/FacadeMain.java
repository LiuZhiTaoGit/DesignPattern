package structural;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 15:10
 * @description: structural   外观系统
 * @version: 1.0
 */
public class FacadeMain {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.methodB();
        facade.methodA();
    }
}

class Facade{
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    public Facade(){
        subSystemOne = new SubSystemOne();
        subSystemTwo = new SubSystemTwo();
    }

    public void methodA(){
        subSystemOne.method1();
    }
    public void methodB(){
        subSystemTwo.method1();
    }
}


class SubSystemOne{
    public void method1(){
        System.out.println("子系统1");
    }
}
class SubSystemTwo{
    public void method1(){
        System.out.println("子系统2");
    }
}

