package Backtracking.Ejercicio1;

import TP_4_Grafos.Grafo;
import TP_4_Grafos.GrafoDirigido;

import java.util.ArrayList;
import java.util.List;

public class Camino {

    private List<GrafoDirigido>camino;

    public Camino() {
        camino=new ArrayList<>();
    }
    public int largo(){
        return camino.size();
    }
}
