package Backtracking.Ejercicio1;

import java.util.List;

public class BackSalas {

    private Camino caminoMasLargo;

    public Camino back(Nodo entrada,Nodo salida){
        Camino c=new Camino();
        c.agregarNodo(entrada);
        c.marcarVisitado(entrada);
        backtracking(entrada,salida,c);
        return caminoMasLargo;
    }

    private void backtracking(Nodo actual,Nodo salida, Camino caminoActual){


        if (actual==salida){

            if (caminoMasLargo==null || caminoActual.largo()>caminoMasLargo.largo()){
                caminoMasLargo=caminoActual;
            }
        }else {//recursividad
            List<Nodo>vecinos=actual.getVecinos();//devuelve array con los adyacentes del nodo
            for (Nodo v:vecinos) {

                    if (!caminoActual.estaVisitado(v)){

                        caminoActual.agregarAlCamino(v);
                        caminoActual.marcarVisitado(v);
                        backtracking(v,salida,caminoActual);
                        caminoActual.quitarUltimo();
                        caminoActual.desmarcarVisitado(v);
                    }
            }
        }

    }

}
