package org.example.structural_type;

/**
 * 代理模式
 *
 * @author chocolate
 * 2024/4/8 15:30
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Target target = new Target();
        Proxy proxy = new Proxy(target);
        proxy.buy();
    } 
}

interface Subject{
    void buy();
}

class Proxy implements Subject{

    private final Subject subject;

    public Proxy(Subject subject){
        this.subject = subject;
    }

    @Override
    public void buy() {
        System.out.println("before");
        subject.buy();
        System.out.println("after");
    }
}

class Target implements Subject{

    @Override
    public void buy() {
        System.out.println("buy something");
    }
}