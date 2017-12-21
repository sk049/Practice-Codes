package com.salil.algorithms.backtracking;

/**
 * Created by Salil on 29/08/17.
 */
public class RatMaze {

    static int N=4;

    public void printSolution(int sol[][]){
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    public boolean isSafe(int x,int y,int maze[][]){
        return (x>=0 && x<N && y>=0 && y<N && maze[x][y]==0);
    }

    public void solveMaze(int maze[][]){
        int sol[][]={{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        sol[0][0]=1;

        if(!solveMazeUtil(0,0,sol,maze))
            System.out.println("Solution is not Possible");
        else
            printSolution(sol);
    }

    public boolean solveMazeUtil(int x,int y,int sol[][],int maze[][]){
        if(x==N-1 && y==N-1){
            sol[x][y]=1;
            return true;
        }
        if(isSafe(x+1,y,maze)){
            sol[x+1][y]=1;
           if(solveMazeUtil(x+1,y,sol,maze)){
               return true;
           }
           else
               sol[x+1][y]=0;
        }

        if(isSafe(x,y+1,maze)){
            sol[x][y+1]=1;
            if(solveMazeUtil(x,y+1,sol,maze)){
                return true;
            }
            else
                sol[x][y+1]=0;
        }
        return false;
    }

    public static void main(String[] args){
        RatMaze rat = new RatMaze();
        int maze[][] = {
                {0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}};
        rat.solveMaze(maze);

    }
}
