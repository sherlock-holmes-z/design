package org.example.creation_type.factory_method;

/**
 * 工厂方法模式
 *
 * @author chocolate
 * 2024/4/1 16:10
 */
public class FactoryMethod {

    public static void main(String[] args) {
        Factory factory = new FactoryA();
        factory.createProduct().info();
    }
}

interface Factory {
    public Product createProduct();
}

class FactoryA implements Factory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB implements Factory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}


class ProductA implements Product {

    @Override
    public void info() {
        System.out.println("A");
    }
}

class ProductB implements Product {

    @Override
    public void info() {
        System.out.println("B");
    }
}

interface Product {
    void info();
}

