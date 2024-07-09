package TP_4_Grafos;

import java.util.*;

public class RecorridoSimple {

    private Grafo<?> grafo;
    private Set<Integer> visitados;

    public RecorridoSimple(Grafo<?> grafo){
        this.grafo=grafo;
        this.visitados=new HashSet<>();
    }
    public List<Integer> caminoMasLargo(Integer origen,Integer destino){

        List<Integer> caminoMasLargo=new ArrayList<>();
        visitados.add(origen);
        if (Objects.equals(origen, destino)){
            caminoMasLargo.add(origen);
        }else {
            Iterator<Integer> it =grafo.obtenerAdyacentes(origen);

            while (it.hasNext()){
                Integer ady= it.next();
                if (!visitados.contains(ady)){
                    List<Integer>caminoAdyacente = caminoMasLargo(ady,destino);
                    if (!caminoAdyacente.isEmpty() && caminoAdyacente.size()>=caminoMasLargo.size()){
                        caminoMasLargo.clear();
                        caminoMasLargo.add(origen);
                        caminoMasLargo.addAll(caminoAdyacente);
                    }
                }
            }

        }

        visitados.remove(origen);
        return caminoMasLargo;
    }

}
