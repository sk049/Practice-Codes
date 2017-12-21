package com.salil.arrays;

/**
 * Created by B0097044 on 11/09/17.
 */
public class Seasons {

    static int seasons=4;

    public void solveSeasons(int arr[],int len){
        int result[] = new  int[seasons];
        System.out.println(len);
        if(len%4!=0){
            System.out.println("Enter Valid Length");
            return;
        }
        int n =len/4;
        System.out.println(n);
       int i=0;
       int j=0;
       while (i<len && j<seasons){
           int temp[] = new int[n-2];
           int k=i;
           for(int track=0;track<n-2;track++){
               temp[track]=arr[k+1]-arr[k];
               k+=2;
           }
           result[j]=temp[max(temp)];
           j++;
           i+=n;
       }
        System.out.println("Result : "+ max(result));
    }

    public int max(int arr[]){
        int l1=arr.length;
        int max=0;
        for(int i=1;i<l1;i++){
            if(arr[i]>arr[max])
                max=i;
        }
        return max;
    }

    public static void main(String[] args){
        //int arr[] = {2,-1,4,6,8,-2,4,6};
        int arr[] = {4,-2,-8,1,-2,1,0,-8,2,-6,5,1,3,4,2,8};
        int len = arr.length;
        Seasons obj = new Seasons();
        obj.solveSeasons(arr,len);
    }
}
