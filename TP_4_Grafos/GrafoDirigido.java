package TP_4_Grafos;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private HashMap<Integer, HashSet<Arco<T>>>conector;


    public GrafoDirigido() {
        this.conector= new HashMap<>();
    }


    @Override
    public void agregarVertice(int verticeId) {
        if (!contieneVertice(verticeId))
            conector.put(verticeId,new HashSet<>());
    }

    @Override
    public void borrarVertice(int verticeId) {
        if (cantidadArcos() > 0){
            Iterator<Arco<T>> arcoIterator = obtenerArcos(verticeId);
            while (arcoIterator.hasNext()){
                arcoIterator.next();
                arcoIterator.remove();
            }
        }

        this.conector.remove(verticeId);

    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if (contieneKeys(verticeId1,verticeId2)){
            if (!existeArco(verticeId1,verticeId2))
                this.conector.get(verticeId1).add(new Arco<>(verticeId1,verticeId2,etiqueta));
        }

    }

    public boolean contieneKeys(int vertice1,int vertice2){
            return this.conector.containsKey(vertice1) && this.conector.containsKey(vertice2);
    }
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (contieneKeys(verticeId1, verticeId2)) {
            Iterator<Arco<T>> arcos = this.conector.get(verticeId1).iterator();
            while (arcos.hasNext()) {
                Arco<T> arco = arcos.next();
                if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2)
                    arcos.remove();
            }
        }
    }
    @Override
    public boolean contieneVertice(int verticeId) {
       return this.conector.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
       if (contieneKeys(verticeId1,verticeId2)){
           Iterator<Arco<T>> arcos = conector.get(verticeId1).iterator();
           while (arcos.hasNext()){
               Arco<T> arco=arcos.next();
               if(arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2){
                   return true;
               }
           }
       }
       return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
       if (existeArco(verticeId1,verticeId2)){
           Iterator<Arco<T>>arcos=conector.get(verticeId1).iterator();
           while (arcos.hasNext()) {
            Arco<T> arco= arcos.next();
            if (arco.getVerticeOrigen()==verticeId1 && arco.getVerticeDestino()==verticeId2){
                return arco;
            }
           }
       }
       return null;
    }

    @Override
    public int cantidadVertices() {
       return conector.size();
    }

    @Override
    public int cantidadArcos() {
      int cant=0;
        for (HashSet<Arco<T>> conjuntoArcos:conector.values()) {

            cant+=conjuntoArcos.size();
        }
        return cant;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return conector.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {

        Iterator<Arco<T>> arcoIterator = conector.get(verticeId).iterator();
        HashSet<Integer> adyacentes = new HashSet<>();

        while (arcoIterator.hasNext()){
            Arco<T> arco = arcoIterator.next();
            adyacentes.add(arco.getVerticeDestino());

        }
        return adyacentes.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {

        HashSet<Arco<T>> arcos = new HashSet<>();
        for (HashSet<Arco<T>> i: conector.values() ){
            arcos.addAll(i);
        }

        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {

        if (this.conector.containsKey(verticeId)){
            return this.conector.get(verticeId).iterator();
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GrafoDirigido: {\n");
        for (Map.Entry<Integer, HashSet<Arco<T>>> entry : conector.entrySet()) {
            Integer verticeId = entry.getKey();
            sb.append("\tVertice ").append(verticeId).append(": ");
            HashSet<Arco<T>> arcos = entry.getValue();
            sb.append("[");
            for (Arco<T> arco : arcos) {
                sb.append(arco).append(", ");
            }
            if (!arcos.isEmpty()) {
                // Remove the trailing comma and space
                sb.setLength(sb.length() - 2);
            }
            sb.append("]\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
