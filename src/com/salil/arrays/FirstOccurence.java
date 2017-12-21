package com.salil.arrays;

/**
 * Created by B0097044 on 01/09/17.
 */
public class FirstOccurence {

    public void first(int arr[],int l,int r,int num, int size){
        if(l<=r){
            int mid = l+(r-l)/2;
            if((mid==0 || arr[mid-1]<num)  && arr[mid]==num){
                System.out.println("First Occurrence = "+mid);
                return ;
            }
            if(arr[mid]==num && arr[mid-1]==num)
               first(arr,l,mid-1,num,size);
            if(arr[mid]<num){
                first(arr,mid+1,r,num,size);
            }
            if(arr[mid]>num)
                first(arr,l,mid-1,num,size);
        }
    }

    public void last(int arr[],int l,int r,int num, int size){
        if(l<=r){
            int mid = l+(r-l)/2;
            if((mid==size-1 || arr[mid+1]>num) && arr[mid]==num ){
                System.out.println("Last Occurrence = "+mid);
                return ;
            }
            if(arr[mid]==num && arr[mid+1]==num)
                last(arr,mid+1,r,num,size);
            if(arr[mid]<num){
                last(arr,mid+1,r,num,size);
            }
            if(arr[mid]>num)
                last(arr,l,mid-1,num,size);
        }
    }

    public static void main(String[] args){

        int arr[] = {1, 1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int n = arr.length;
        int x = 1;
        FirstOccurence obj = new FirstOccurence();
        obj.first(arr, 0, n-1, x, n);
        obj.last(arr, 0, n-1, x, n);

    }
}
