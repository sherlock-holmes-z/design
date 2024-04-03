package org.example.structural_type;

/**
 * 适配器
 *
 * @author chocolate
 * 2024/4/2 16:43
 */
public class AdapterType {

    public static void main(String[] args) {
        Usb usb = new Adapter();
        usb.info();
    }
}


class Usb{
    public void info(){
        System.out.println("usb");
    }
}


class Adapter extends Usb{
    private final TypeC typeC = new TypeC();

    @Override
    public void info() {
        typeC.typeC();
    }
}

class TypeC{
    public void typeC(){
        System.out.println("typeC");
    }
}


