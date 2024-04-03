package org.example.creation_type.abstract_factory;

/**
 *
 * 抽象工厂模式
 *
 * @author chocolate
 * 2024/4/1 16:30
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        AbstractProductA productA = factory1.createA();
        productA.info();

        Factory2 factory2 = new Factory2();
        factory2.createA().info();
    }

}

abstract class Factory {
    abstract AbstractProductA createA();
    abstract AbstractProductB createB();
}


class Factory1 extends Factory{

    @Override
    AbstractProductA createA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createB() {
        return new ProductB1();
    }
}

class Factory2 extends Factory{

    @Override
    AbstractProductA createA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createB() {
        return new ProductB2();
    }
}

abstract class AbstractProductA {
    abstract void info();
}

class ProductA1 extends AbstractProductA {

    @Override
    void info() {
        System.out.println("ProductA1");
    }
}

class ProductA2 extends AbstractProductA {

    @Override
    void info() {
        System.out.println("ProductA2");
    }
}


abstract class AbstractProductB {
    public abstract void info();
}

class ProductB1 extends AbstractProductB {
    @Override
    public void info() {
        System.out.println("ProductB1");
    }
}

class ProductB2 extends AbstractProductB {
    @Override
    public void info() {
        System.out.println("ProductB2");
    }
}
