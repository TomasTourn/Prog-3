package TP_1;

import java.time.Period;
import java.util.Iterator;

public class MySimpleLinkedList <T extends Comparable> implements Iterable<T>{

    private Node<T> first;
    private int size;

    public MySimpleLinkedList(){
        this.first=null;
        this.size=0;
    }

     public void insertFront(T info){
        if(info!=null){
            Node<T> tmp = new Node<>(info,null);
            tmp.setNext(this.first);
            this.first=tmp;
            size++;
        }

     }

     public T extractFront(){
        T tmp = this.first.getInfo();
        first= first.getNext();
        size--;
        return tmp;
     }

     public boolean isEmpty(){
        return first==null;
     }

     public int getSize(){
        return this.size;
     }

     public T get(int index) {
         if (index >= 0 && index < size) {
             Node<T> tmp = this.first;

             for(int i=0;i<index;i++){
                 tmp=tmp.getNext();
             }

            return tmp.getInfo();
         }
         else{
             return null;
         }



     }

     public boolean buscar(Node<T> n){
        Node<T> tmp= this.first;

            while (tmp!=null || tmp.compareTo(n)!=0){
                        tmp=tmp.getNext();
            }
            return tmp.compareTo(n)==0;
     }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object nodo){
       return this.first.getInfo().equals(nodo);
    }

    public int indexOf(T nodo){
        int index=0;
        Node<T> tmp = this.first;
        while (!nodo.equals(tmp)){
            tmp=tmp.getNext();
            index++;
        }
        if (index<size){
            return index;
        }else return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
    }
}
