package com.salil.algorithms.backtracking;

/**
 * Created by Salil on 29/08/17.
 */
public class NQueenProblem {

    static int N=8;

    public void printSolution(int sol[][]){
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }


    public void solveNQ(){
        int i,j;
        int board[][] = new int[N][N];
        for(i=0;i<N;i++)
            for(j=0;j<N;j++)
                board[i][j]=0;
        if(!solveNQUtil(board,0))
            System.out.println("No Solution exists");
        else
            printSolution(board);
    }

    public boolean isSafe(int board[][],int col,int row){
        int i,j;
        for(i=0;i<col;i++)
            if(board[row][i]==1)
                return false;
        for(i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1)
                return false;
        }
        for(i=row,j=col;i<N && j>=0;i++,j--){
            if(board[i][j]==1)
                return false;
        }
        return true;
    }

    public boolean solveNQUtil(int board[][],int col){
        if(col>=N)
            return true;
        for(int i=0;i<N;i++){
            if(isSafe(board,col,i)){
                board[i][col]=1;
                if(solveNQUtil(board,col+1))
                    return true;
                board[i][col]=0;
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}
