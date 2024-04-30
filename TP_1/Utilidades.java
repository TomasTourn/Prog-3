package TP_1;

import java.util.*;

public class Utilidades<T extends Comparable> {


        public MySimpleLinkedList<T> encontrarCoincidencias(MySimpleLinkedList<T> lista1, MySimpleLinkedList<T> lista2) {
            MySimpleLinkedList<T> coincidencias = new MySimpleLinkedList<>();
            Iterator<T> iter1 = lista1.iterator();
            Iterator<T> iter2 = lista2.iterator();

            T valor1 = iter1.hasNext() ? iter1.next() : null;
            T valor2 = iter2.hasNext() ? iter2.next() : null;

            while (valor1 != null && valor2 != null) {

                if (valor1.compareTo(valor2)==0) {
                    coincidencias.insertFront(valor1);
                    valor1 = iter1.hasNext() ? iter1.next() : null;
                    valor2 = iter2.hasNext() ? iter2.next() : null;
                } else if (valor1.compareTo(valor2)>0) {
                    valor1 = iter1.hasNext() ? iter1.next() : null;
                } else {
                    valor2 = iter2.hasNext() ? iter2.next() : null;
                }
            }

            return coincidencias;
        }
/*
        public MySimpleLinkedList<T> soloEnLista1(MySimpleLinkedList<T>lista1,MySimpleLinkedList<T>lista2) {

            MySimpleLinkedList<T> listaFinal = new MySimpleLinkedList<>();

            Iterator<T> iter1= lista1.iterator();
            T valor1 = iter1.hasNext() ? iter1.next() : null;
            Iterator<T> iter2= lista2.iterator();
            T valor2 = iter2.hasNext() ? iter2.next() : null;

            if (valor.)

        }*

}





    // en caso de q las listas esten ordenadas y sea solo de integer
   /* public static List<Integer>encontrarCoincidencias(List<Integer>lista1,List<Integer>lista2){
        List<Integer>coincidencias= new ArrayList<>();// creo el array q va a contener las coincidencias

        Iterator<Integer> iter1 = lista1.iterator();
        Iterator<Integer> iter2 = lista2.iterator();

        Integer valor1= iter1.hasNext() ? iter1.next() : null;//asigno valor, si hay siguiente lo tomo, sino se convierte en null
        Integer valor2= iter2.hasNext() ? iter2.next() : null;

        while(valor1!=null && valor2!=null){
            if(valor1.equals(valor2)){
                coincidencias.add(valor1);
                valor1= iter1.hasNext() ? iter1.next(): null;
                valor2= iter2.hasNext() ? iter2.next(): null;
            }
            else if (valor1<valor2) {
                valor1= iter1.hasNext() ? iter1.next() : null;
            }
            else if (valor2<valor1) {
                valor2= iter2.hasNext() ? iter2.next() : null;
            }
        }
        return coincidencias;

    }
    */

    }





