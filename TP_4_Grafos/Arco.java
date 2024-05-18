package TP_4_Grafos;

public class Arco<T> {
    //clase inmutable

    private int verticeOrigen;
    private int verticeDestino;
    private T etiqueta;

    public Arco(int verticeOrigen,int verticeDestino,T etiqueta){
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getEtiqueta() {
        return etiqueta;
    }
    public boolean equals(Object o){//verificar si anda cuando te pasan un null
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Arco otro= (Arco) o;
        return  (otro.getVerticeOrigen()==this.verticeOrigen) && (otro.getVerticeDestino()==this.getVerticeDestino());
    }

}
