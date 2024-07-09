package TP_4_Grafos;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DepthFirstSearch <T>{

    private Grafo<T> grafo;
    private HashMap<Integer,String>verticePintado;
    private boolean ciclo;

    public DepthFirstSearch(Grafo<T> grafo) {
        this.grafo = grafo;
        verticePintado=new HashMap<>();
        this.ciclo=false;
    }


    public void dfs(){
        Iterator<Integer> vertices =grafo.obtenerVertices();//devuelve el conjunto de vertices

        while (vertices.hasNext()){
            verticePintado.put(vertices.next(),"BLANCO");
        }

        for (Map.Entry<Integer,String> entry:verticePintado.entrySet()) {
            Integer vertice=entry.getKey();
            String color=entry.getValue();
            if (color.equalsIgnoreCase("BLANCO")){
                dfs_visit(vertice);
        }
       }
        System.out.println();

    }

    private void dfs_visit(Integer vertice){
            System.out.println("Visitando Vertice: "+vertice);
            verticePintado.put(vertice,"AMARILLO");

            Iterator<Integer>adyacentes=grafo.obtenerAdyacentes(vertice);

            while (adyacentes.hasNext()){
                Integer actual= adyacentes.next();
                if (verticePintado.get(actual).equalsIgnoreCase("BLANCO")){
                    dfs_visit(actual);
                }else if (verticePintado.get(actual).equalsIgnoreCase("AMARILLO")) {
                    // Si encontramos un vértice "AMARILLO", hay un ciclo
                    ciclo = true;
                }

            }

            verticePintado.put(vertice,"NEGRO");
            System.out.println("Vertice Terminado: "+vertice);
    }

    public HashMap<Integer, String> getVerticePintado() {
        return verticePintado;
    }
}
