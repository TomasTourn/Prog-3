package TP_1;

public class Node<T extends Comparable> implements Comparable{

    private T info;
    private Node<T> next;
    private Node<T>previous;

    public Node() {
        this.info = null;
        this.next = null;
        this.previous = null;
    }

    public Node(T info) {
        this.info = info;
        this.next=null;
        this.previous=null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node(T info, Node<T> next, Node<T> previous) {
        this.info = info;
        this.next = next;
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public boolean equals(Object o){
        Node<T> nodo=(Node)o;
        return this.getInfo().equals(nodo.getInfo());
    }

    @Override
    public int compareTo(Object o) {
        Node<T> nodo = (Node<T>)o;
        return this.info.compareTo(nodo.getInfo());
    }
}