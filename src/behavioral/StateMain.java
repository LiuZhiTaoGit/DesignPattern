package behavioral;

/**
 * @author: liuzt
 * @date: 2024/4/17 - 04 - 17 - 14:35
 * @description: behavioral  状态模式
 * @version: 1.0
 */
public class StateMain {
    public static void main(String[] args) {
        Context context = new Context();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
        context.Request();
    }
}

class Context{  //售卖机
    private int count;
    private State state;

    public Context() {
        count = 3;
        state = new StateA();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public void Request(){//购买一个饮料
        state.Handle(this);
    }



}

interface State{
    public void Handle(Context context);

}

class StateA implements State{
    @Override
    public void Handle(Context context) {
        int count = context.getCount();
        if(count >= 1){
            System.out.println("购买成功！");
            context.setCount(count-1);
            if(context.getCount() == 0){
                context.setState(new StateB());
            }
        }
    } // 这个是有货状态

}

class StateB implements State{
    @Override
    public void Handle(Context context) {
        System.out.println("此时无货");
        context.setCount(3);
        System.out.println("补货成功！");
        context.setState(new StateA());
    } //这个是无货状态

}

