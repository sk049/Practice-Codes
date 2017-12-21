package com.salil.examples;

/**
 * Created by B0097044 on 02/10/17.
 */
public class GreatestNumber {

    public int graetest(int a,int b,int c){

        if(a>b){
            if(a>c)
                return a;}
            else{
        if(b>a)
            if(b>c)
                return b;}
        return c;

    }

    public static void main(String args[]){
        GreatestNumber object = new GreatestNumber();
        int ans = object.graetest(5678,89,687);
        System.out.println(ans);

    }
}


