package TP_1;

import java.util.Iterator;

public class MyIterator<T extends Comparable> implements Iterator<T> {

    Node<T> cursor;

    public MyIterator(Node<T> cursor){
        this.cursor=cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor!=null;
    }

    @Override
    public T next() {
        T info=this.cursor.getInfo();
        cursor=cursor.getNext();
        return info;
    }
}
