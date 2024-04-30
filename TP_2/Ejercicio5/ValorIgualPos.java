package TP_2.Ejercicio5;

public class ValorIgualPos {

    public static boolean valorIgualPos(int[]arr,int pos){


        if(pos>= arr.length) {
            return false;
        } else if (arr[pos]==pos) {
            return true;
        }
        else {
            return valorIgualPos(arr,pos+1);
        }
    }

    public static void main(String[] args) {

        int[] arr={-3, -1, 0, 2, 4, 6, 10};
        System.out.println(valorIgualPos(arr,0));



    }

}
