package behavioral;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 17:18
 * @description: behavioral  责任链模式   如果小于100，就直接批准，否则让校长处理
 * @version: 1.0
 */
public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        Handle fuDaoYuan = new FuDaoYuan();
        Handle xiaoZhang = new XiaoZhang();
        fuDaoYuan.setNext(xiaoZhang);

        fuDaoYuan.HandleRequest(100000);

    }
}

abstract class Handle{
    protected Handle next;

    public void setNext(Handle next){
        this.next = next;
    }
    public abstract void HandleRequest(int request);
}

class FuDaoYuan extends Handle{

    @Override
    public void HandleRequest(int request) {
        if(request<=100){
            System.out.println("辅导员：批准通过！");
        }else{
            if(next != null){
                next.HandleRequest(request);
            }else{
                System.out.println("无法处理！");
            }
        }
    }
}

class XiaoZhang extends Handle{

    @Override
    public void HandleRequest(int request) {
        if(request>=100 && request<=10000){
            System.out.println("校长：批准通过！");
        }else{
            if(next != null){
                next.HandleRequest(request);
            }else{
                System.out.println("无法处理！");
            }
        }
    }
}