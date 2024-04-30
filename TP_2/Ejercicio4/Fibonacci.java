package TP_2.Ejercicio4;

public class Fibonacci {

    public static int fibonacci(int num){
        if(num==0 || num==1){
            return num;
        }else {
            return fibonacci(num-1)+fibonacci(num-2);
        }
    }

    public static void main(String[] args) {
        int N = 9;
        System.out.println("Los " + N + " primeros términos de la secuencia de Fibonacci son:");
        for (int i = 0; i < N; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

}
