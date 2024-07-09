package Backtracking.Polen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Estado {// toda la info la tiene el estado

    List<Flor>floresVisitadas;
    int cantPolen;
    Coordenada posAbeja;

    public Estado(int cantPolen, Coordenada posAbeja) {
        this.floresVisitadas = new LinkedList<>();
        this.cantPolen = cantPolen;
        this.posAbeja = posAbeja;
    }

    public boolean visiteMaxFlores(){
        return floresVisitadas.size()==5;
    }

    public List<Flor> getFloresVisitadas() {
        return new ArrayList<>(floresVisitadas);
    }

    public int getCantPolen() {
        return cantPolen;
    }

    public Coordenada getPosAbeja() {
        return posAbeja;
    }

    public void addFlorVisitada(Flor f) {
        floresVisitadas.add(f);
    }

    public void agregarPolen(int cantPolen) {
        this.cantPolen = cantPolen;
    }

    public void moverAbeja(Coordenada posAbeja) {
        this.posAbeja = posAbeja;
    }
    public void quitarPolen(int polen){
        this.cantPolen=this.cantPolen-polen;
    }
    public void quitarFlorVisitada(Flor f){
        floresVisitadas.remove(f);
    }
}
