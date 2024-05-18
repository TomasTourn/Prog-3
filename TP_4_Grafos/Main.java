package TP_4_Grafos;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        // Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
        GrafoDirigido<Float> grafito = new GrafoDirigido<Float>();

        // Agrego los vertices 1 y 2
        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        //--------------------------------------------
        GrafoDirigido<Float> grafon = new GrafoDirigido<Float>();
        grafon.agregarVertice(5);
        grafon.agregarVertice(6);
        grafon.agregarVertice(7);
        grafon.agregarVertice(8);

        grafon.agregarArco(5, 6, 3F);
        grafon.agregarArco(5,7,4F);
        grafon.agregarArco(7,8,10f);
        grafon.agregarArco(8,8,5F);
        grafon.agregarArco(6,5,8F);
        grafon.agregarArco(6,8,9F);
        //--------------------------------------------
        // Genero un arco desde 1 hasta 2 con el valor de etiqueta 3
        grafito.agregarArco(1, 2, 3F);
        grafito.agregarArco(1,3,4F);
        grafito.agregarArco(2,4,10f);
        grafito.agregarArco(2,3,5F);
        grafito.agregarArco(3,1,8F);
        grafito.agregarArco(3,4,9F);

        // Obtengo el arco entre 1 y 2, y le pido la etiqueta
        grafon.borrarArco(5,6);
       // System.out.println(grafon.obtenerArco(5, 6));
        int cantArcos = grafon.cantidadArcos();


        //System.out.println(etiqueta); // Debería imprimir 3
       // System.out.println(cantArcos); // deberia imprimir 2
        //System.out.println("-----------------------------------------------"); // deberia imprimir 2
        Iterator<Integer> iterator = grafon.obtenerVertices();



        /** Iterator<Integer>iterator= grafito.obtenerAdyacentes(1);
         while (iterator.hasNext()){
         Integer ady = iterator.next();
         System.out.println(ady);
         }*/

        //  Iterator<Arco<Float>> a = grafito.obtenerArcos();

        // while (a.hasNext()){
        //    Arco<Float> ar = a.next();
        //   System.out.println(ar);
        // }
        // Iterator<Arco<Float>> obtenerArcoEspecifico = grafito.obtenerArcos(1);

        // while (obtenerArcoEspecifico.hasNext()){
        //    Arco<Float> arcoEspecifico = obtenerArcoEspecifico.next();
        //    System.out.println(arcoEspecifico);
        //  }

        DepthFirstSearch recorrido=new DepthFirstSearch<>(grafito);
        recorrido.dfs();
    }
}