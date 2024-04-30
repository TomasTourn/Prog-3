package TP_1;

import java.util.Iterator;

public class MyDoubleLinkedList <T extends Comparable> implements Iterator<T> {

    private Node<T>head;
    private Node<T>tail;
    private int size;

    public MyDoubleLinkedList(){
        this.head= null;
        this.tail= null;
        this.size=0;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void addFirst(T info){
        Node<T>nuevo= new Node<>(info,head,tail);
        if(isEmpty()){
            head= nuevo;
            tail= nuevo;
        }
        else{
            nuevo.setNext(head);
            nuevo.setPrevious(tail);
            head = nuevo;
        }
        size++;
    }

    public void addLast(T info){
        Node<T>nuevo= new Node<>(info);
        if (isEmpty()){
            head=nuevo;
            tail=nuevo;
        }
        else {
            tail.setNext(nuevo);
            nuevo.setPrevious(tail);
            tail=nuevo;
        }
        size++;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
