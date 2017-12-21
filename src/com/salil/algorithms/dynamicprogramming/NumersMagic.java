package com.salil.algorithms.dynamicprogramming;

/**
 * Created by B0097044 on 24/09/17.
 */
public class NumersMagic {

    public static final int MAXN=100;
    public static final int NIL = -1;

    int lookUp[]= new int[MAXN];

    public void inntialiazeLookUpTable(){
        for(int i=0;i<MAXN;i++){
            lookUp[i]=NIL;
        }
    }

    public int solve(int n){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        return solve(n-1)+solve(n-3)+solve(n-5);
    }

    public int solveByMemoization(int n){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(lookUp[n]!=NIL)
            return lookUp[n];
        return lookUp[n]=solveByMemoization(n-1)+solveByMemoization(n-3)+solveByMemoization(n-5);

    }

    public static void main(String args[]){
        NumersMagic object = new NumersMagic();
        int result = object.solve(7);
        System.out.println(result);
        object.inntialiazeLookUpTable();
        System.out.println(object.solveByMemoization(7));
    }

}
