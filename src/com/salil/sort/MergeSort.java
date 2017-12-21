package com.salil.sort;

/**
 * Created by Salil on 18/05/17.
 */

/*
* Stable and not typical in place
* used in linked list
* O(nlogn)
* */
public class MergeSort {
    public static void merge(int arr[],int l,int m,int r){
        int i,j,k,n1,n2;
        n1= m-l+1;
        n2=r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(i=0;i<n1;i++){
            L[i]=arr[l+i];
        }
        for(j=0;j<n2;j++){
            R[j]=arr[m+1+j];
        }
        i=0;
        j=0;
        k=l;
        while (i<n1 && j<n2 ){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else {
                arr[k]=R[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int arr[],int l,int r){
        if(l<r){
            int mid = l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
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
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
    }
}
