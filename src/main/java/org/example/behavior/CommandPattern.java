package org.example.behavior;

import java.util.HashMap;
import java.util.Map;

/**
 * 命令模式
 *
 * @author chocolate
 * 2024/4/8 16:40
 */
public class CommandPattern {
    public static void main(String[] args) {
        Tv tv = new Tv();

        // 将请求封装成一个对象
        Map<String, Command> map = new HashMap<>();
        map.put("offTv",new OffCommand(tv));
        map.put("onTv",new OnCommand(tv));

        // 获取请求对象执行，通过命令接口统一调用
        Invoker invoker = new Invoker(map);
        invoker.call("onTv");
        invoker.call("offTv");
    }
}


class Invoker{
    Map<String,Command> commandMap;

    public Invoker(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    public void call(String commandKey){
        commandMap.get(commandKey).execute();
    }
}

interface Command {
    void execute();
}


class OffCommand implements Command {

    Tv tv;
    public OffCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}

class OnCommand implements Command {

    Tv tv;

    public OnCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }
}

class Tv {
    public void on() {
        System.out.println("on tv");
    }

    public void off() {
        System.out.println("off tv");
    }
}
