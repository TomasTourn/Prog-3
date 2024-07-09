package Backtracking.Polen;

import java.util.LinkedList;
import java.util.List;

public class Solucion {

    List<Flor>floresVisitadas;
    int cantPolen;

    public Solucion() {
        this.floresVisitadas = new LinkedList<>();
        this.cantPolen = 0;
    }

    public List<Flor> getFloresVisitadas() {
        return floresVisitadas;
    }

    public int getCantPolen() {
        return cantPolen;
    }
    public void copiar(Estado e){
        cantPolen=e.getCantPolen();
        floresVisitadas=e.getFloresVisitadas();
    }
}
