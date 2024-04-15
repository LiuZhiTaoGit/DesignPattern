package creative;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuzt
 * @date: 2024/4/15 - 04 - 15 - 21:10
 * @description: creative
 * @version: 1.0
 */
public class BuilderModel {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1= new Builder1();
        director.Construct(builder1);
        B_Product result = builder1.getResult();
        result.show();



        Builder builder2= new Builder2();
        director.Construct(builder2);
        B_Product result2 = builder2.getResult();
        result2.show();
    }
}



class B_Product{
    List<String> parts = new ArrayList<String>();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("产品的组成：");
        for (String part : parts) {
            System.out.print(part + ' ');
        }
        System.out.println();
    }
}

abstract class Builder{
    public abstract void BuildePart();
    public abstract B_Product getResult();
}

class Builder1 extends Builder{
    B_Product b_product = new B_Product();
    @Override
    public void BuildePart() {
        b_product.add("A");
        b_product.add("B");
        b_product.add("C");
    }

    @Override
    public B_Product getResult() {
        return b_product;
    }
}

class Builder2 extends Builder{
    B_Product b_product = new B_Product();
    @Override
    public void BuildePart() {
        b_product.add("1");
        b_product.add("2");
        b_product.add("3");
    }

    @Override
    public B_Product getResult() {
        return b_product;
    }
}



class Director{
    public void Construct(Builder builder){
        builder.BuildePart();
    }

}


