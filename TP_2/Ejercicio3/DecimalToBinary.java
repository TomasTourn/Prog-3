package TP_2.Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class DecimalToBinary {

        List<Integer>binary;

    public DecimalToBinary() {
        binary=new ArrayList<>();
    }


    public List<Integer> decimalToBinary(int num){

        if (num<=0){
            return new ArrayList<>();
        }
        if(num>0){
            binary.add(num%2);
        }
        return decimalToBinary(num/2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < binary.size(); i++) {
            sb.append(binary.get(i));
            if (i < binary.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
