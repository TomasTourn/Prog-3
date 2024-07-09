package Backtracking.Mochila;

import java.util.ArrayList;
import java.util.List;

public class Mochila {

    private int pesoMaximo;
    private Elemento[]elementos;
    private int peso;
    private int beneficio;

    public Mochila(int pesoMaximo,int numElementos) {
        this.pesoMaximo = pesoMaximo;
        this.elementos=new Elemento[numElementos];
        this.peso=0;
        this.beneficio=0;
    }

    public void aniadirElemento(Elemento e){
        for (int i=0;0< elementos.length;i++){
                if (elementos[i]==null){
                    elementos[i]=e;
                    this.peso+=e.getPeso();
                    this.beneficio+=e.getBeneficio();
                    break;
                }
        }
    }

    public void clear(){
        this.peso=0;
        this.beneficio=0;
        for (int i=0;i< elementos.length;i++){
            this.elementos[i]=null;
        }
    }

    public void eliminarElemento(Elemento e){
        for(int i=0;i<elementos.length;i++){
            if (this.elementos[i].equals(e)){
                this.elementos[i]=null;
                this.peso-=e.getPeso();
                this.beneficio-=e.getBeneficio();
            }
        }
    }

    public int getPesoMaximo() {
        return pesoMaximo;
    }

    public Elemento[] getElementos() {
        return elementos;
    }

    public int getPeso() {
        return peso;
    }

    public int getBeneficio() {
        return beneficio;
    }
}
