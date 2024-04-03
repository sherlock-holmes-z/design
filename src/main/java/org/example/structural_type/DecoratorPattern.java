package org.example.structural_type;

/**
 * 装饰模式
 *
 * @author chocolate
 * 2024/4/3 17:26
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        Person student = new Student();
        student = new DecoratorA(student);
        student.info();
    }
}

abstract class Person{

    abstract void info();
}

class DecoratorA extends Person{

    Person person;

    public DecoratorA(Person person) {
        this.person = person;
    }

    @Override
    void info() {
        person.info();
        System.out.println("decoratorA");
    }
}

class Student extends Person{
    @Override
    void info() {
        System.out.println("学习");
    }
}