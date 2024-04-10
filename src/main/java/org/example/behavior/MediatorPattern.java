package org.example.behavior;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者模式
 *
 * @author chocolate
 * 2024/4/9 11:05
 */
public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator concreteMediator = new ConcreteMediator();

        Colleague1 colleague1 = new Colleague1(concreteMediator);
        Colleague2 colleague2 = new Colleague2(concreteMediator);
        Map<String, Colleague> map = new HashMap<>();
        map.put("colleague1",colleague1);
        map.put("colleague2",colleague2);
        concreteMediator.setColleagueMap(map);

        colleague1.sendMessage("11111","colleague2");
    }
}

abstract class Mediator {
    abstract void sendMessage(String message, String receiver);
}

class ConcreteMediator extends Mediator {
    Map<String, Colleague> colleagueMap = new HashMap<>();

    public void setColleagueMap(Map<String, Colleague> colleagueMap) {
        this.colleagueMap = colleagueMap;
    }

    @Override
    void sendMessage(String message, String receiver) {
        if (colleagueMap.containsKey(receiver)) {
            colleagueMap.get(receiver).receiveMessage(message);
        } else {
            System.out.println("no colleague");
        }
    }
}

abstract class Colleague {
    protected Mediator mediator;

    abstract void sendMessage(String message, String receiver);

    abstract void receiveMessage(String message);
}

class Colleague1 extends Colleague {

    public Colleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    void sendMessage(String message, String receiver) {
        mediator.sendMessage(message, receiver);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println("Colleague1：" + message);
    }
}


class Colleague2 extends Colleague {
    public Colleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    void sendMessage(String message, String receiver) {
        mediator.sendMessage(message, receiver);
    }

    @Override
    void receiveMessage(String message) {
        System.out.println("Colleague2：" + message);
    }
}
