package com.salil.numberTheory;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import sun.jvm.hotspot.utilities.IntegerEnum;

/**
 * Created by B0097044 on 18/03/18.
 */
public class SieveOfEratosthenes {

    static int N= 100;

    public static void main(String [] args){
        int[] primes = new int[N+1];
        for(int i=0 ; i<=N;i++){
            primes[i]=1;
        }

        primes[0]=0;
        primes[1]=0;
        for(int i=2; i<Math.sqrt(N);i++){
            if(primes[i]==1){
                for (int j=2;i*j<=N;j++){
                    primes[i*j]=0;
                }
            }
        }
        for(int i=0;i <= N;i++){
            if(primes[i]==1)
                System.out.print(i+" , ");
        }
    }

}
