package org.example.behavior;

/**
 * 责任链模式
 *
 * @author chocolate
 * 2024/4/8 16:06
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        Handler handler = new Second(null);
        handler = new First(handler);
        handler.handlerRequest(3);
    }
}

abstract class Handler {
    protected Handler next;

    abstract void handlerRequest(int num);
}

class First extends Handler {
    public First(Handler next) {
        this.next = next;
    }

    @Override
    void handlerRequest(int num) {
        if (num < 7) {
            System.out.println("first");
        } else {
            if (next != null) {
                next.handlerRequest(num);
            } else {
                System.out.println("无法处理");
            }
        }
    }
}

class Second extends Handler {

    public Second(Handler next) {
        this.next = next;
    }

    @Override
    void handlerRequest(int num) {
        if (num < 30) {
            System.out.println("second");
        } else {
            if (next != null) {
                next.handlerRequest(num);
            } else {
                System.out.println("无法处理");
            }
        }
    }
}

