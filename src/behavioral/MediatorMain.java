package behavioral;

import java.time.Period;
import java.util.Collection;

/**
 * @author: liuzt
 * @date: 2024/4/17 - 04 - 17 - 11:04
 * @description: behavioral  中介者模式
 * @version: 1.0
 */
public class MediatorMain {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(concreteMediator);
        Colleague2 colleague2  = new Colleague2(concreteMediator);

        concreteMediator.setColleague1(colleague1);
        concreteMediator.setColleague2(colleague2);

        colleague1.sendMessage("你好啊，老二");
        colleague2.sendMessage("好你个头！");
    }
}


abstract class Colleague{
    protected Mediator mediator;
}

class Colleague1 extends Colleague{
    public Colleague1(Mediator mediator){
        this.mediator = mediator;
    }
    public void sendMessage(String message){
        mediator.sendMessage(message, this);
    }
    public void showMessage(String message){
        System.out.println("同事1收到信息：" +message);
    }
}

class Colleague2 extends Colleague{
    public Colleague2(Mediator mediator){
        this.mediator = mediator;
    }
    public void sendMessage(String message){
        mediator.sendMessage(message, this);
    }
    public void showMessage(String message){
        System.out.println("同事2收到信息：" +message);
    }
}

abstract class Mediator{
    /**
     * 中介者传递信息
     * @param message  信息的内容
     * @param colleague  信息发送者
     */
    public abstract void sendMessage(String message,Colleague colleague);
}



class ConcreteMediator extends Mediator{
    private Colleague1 colleague1;
    private Colleague2 colleague2;

    public Colleague1 getColleague1() {
        return colleague1;
    }

    public void setColleague1(Colleague1 colleague1) {
        this.colleague1 = colleague1;
    }

    public Colleague2 getColleague2() {
        return colleague2;
    }

    public void setColleague2(Colleague2 colleague2) {
        this.colleague2 = colleague2;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if(colleague == colleague1){//如果发送者是同事1，那就让同事2展示信息
            colleague2.showMessage(message);
        }else {
            colleague1.showMessage(message);
        }
    }
}


