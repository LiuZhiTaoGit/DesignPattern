package creative;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 10:35
 * @description: creative
 * @version: 1.0
 */
public class SingletonMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.getId() + "   " + singleton.getPrice());




    }
}



class Singleton{
    private  int id = 3;
    private double price = 45.1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static Singleton getSingleton() {
        return singleton;
    }

    public static void setSingleton(Singleton singleton) {
        Singleton.singleton = singleton;
    }

    public Singleton(int id, double price) {
        this.id = id;
        this.price = price;
    }

    private static Singleton singleton = new Singleton();
    private Singleton(){}  //这样就保证了外面不能有实例，只用这一个

    public static Singleton getInstance(){
        return singleton;
    }
}
