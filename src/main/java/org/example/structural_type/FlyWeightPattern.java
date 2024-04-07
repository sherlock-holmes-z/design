package org.example.structural_type;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 *
 * @author Chocolate
 * @since 2024/4/7 23:36
 */
public class FlyWeightPattern {

    public static void main(String[] args) {
        BikeFactory.getBike("yellow").info();
        BikeFactory.getBike("white").info();
    }
}

class BikeFactory{

    public static Map<String,Bike> bikeMap = new HashMap<>();

    public static Bike getBike(String color){
        if (bikeMap.containsKey(color)){
            return bikeMap.get(color);
        }
        Bike bike = null;
        if ("yellow".equals(color)){
            bike= new MoBike();
            bikeMap.put("yellow",bike);
        }else {
            bike = new HelloBike();
            bikeMap.put("white",bike);
        }
        return bike;
    }
}

abstract class Bike{
    protected String color;

    abstract void info();
}

class MoBike extends Bike{
    public MoBike() {
        this.color = "yellow";
    }

    @Override
    void info() {
        System.out.println(color);
    }
}

class HelloBike extends Bike{

    public HelloBike() {
        this.color = "white";
    }

    @Override
    void info() {
        System.out.println(color);
    }
}
