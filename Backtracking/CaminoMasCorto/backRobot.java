package Backtracking.CaminoMasCorto;

import java.util.ArrayList;
import java.util.List;

public class backRobot {


    private Camino mejorCamino;

    public Camino back(Celda origen,Celda destino){
        Camino c = new Camino();
        c.agregarAlCamino(origen);
        c.marcarVisitado(origen);
        backtracking(origen,destino,c);
        return mejorCamino;
    }

    private void backtracking(Celda actual,Celda destino,Camino caminoActual){

        if(actual==destino){//llegue a destino, momento de compararar soluciones

            if (mejorCamino==null || caminoActual.size()< mejorCamino.size()){
                mejorCamino=caminoActual;
            }
               else {//recursividad
                List<Celda>vecinos=actual.getVecinos();
                for (Celda v:vecinos) {
                    if (v.valor==0 && !caminoActual.estaVisitado(v)) {//me ahorro los que son uno porque ya se que no puedo pasar por ahi
                        caminoActual.agregarAlCamino(v);
                        caminoActual.marcarVisitado(v);
                        backtracking(v, destino, caminoActual);
                        caminoActual.quitarVisitado(v);
                        caminoActual.quitarUltimo();
                    }
                }
            }

        }

    }

}
