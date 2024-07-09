package Backtracking.BackCaballo;

public class BackCaballo {

    Recorrido recorridoDeAtila;

    public Recorrido back(Casilla origen){
        Recorrido recorridoParcial=new Recorrido();
        recorridoParcial.agregarAlRecorrido(origen);
        recorridoParcial.noTienePasto(origen);
        backtracking(origen,recorridoParcial);
        return recorridoDeAtila;
    }
    
    private void backtracking(Casilla actual,Recorrido recorridoActual){

        if ()


    }



}
