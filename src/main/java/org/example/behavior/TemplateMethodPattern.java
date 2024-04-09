package org.example.behavior;

/**
 * 模板方法模式
 *
 * @author Chocolate
 * @since 2024/4/10 0:07
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        Student student = new Student();
        student.templateMethod();

        new Teacher().templateMethod();
    }
}


abstract class Template {

    public void templateMethod(){
        System.out.println("start");
        doSomething();
        System.out.println("end");
    };

    abstract void doSomething();
}

class Student extends Template{
    @Override
    void doSomething() {
        System.out.println("学生上课");
    }
}

class Teacher extends Template{

    @Override
    void doSomething() {
        System.out.println("老师教课");
    }
}