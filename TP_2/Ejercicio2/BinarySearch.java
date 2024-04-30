package TP_2.Ejercicio2;

public class BinarySearch {

    public static void main(String[] args) {
        int [] arr ={1,2,3,4,5,6,7,8,9,10};
        int target = 3;
        int index = binarySearch(arr,target,0, arr.length);

        if (index != -1) {
            System.out.println("The target " + target + " index is  " + index);
        } else {
            System.out.println("The target " + target + " is not present in the array");
        }
    }

    public static int binarySearch(int [] arr, int target, int left,int right) {//it only works on sorted arrays

        int mid =  left + (right-left) / 2;//array is divided in half, it will go left or right depending on the parameters we pass (check next ifs)

        System.out.println("looking for "+ target +" on index " + mid);

        if(arr[mid]==target){
            System.out.println("target found" + " at index " + mid);
            return mid;
        } else if (arr[mid]>target) {
            return binarySearch(arr,target,left,mid-1);
        }else {
            return binarySearch(arr,target,mid+1,right);
        }

    }

}
