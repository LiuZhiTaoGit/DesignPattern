package structural;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 14:22
 * @description: structural  装饰器模式
 * @version: 1.0
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Person student = new Student("张三");
        student.Operation();
        System.out.println("-----------");
        student = new DecoratorA(student);
        student.Operation();

    }
}


abstract class Person{
    protected String name;

    public abstract void Operation();//职责
}


class Student extends Person{

    public Student(String name){
        this.name = name;
    }

    @Override
    public void Operation() {
        System.out.println(name + "的职责是：学习");
    }
}


abstract class Decorator extends Person{
    protected Person person;
}

class DecoratorA extends Decorator{
    public DecoratorA(Person person){
        this.person = person;
    }

    @Override
    public void Operation() {
        person.Operation();
        System.out.println("额外需要玩！");
    }
}






