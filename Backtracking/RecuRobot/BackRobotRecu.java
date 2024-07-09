package Backtracking.RecuRobot;

import Backtracking.CaminoMasCorto.Camino;
import Backtracking.CaminoMasCorto.Celda;

import java.util.List;

public class BackRobotRecu {

    private Camino caminoMasCorto;
    private Celda base;
    public Camino back(Celda origen){
        Camino c=new Camino();
        c.agregarAlCamino(origen);
        c.marcarVisitado(origen);
        backtracking(origen,c);
        return caminoMasCorto;
    }

    private void backtracking(Celda actual,Camino caminoActual){

        if (actual==base){//llegué a la base
            if (caminoMasCorto==null||caminoActual.getCantGiros()< caminoMasCorto.getCantGiros() &&
                    caminoActual.size()<=caminoMasCorto.size()){
                caminoMasCorto=caminoActual;
            }
        }else {
            List<Celda>vecinos=actual.getVecinos();
            for (Celda v:vecinos) {
                if (v.getValor()==0 && !caminoActual.estaVisitado(v)){
                    caminoActual.agregarAlCamino(v);
                    caminoActual.marcarVisitado(v);
                   if (caminoActual.actualizarDireccion(determinarDireccion(actual,v))) {
                       caminoActual.agregarGiro();
                   }
                    backtracking(v,caminoActual);
                    caminoActual.quitarVisitado(v);
                    caminoActual.quitarUltimo();

                }
            }

        }




    }

    public String determinarDireccion(Celda a,Celda b){
        return "hola";
    }

    public boolean cambioDeDireccion(Celda a,Celda b){
        //
    }


}
