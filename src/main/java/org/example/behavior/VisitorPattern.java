package org.example.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 *
 * @author Chocolate
 * @since 2024/4/10 1:11
 */
public class VisitorPattern {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.show(new ConcreteVisitor());
        structure.show(new ConcreteVisitor2());
    }

}

interface Visitor {

    void visitA(Element element);
}

class ConcreteVisitor implements Visitor {
    @Override
    public void visitA(Element element) {
        System.out.println("访问A:"+element.name);
    }
}

class ConcreteVisitor2 implements Visitor {

    @Override
    public void visitA(Element element) {
        System.out.println("增加的新操作：访问A:"+element.name);
    }
}

abstract class Element{

    protected String name;

    abstract void accept(Visitor visitor);
}

class ElementA extends Element{

    public ElementA(String name) {
        this.name = name;
    }

    /**
     * 接收访问者，由访问者对当前对象执行方法
     *
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visitA(this);
    }
}

class ObjectStructure{
    private List<Element> elementList = new ArrayList<Element>();

    {
        elementList.add(new ElementA("a"));
        elementList.add(new ElementA("b"));
        elementList.add(new ElementA("c"));
    }

    public void show(Visitor visitor){
        elementList.forEach(element -> element.accept(visitor));
    }
}

