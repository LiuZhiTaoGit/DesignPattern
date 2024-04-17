package behavioral;

import org.omg.CORBA.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author: liuzt
 * @date: 2024/4/17 - 04 - 17 - 13:08
 * @description: behavioral  观察者模式
 * @version: 1.0
 */
public class ObserverMain {
     public static void main(String[] args) {
        Subject concreteSubject = new ConcreteSubject("礼炮二"); //这个是具体的up主
        //下面是三个粉丝
        Observer concreteObserver1 = new ConcreteObserver("张1",concreteSubject);
        Observer concreteObserver2 = new ConcreteObserver("张2",concreteSubject);
        Observer concreteObserver3 = new ConcreteObserver("张3",concreteSubject);
        //up更新，通知粉丝
         concreteSubject.setStatue("晚了");
//        concreteSubject.Notify();

    }
}


interface Observer{  //观察者接口  理解为粉丝，
    public void Update();  //收到通知之后就更新状态
}


interface Subject{  //目标，理解为up主。
    public void Attach(Observer observer);
    public void Detach(Observer observer);
    public void Notify();

    public void setStatue(String statue);//得到状态
    public String getStatue();//获取状态
}


class ConcreteObserver implements Observer{
    private String name;
    private Subject subject;
    private String statue;
    public ConcreteObserver(String name, Subject subject){
        this.name = name;
        this.subject = subject;
        subject.Attach(this);
    }

    @Override
    public void Update() {
        System.out.println(this.name + "收到通知！");
        statue = subject.getStatue();
        System.out.println(this.name + "的状态是："+ statue);
    }
}

class ConcreteSubject implements Subject{
    private List<Observer> observerList;
    private String statue;
    private String name;
    public ConcreteSubject(String name){
        statue = "未更新";
        this.name = name;
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void Attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer : observerList) {
            observer.Update();
        }
    }

    @Override
    public void setStatue(String statue) {
        this.statue = statue;
        System.out.println(name + "的状态发生了改变，状态为；" + statue);
        Notify();
    }

    @Override
    public String getStatue() {
        return statue;
    }
}