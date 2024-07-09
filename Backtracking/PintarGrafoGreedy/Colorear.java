package Backtracking.PintarGrafoGreedy;

import TP_4_Grafos.Grafo;

import java.util.*;

public class Colorear {


    //greedy


    public Grafo solucionGreedy(Grafo grafo,List<String>colores){

        //por cada vertice tengo que pintarlo de un color distinto al de sus adyacentes
        //tendria   que comprobar si uno de los colores de mi lista esta disponible, sino agregaria un color a mi lista y lo usaria

        Iterator<Integer> it=grafo.obtenerVertices();

        while (it.hasNext()){

            int vertice=it.next();

            Iterator<Integer>ady= grafo.obtenerAdyacentes(vertice);
            Set<String>colorAdyacentes = new HashSet<>();

            while (ady.hasNext()){//adyacentes
                colorAdyacentes.add(grafo.getColorVertice(ady.next());
            }

            for (String color:colores) {
                if (!colorAdyacentes.contains(color)){
                    grafo.pintarVertice(vertice,color);
                }
            }
            if (grafo.getColorVertice(vertice)==null){
                grafo.pintarVertice(vertice,this.agregarColor());
            }
        }




    }



    public String agregarColor(){
        //todo
    }



}
