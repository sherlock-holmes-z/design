package org.example.behavior;

/**
 * 状态模式
 *
 * @author Chocolate
 * @since 2024/4/9 21:46
 */
public class StatePattern {
    public static void main(String[] args) {
        Context context = new Context(new StateA(), 1);
        context.request();
        context.request();
        context.request();
        context.request();
        context.request();
    }
}

class Context{

    private int count;
    private State state;

    public Context(State state, int count){
        this.state = state;
        this.count = count;
    }

    public void request(){
        state.handle(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

interface State{
    void handle(Context context);
}

class StateA implements State{

    @Override
    public void handle(Context context) {
        if (context.getCount() <= 0){
            System.out.println("没货了");
            context.setState(new StateB());
        }else {
            context.setCount(context.getCount() - 1);
            System.out.println("购买成功");
        }
    }
}


class StateB implements State{

    @Override
    public void handle(Context context) {
        context.setCount(3);
        System.out.println("===补货完成===");;
        context.setState(new StateA());
    }
}
