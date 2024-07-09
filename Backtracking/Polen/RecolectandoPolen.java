package Backtracking.Polen;

import java.util.Iterator;

public class RecolectandoPolen {

    Solucion mejorSolucion;
    Jardin jardin;
    int distMaxima;

    public RecolectandoPolen(Jardin jardin,Coordenada posAbeja,int distMaxima) {
        this.mejorSolucion = null;
        this.jardin=jardin;
        Estado inicial =new Estado(0,posAbeja);
        this.distMaxima=distMaxima;
    }

    public void back(Estado e){

        if (e==null || e.visiteMaxFlores() || jardin.floresCercanas(e.getPosAbeja(),distMaxima).isEmpty()){//estado final, pase por 5 flores o no tengo flores cercanas para visitar

            if (mejorSolucion.cantPolen<e.getCantPolen()){//operar solucion, comparar si la solucion actual es mejor a mi mejor solucion
                mejorSolucion.copiar(e);
            }
        }
        else {
            Iterator<Flor> it=  jardin.floresCercanas(e.posAbeja,distMaxima).iterator();
                while (it.hasNext()){


                    Flor florSiguiente=it.next();
                    if (!e.getFloresVisitadas().contains(florSiguiente)){//avanzo en el camino de la abeja, la muevo le agrego polen y marco la flor como visitada
                        Coordenada posAbeja=e.getPosAbeja();//guardo para volver a la abeja a su posicion anterior despues
                        e.addFlorVisitada(florSiguiente);
                        e.moverAbeja(florSiguiente.getCoordenada());
                        e.agregarPolen(florSiguiente.getCantPolen());

                        back(e);

                        e.moverAbeja(posAbeja);
                        e.quitarPolen(florSiguiente.getCantPolen());
                        e.quitarFlorVisitada(florSiguiente);

                    }


                }
        }



    }



}
