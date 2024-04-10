package org.example.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * @author chocolate
 * 2024/4/9 16:05
 */
public class ObserverPattern {

    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        new ConcreteOb("zhangsan", concreteSubject);
        new ConcreteOb("lisi", concreteSubject);
        new ConcreteOb("wangwu", concreteSubject);

        concreteSubject.setState(1);
        concreteSubject.setState(2);
    }
}

interface Subject { // 目标接口
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

    Integer getSubjectState();
}

class ConcreteSubject implements Subject {

    private Integer state;

    List<Observer> observerList = new ArrayList<>(); // 目标中存放观察者

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(Observer::update);
    }

    @Override
    public Integer getSubjectState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
        notifyObserver();
    }
}

interface Observer { //观察者接口

    void update();
}

class ConcreteOb implements Observer {

    private final String name;

    private final Subject subject;

    private Integer state;

    public ConcreteOb(String name, Subject subject) {
        this.name = name;
        subject.addObserver(this);
        this.subject = subject;
    }

    @Override
    public void update() {
        this.state = subject.getSubjectState();
        System.out.println(this.name + "：收到通知," + this.state);
    }
}