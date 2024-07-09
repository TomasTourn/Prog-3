package TP_Arboles.Ejercicio1;

public class ComparadorArboles {

    private Tree arbol1;
    private Tree arbol2;

    public ComparadorArboles(Tree arbol1, Tree arbol2) {
        this.arbol1 = arbol1;
        this.arbol2 = arbol2;
    }


    //tengo que recibir 2 arboles e ir comparandolos
    //si el nodo actual tiene los mismos hijos por ahora es igual
    //

    public Tree getArbol1() {
        return arbol1;
    }

    public Tree getArbol2() {
        return arbol2;
    }
}
