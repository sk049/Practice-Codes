package com.salil.javaBasics;

import java.util.Scanner;

/**
 * Created by B0097044 on 23/08/17.
 */
public class PrimeNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t!=0){
            int num = sc.nextInt();
            if(isPrime(num)){
                System.out.println("PRIME");
            }
            else{
                System.out.println("NOT PRIME");
            }
            t--;
        }
    }

    public static boolean isPrime(int num ){
        if(num<2){
            return false;

        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }



}
