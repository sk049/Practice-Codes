package com.salil.arrays;

/**
 * Created by Salil on 01/09/17.
 */
public class PivotElement {

    static int size = 10;

    public void pivot(int arr[],int l,int r){
        int mid = l+(r-l)/2;
        if(l<=r){
            if(arr[mid-1]>arr[mid] && arr[mid+1]>arr[mid]){
                System.out.println("Pivot : "+mid);
                return;
            }
            if(arr[mid-1]<=arr[mid] && arr[mid]<arr[mid+1]){
                pivot(arr,l,mid-1);
            }
            else
                pivot(arr,mid+1,r);
        }

    }


    public static void main(String[] args){
        int arr[] = {10,9,1,2,3,4,5,6,7,8};
        int len = arr.length;
        PivotElement object = new PivotElement();
        object.pivot(arr,0,len-1);

    }

}
