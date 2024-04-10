package org.example.behavior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 策略模式
 *
 * @author Chocolate
 * @since 2024/4/9 23:06
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Map<String,Strategy> strategyMap = new HashMap<>();
        strategyMap.put("add",new AddStrategy());
        strategyMap.put("sub",new SubStrategy());
        strategyMap.put("mul",new MulStrategy());
        strategyMap.put("div",new DivStrategy());
        OperationContext context = new OperationContext(strategyMap);
        context.operate("add",1,2);
    }
}

class OperationContext {

    Map<String, Strategy> strategyMap = new HashMap<>();

    public OperationContext(Map<String, Strategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public void operate(String operation,int a, int b) {
        Strategy strategy = strategyMap.get(operation);
        System.out.println(strategy.numOperation(a, b));
    }
}

interface Strategy {
    int numOperation(int num1, int num2);
}


class AddStrategy implements Strategy {

    @Override
    public int numOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class SubStrategy implements Strategy {

    @Override
    public int numOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class MulStrategy implements Strategy {

    @Override
    public int numOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class DivStrategy implements Strategy {

    @Override
    public int numOperation(int num1, int num2) {
        return num1 / num2;
    }
}
