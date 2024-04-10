package org.example.behavior;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式
 *
 * @author chocolate
 * 2024/4/9 10:04
 */
public class IteratorPattern {
    public static void main(String[] args) {
        Aggregate myList = new MyList();
        Iterator iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


interface Iterator {
    boolean hasNext();

    Object next();
}

class SubList implements Iterator {

    private final Aggregate aggregate;
    private int size;

    private int index;

    SubList(Aggregate aggregate) {
        this.aggregate = aggregate;
        index = 0;
        size = aggregate.size();
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Object next() {
        Object s = aggregate.get(index);
        index++;
        return s;
    }
}

interface Aggregate {
    Iterator iterator();

    Object get(int index);

    int size();
}

class MyList implements Aggregate {

    private List<String> list = new ArrayList<>();

    public MyList() {
        list.add("A");
        list.add("B");
    }

    @Override
    public Iterator iterator() {
        return new SubList(this);
    }

    @Override
    public Object get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }
}
