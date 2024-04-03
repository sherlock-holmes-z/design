package org.example.structural_type;

/**
 * 桥接模式
 *
 * @author chocolate
 * 2024/4/3 14:27
 */
public class Bridge {
    public static void main(String[] args) {
        Product product = new ProductA();
        product.setColor(new Red());
        product.info();
    }
}


abstract class Product{
    public Color color;

    abstract void info();

    public void setColor(Color color) {
        this.color = color;
    }
}

class ProductA extends Product{
    @Override
    void info() {
        color.color();
    }
}


interface Color{
    void color();
}

class Red implements Color{

    @Override
    public void color() {
        System.out.println("red");
    }
}

class Black implements  Color{

    @Override
    public void color() {
        System.out.println("black");
    }
}

