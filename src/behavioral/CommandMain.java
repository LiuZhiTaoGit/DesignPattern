package behavioral;

import java.lang.annotation.Target;

/**
 * @author: liuzt
 * @date: 2024/4/17 - 04 - 17 - 9:49
 * @description: behavioral  命令模式
 * @version: 1.0
 */
public class CommandMain {
    public static void main(String[] args) {
        TV tv = new TV();  //设置接收者对象，电视机

        //设置命令
        OnCommand onCommand = new OnCommand(tv);
        OffCommand offCommand = new OffCommand(tv);

        //请求者  开机命令
        Invoker invoker = new Invoker();
        invoker.setCommand(onCommand);
        invoker.calEcecute();

        //请求者  关机命令

        invoker.setCommand(offCommand);
        invoker.calEcecute();


    }
}

class Invoker{
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }

    public void calEcecute(){
        command.Execute();
    }

}


interface Command{
    public void Execute();
}



class OnCommand implements Command{
    private TV tv;
    public OnCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OnAction();
    }
}

class OffCommand implements Command{
    private TV tv;
    public OffCommand(TV tv){
        this.tv = tv;
    }

    @Override
    public void Execute() {
        tv.OffAction();
    }
}



class TV{
    public void OnAction(){
        System.out.println("开机了了。。。");
    }
    public void OffAction(){
        System.out.println("关机了。。。。");
    }
}