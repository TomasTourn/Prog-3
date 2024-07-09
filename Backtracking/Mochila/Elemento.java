package Backtracking.Mochila;

public class Elemento {

    private int peso;
    private int beneficio;

    public Elemento(int peso, int beneficio) {
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public int getBeneficio() {
        return beneficio;
    }
}
