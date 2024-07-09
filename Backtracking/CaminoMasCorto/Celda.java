package Backtracking.CaminoMasCorto;

import java.util.ArrayList;
import java.util.List;

public class Celda {
    int fila;
    int columna;
    int valor;// 0 o 1


    public void setValor(int v){//xd
        if (v==1||v==2){
            valor=v;
        }
    }

    public List<Celda> getVecinos(){
        // TODO: 3/7/2024  
        return new ArrayList<>();
    }
    public int getValor(){
        return this.valor;
    }
}
