package org.example.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 备忘录模式
 *
 * @author chocolate
 * 2024/4/9 14:46
 */
public class MementoPattern {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();

        Originator originator = new Originator("A");
        Memento memento = originator.createMemento();
        caretaker.add(memento);

        originator.setState("B");
        Memento memento2 = originator.createMemento();
        caretaker.add(memento2);

        originator.setState("C");
        Memento memento3 = originator.createMemento();
        caretaker.add(memento3);

        Memento memento1 = caretaker.get(1);
        System.out.println(memento1.getState());

        caretaker.all();
    }
}

class Originator { // 原发器，负责创建备忘录

    private String state;

    public Originator(String state) {
        this.state = state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }
}

class Memento { // 备份
    private final String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Caretaker { // 管理者

    List<Memento> mementos = new ArrayList<>();

    public void add(Memento memento) {
        mementos.add(memento);
    }

    public Memento get(Integer index) {
        if (index >= 0 && index < mementos.size()) {
            return mementos.get(index);
        }
        return null;
    }

    public void all(){
        mementos.forEach(m -> System.out.println(m.getState()));
    }
}
