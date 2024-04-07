package org.example.structural_type;

/**
 * 外观模式
 *
 * @author chocolate
 * @since 2024/4/3 17:26
 */
public class FacadePattern {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doMethodA();
        facade.doMethodB();
    }
}

class Facade {
    private final SubSystemA subSystemA;
    private final SubSystemB subSystemB;

    public Facade() {
        subSystemA = new SubSystemA();
        subSystemB = new SubSystemB();
    }

    public void doMethodA() {
        subSystemA.method();
    }

    public void doMethodB() {
        subSystemB.method();
    }
}

class SubSystemA {
    void method() {
        System.out.println("A");
    }
}

class SubSystemB {
    void method() {
        System.out.println("B");
    }
}
