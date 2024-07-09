package Backtracking.BackParcial;

import java.util.LinkedList;
import java.util.List;

public class BacktrackingParcial {

    List<String> palabras; //solucion
    Diccionario diccionario;

    public List<String>back(List<String> letras){
        palabras=new LinkedList<>();
        String palabra= new String();
        encontrarPalabras(palabras,palabra);
        return palabras;
    }

    private void encontrarPalabras(List<String>letras,String palabra){

        if (palabra.length()==4){
            if (diccionario.esPalabraValida(palabra)){
                palabras.add(palabra);
            }
        }
        else {
            for (String letra:letras) {
                if (palabra.length()!=0 ||(palabra.length()==0 &&!diccionario.esVocal(letra))){//si no es la primer letra o es la primera y no es vocal

                    if (!palabra.contains(letra)){
                        palabra+=letra;
                        if (!poda(palabra)){
                            encontrarPalabras(letras,palabra);
                        }
                        palabra.removeLast();
                    }

                }
            }


        }


    }


}
