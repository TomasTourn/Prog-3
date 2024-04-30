package TP_2.Ejercicio1;

import java.net.StandardSocketOptions;
import java.sql.SQLOutput;

public class IsTheArraySorted {

    public static void main(String[]Args){

        int[] arr={4,1,6,7,2,7,4,2};

        System.out.println(isSorted(arr,0));

    }

    public static boolean isSorted(int[] arr,int index){

        if(index >= arr.length){//if index equals the lenght it means that the recursive function got till the end and is certain that the array is sorted
            return true;
        } else if (arr[index]>arr[index+1]) {
            return false;
        }
        return isSorted(arr,index+1);
    }

}
