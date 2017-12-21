package com.salil.sort;

/**
 * Created by Salil on 19/05/17.
 */

/*
* InPlace
* Quick Sort is also a cache friendly sorting algorithm as it has good locality of reference when used for arrays.
* */
public class QuickSort {

    public static int partition(int arr[],int low,int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j = low ; j<= high-1;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;
        return i+1;
    }

    public static void quickSort(int arr[],int low,int high){
        if(low<high){
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void printArray(int arr[]){
        for(int i =0 ;i<arr.length;i++){
            System.out.print(arr[i]+ "\t");
        }
        System.out.println();
    }

    public static void main(String args[]){
        //int arr[] = {10, 7, 1, 9, 3, 8};
        int arr[] = {9121, 8137, 7148, 6159, 5163, 4178};
        System.out.println("Array is : ");
        printArray(arr);
        System.out.println("Array after sorting is : ");
        quickSort(arr,0,arr.length-1);
        printArray(arr);
    }
}
