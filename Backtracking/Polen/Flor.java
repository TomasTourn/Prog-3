package Backtracking.Polen;

public class Flor {


    private Coordenada coordenada;
    private int cantPolen;

    public Flor(Coordenada coordenada, int cantPolen) {
        this.coordenada = coordenada;
        this.cantPolen = cantPolen;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public int getCantPolen() {
        return cantPolen;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public void setCantPolen(int cantPolen) {
        this.cantPolen = cantPolen;
    }
}
