package com.salil.algorithms.dynamicprogramming;


/**
 * Created by Salil on 21/09/17.
 */
public class Fibonnaci {

    final int MAX = 100;
    final int NIL = -1;
    int lookup[] = new int[MAX];

    public int fibByRecursion(int num ){
        if(num<=1)
            return num;

        return fibByRecursion(num-1)+fibByRecursion(num-2);

    }


    public int fibWithSpaceOptimiZation(int num){
        int a=0,b=1,c;
        if(num==0)
            return a;

        for(int i=2;i<=num;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

    public void power(int F[][], int n){
        int i;
        int M[][]= new int[][]{{1,1},{1,0}};
        for(i=2;i<=n;i++)
            multiplyMatrix(F,M);
    }

    public void multiplyMatrix(int F[][],int M[][]){
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];

        F[0][0] = x;
        F[0][1] = y;
        F[1][0] = z;
        F[1][1] = w;

    }

    public int fibByMatrix(int  n){
        int F[][] = new int[][]{{1,1},{1,0}};
        if(n==0)
            return 0;

        power(F,n-1);

        return F[0][0];

    }

    public void initializeLookUpTable(){
        for(int i=0;i<MAX;i++){
            lookup[i]=NIL;
        }
    }

    public int normalFibByTabulation(int num ){
        int f[] = new int[num+1];
        f[0]=0;
        f[1]=1;

        for (int i=2;i<=num;i++){
            f[i]=f[i-1]+f[i-2];
        }

        return f[num];
    }

    public int fibByMemoization(int n){
        if(lookup[n]==NIL){
            if(n<=1)
                return lookup[n]=n;
            else
                lookup[n]=fibByMemoization(n-1)+fibByMemoization(n-2);
        }
        return lookup[n];
    }

    public static void main(String args[]){
        Fibonnaci object = new Fibonnaci();
        System.out.println(object.fibByRecursion(9));
        System.out.println("Fib By Tabulation : "+object.normalFibByTabulation(40));
        System.out.println("DP With Space Optimization : "+object.fibWithSpaceOptimiZation(9));
        System.out.println("With Matrix : "+object.fibByMatrix(9));
        object.initializeLookUpTable();
        System.out.println("Fib By Memoization : "+object.fibByMemoization(40));
    }

}
