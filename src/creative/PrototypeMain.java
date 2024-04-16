package creative;

/**
 * @author: liuzt
 * @date: 2024/4/16 - 04 - 16 - 10:01
 * @description: creative   原型模式
 * @version: 1.0
 */
public class PrototypeMain {
    public static void main(String[] args) {
        PProduct pProduct = new PProduct(11,12.3);
        System.out.println(pProduct.getId()+"  "+pProduct.getPrice()+" "+ pProduct);

        PProduct product = (PProduct) pProduct.Clone();
        System.out.println(product.getId()+"  "+ pProduct.getPrice()+"  "+product);


    }
}

interface Prototype{
    public Object Clone();
}

class PProduct implements Prototype{
    private int id;
    private double price;



    public PProduct() {
    }
    public PProduct(int id, double price) {
        this.id = id;
        this.price = price;
    }

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

    @Override
    public Object Clone() {
        PProduct pProduct = new PProduct();
        pProduct.id = this.id;
        pProduct.price = this.price;
        return pProduct;
    }
}

