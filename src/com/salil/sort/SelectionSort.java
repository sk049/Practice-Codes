package com.salil.sort;

/**
 * Created by Salil on 17/05/17.
 */

/*
* InPlace & UnStable
* Used when write operation is costly ,As it takes minimum n swaps
* O(n^2)
* */
public class SelectionSort {
    public static void selectionSort(int arr[]){
        int n = arr.length;
        for(int i=0 ; i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int min = i;
                if(arr[j]<arr[min]){
                    min=j;
                }
               int temp = arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
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
        selectionSort(arr);
        printArray(arr);
    }

}
