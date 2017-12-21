package com.salil.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Salil on 06/09/17.
 */
public class SmallerFrom2Arrays {

    public void solution(int a[],int b[]){
        int l1 = a.length;
        int l2 = b.length;
        Arrays.sort(a);
        Arrays.sort(b);
        int j=0;
        for(int i=0;i<l1;i++){
            if(j<l2-1 && a[i]>b[j])
                j +=1 ;
            if(a[i]==b[j]){
                System.out.println(a[i]);
                return;
            }
        }
    }
    public static void main(String[] args){
        int a[] = {1,2,3,3};
        int b[] = {3,5,4,5,7};
        SmallerFrom2Arrays obj = new SmallerFrom2Arrays();
        obj.solution(a,b);

    }

}
