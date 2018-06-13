package com.salil.binarySearch;

/**
 * Created by Salil on 19/03/18.
 */
public class BinarySearch {

    public static void main(String[] args){
        int[] array = new int[]{2,4,10,10,10,18,20};
        BinarySearch object = new BinarySearch();
       // System.out.println(array.length);
        int pos = object.IterativeBinarySearch(array,array.length,2);
        System.out.println(pos);
    }

    public int BinarySearchFirstOccurence(int[] a,int n,int x){
        int low;

        return -1;
    }

    public int IterativeBinarySearch(int[] a,int n,int x){
        int low =0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(x==a[mid]){
                return mid+1;
            }
            else if(x<a[mid]){
                high = mid-1;
            }
            else if(x>a[mid])
                low = mid+1;
        }
        return -1;
    }

    public int ReccursiveBinarySearch(int[] a,int l, int h, int n,int x){
        if(l<0 || h>=n)
        return -1;


        return -1;
    }

}
