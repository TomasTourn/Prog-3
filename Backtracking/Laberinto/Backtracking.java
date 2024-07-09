package Backtracking.Laberinto;

import java.util.ArrayList;

public class Backtracking {

    private Casillero destino;
    private Camino mejorCamino;

    public Camino back(Casillero origen){

        Camino c= new Camino();//creo una solucion parcial
        c.agregarAlCamino(origen);
        c.marcarVisitado(origen);
        c.incrementar(origen.getValor());
        this.backtracking(origen,c);
        return mejorCamino;
    }
    private void backtracking(Casillero actual,Camino caminoActual){

        if(actual==this.destino){//llegue al destino

            if (mejorCamino==null||caminoActual.getValor()< mejorCamino.getValor()){
                mejorCamino=caminoActual;
            }
        }else {//recursividad
            ArrayList<Casillero>vecinos=actual.getVecinos();//guardo mis vecinos para recorrerlos

            for (Casillero v:vecinos) {
                if (!caminoActual.estaVisitado(v)) {
                    caminoActual.agregarAlCamino(v);
                    caminoActual.marcarVisitado(v);
                    caminoActual.incrementar(v.getValor());
                    if (mejorCamino == null || caminoActual.getValor() <= mejorCamino.getValor()) {//poda, solo sigo explorando si no hay mejor solucion aun o si mi valor actual es menor al valor de la mejor solucion, sino estoy generando estados que no voy a usar
                        backtracking(v,caminoActual);
                        //deshacer
                        caminoActual.quitarUltimo();
                        caminoActual.quitarVisitado(v);
                        caminoActual.decrementar(v.getValor());
                    }
                }
            }

        }

    }

}
