package structural;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 16:12
 * @description: structural   代理模式
 * @version: 1.0
 */
public class ProxyMain {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.buy();
    }
}



interface Subject{
    public  void buy();
}

class Proxy implements Subject{
    protected RealSubject realSubject;
    public Proxy(RealSubject realSubject){
        this.realSubject = realSubject;
    }

    @Override
    public void buy() {
        System.out.println("before:");
        realSubject.buy();
        System.out.println("after:");
    }
}

class RealSubject implements Subject{

    @Override
    public void buy() {
        System.out.println("付钱！");
    }
}


