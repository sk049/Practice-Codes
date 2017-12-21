package com.salil.sort;

/**
 * Created by Salil on 17/05/17.
 */


/*
* InPlace & Stable
* Used when number of elements is small
* It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
* O(n^2)
* */
public class InsertionSort {
    public static void insertionSort(int arr[]){
        int n = arr.length;
        for(int i=1;i<n;i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void printArray(int arr[]){
        for(int i =0 ;i<arr.length;i++){
            System.out.print(arr[i]+ "\t");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {12, 11, 13, 5, 6};
        System.out.println("Array is : ");
        printArray(arr);
        System.out.println("Array after sorting is : ");
        insertionSort(arr);
        printArray(arr);
    }

}
