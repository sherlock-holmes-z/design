package org.example.creation_type.simple_factory;

/**
 * 简单工厂模式
 *
 * @author chocolate
 * 2024/4/1 15:42
 */
public class SimpleFactory {
    public static void main(String[] args) {
        Product product = Factory.createProduct("A");
        product.info();
    }
}

class Factory {
    public static Product createProduct(String type) {
        Product product = null;

        switch (type) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:
                System.out.println("no product");
        }
        return product;
    }
}

abstract class Product {
    abstract void info();
}

class ProductA extends Product {

    @Override
    void info() {
        System.out.println("A");
    }
}


class ProductB extends Product {

    @Override
    void info() {
        System.out.println("B");
    }
}