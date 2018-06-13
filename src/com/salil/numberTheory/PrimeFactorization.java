package com.salil.numberTheory;

import java.util.Scanner;

/**
 * Created by Salil on 18/03/18.
 */
public class PrimeFactorization {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer n = 22;//sc.nextInt();
        Integer ctr;

        for(int i=2; i<= Math.sqrt(n);i++ ){
            if(n%i==0){
                ctr=0;
                while(n%i==0){
                    n=n/i;
                    ctr++;
                }
                System.out.println(i+"^"+ctr);
            }
        }
        if(n!=1){
            System.out.println(n+"^"+1);
        }

    }

}
