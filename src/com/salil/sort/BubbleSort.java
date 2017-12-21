package com.salil.sort;

/**
 * Created by Salil on 17/05/17.
 */


/*
* InPlace & Stable
* Used in Computer graphics
* O(n^2)
* */
public class BubbleSort {

public static void bubbleSrt(int arr[]){
    int n = arr.length;
    boolean swapped = false;
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1-i;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                swapped = true;
            }
        }
        if(swapped == false){
            break;
        }
    }
}

public static void printArray(int arr[]){
    for(int i =0 ;i<arr.length;i++){
        System.out.print(arr[i]+ "\t");
    }
    System.out.println();
}

public static void main(String args[]){
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    System.out.println("Array is : ");
    printArray(arr);
    System.out.println("Array after sorting is : ");
    bubbleSrt(arr);
    printArray(arr);
}

}
