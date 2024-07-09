package Backtracking.desordenados;

import java.util.ArrayList;
import java.util.List;

public class BackOrdenamiento {


    private Matriz matriz;




    //verificar que el cambio es horizontal o vertical
    //cambiar de lugar la casilla
    //el caso final seria los numeros en orden y la casilla abajo a la derecha, ultima fila y ultima columna


    public Matriz back(Matriz desordenada){
        Casilla vacia= desordenada.getVacia();
        List<Casilla>visitadas;
        backtracking(desordenada,vacia,visitadas);
        return matriz;
    }
    private void backtracking(Matriz matrizActual,Casilla vacia,List<Casilla>visitadas){

        if (matrizActual.estaOrdenada()){
            if (matrizActual.vaciaEnPosicion()){
                matriz=matrizActual;
            }
        }
        else {

            List<Casilla>vecinos=vacia.getVecinos();//en teoria si es horizontal o vertical ya esta resuelto ya que los vecinos lo son
            for (Casilla v:vecinos) {
                if(!visitadas.contains(v)){
                    visitadas.add(v);
                     matrizActual.intercambiar(vacia,v);
                     backtracking(matrizActual,v);
                     matrizActual.intercambiar(v,vacia);
                     visitadas.remove(v);
                }
            }
        }


    }


}
