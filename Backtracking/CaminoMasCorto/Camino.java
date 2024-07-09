package Backtracking.CaminoMasCorto;

import java.util.ArrayList;
import java.util.List;

public class Camino {

    List<Celda>camino;
    private int cantGiros;
    private String ultimaDireccion;

    public Camino() {
        camino=new ArrayList<>();
        cantGiros=0;
    }

    public void agregarAlCamino(Celda c){
        //todo
    }
    public boolean actualizarDireccion(String d){
        if (!d.equalsIgnoreCase(ultimaDireccion)){
            ultimaDireccion=d;
            return true;
        }
        return false;
    }


    public int getCantGiros(){
        return cantGiros;
    }

    public void marcarVisitado(Celda c){
        // TODO: 3/7/2024
    }
    public void agregarGiro(){
        this.cantGiros++;
    }
    public boolean estaVisitado(Celda c) {
        // TODO: 3/7/2024
        return true;
    }
    public void quitarUltimo(){
        // TODO: 3/7/2024
    }
    public void quitarVisitado(Celda c){
        // TODO: 3/7/2024
    }
    public int size(){
        return camino.size();
    }
}
