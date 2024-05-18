package TP_4_Grafos;

import java.util.*;

public class BreadthFirstSearch<T> {

    private Grafo<T> grafo;
    private HashMap<Integer,Boolean>verticeVisitado;
    private List<Integer> queue;

    public BreadthFirstSearch(Grafo<T> grafo) {
        this.grafo = grafo;
        this.verticeVisitado = new HashMap<>();
        queue =new ArrayList<>();
    }

    public void bfs(){
        this.queue.clear();
        Iterator<Integer> vertices=this.grafo.obtenerVertices();

        while (vertices.hasNext()) {
            verticeVisitado.put(vertices.next(),false);
        }

        for (Map.Entry<Integer,Boolean> entry:verticeVisitado.entrySet()) {
            Integer vertice=entry.getKey();
            Boolean fueVisitado=entry.getValue();
            if (!fueVisitado){
                bfs(vertice);
            }
        }
    }

    private void bfs(Integer vertice){
        verticeVisitado.put(vertice,true);
        this.queue.add(vertice);

        System.out.println("visitó");
        while (!queue.isEmpty()){//mientras la cola no este vacia la recorro


            int v= queue.remove(0);
            System.out.println("Visitó vertice: "+v);
                Iterator<Integer>adyacentes = this.grafo.obtenerAdyacentes(v);


                while (adyacentes.hasNext()){

                  Integer ady=adyacentes.next();
                    if (!verticeVisitado.get(ady)){
                        verticeVisitado.put(ady,true);
                        queue.add(ady);
                    }
                }
        }


    }
}
