package com.salil.algorithms.backtracking;

/**
 * Created by Salil on 29/08/17.
 */
public class KnightTour{
    static int N=8;

    public static void printSolution(int sol[][]){
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    public void solveKT(){
        int sol[][] = new int[8][8];

        for(int i=0;i<N;i++)
            for (int j=0;j<N;j++)
                sol[i][j]=-1;

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0]=0;

        if (!solveKTUtil(0, 0,sol, 1, xMove, yMove))
            System.out.println("Solution does not exist");
        else
            printSolution(sol);

    }

    public boolean solveKTUtil(int x,int y,int sol[][],int movei,int xMove[],int yMove[]){
        int k,next_x,next_y;

        if (movei == N * N)
            return true;

        for(k=0;k<N;k++){
            next_x=x+xMove[k];
            next_y=y+yMove[k];
            if(isSafe(next_x,next_y,sol)){
                sol[next_x][next_y]=movei;
                if(solveKTUtil(next_x,next_y,sol,movei+1,xMove,yMove))
                    return true;
                else
                    sol[next_x][next_y]=-1;
            }
        }
        return false;
    }

    public boolean isSafe(int x, int y, int sol[][]){
        return (x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1);
    }

    public static void main(String[] args){
        KnightTour ob = new KnightTour();
        ob.solveKT();
    }

}




