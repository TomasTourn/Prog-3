package Backtracking.CombinacionesSuma;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int n =4;
        ArrayList<Integer>numeros=new ArrayList<>();

        combinacionesSuma(n,numeros,0);


    }

    public static void combinacionesSuma(int n,ArrayList numeros,int suma){

        if (n==suma){
            System.out.println(numeros);
        }
        else {
            for(int i=1;i<=n;i++){
                 suma+=i;
                 if (suma<=n){
                     numeros.add(i);
                     combinacionesSuma(n,numeros,suma);
                     numeros.remove(numeros.indexOf(i));
                 }
                 suma-=i;
            }
        }


    }


}
