package Backtracking.Laberinto;

import java.util.ArrayList;

public class Casillero {
    private int valor;
    private boolean norte;
    private boolean sur;
    private boolean oeste;
    private boolean este;
    private int fila;
    private int columna;

    public Casillero() {
    }

    public ArrayList<Casillero>getVecinos(){
        //todo
        return new ArrayList<Casillero>();
    }
    public int getValor() {
        return valor;
    }

    public boolean isNorte() {
        return norte;
    }

    public boolean isSur() {
        return sur;
    }

    public boolean isOeste() {
        return oeste;
    }

    public boolean isEste() {
        return este;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
}
