package com.salil.revision;

/**
 * Created by B0097044 on 08/03/18.
 */
public class RevisionRatMaze {
    static int N=4;
    public void printSolution(int sol[][]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                System.out.print(sol[i][j]+"  ");
            System.out.println();
        }
    }

    public boolean isSafe(int x, int y, int maze[][]){
        return (x>=0 && x<N && y>=0 && y<N && maze[x][y]==1);
    }

    public boolean solveMazeUtil(int x,int y,int sol[][],int maze[][]){
        if(x==N-1 && y==N-1){
            sol[x][y]=5;
            return true;
        }
        if(isSafe(x+1,y,maze)){
            sol[x+1][y]=5;
            if(solveMazeUtil(x+1,y,sol,maze))
                return true;
            else
                sol[x+1][y]=0;
        }
        if(isSafe(x,y+1,maze)){
            sol[x][y+1]=5;
            if(solveMazeUtil(x,y+1,sol,maze))
                return true;
            else
                sol[x][y+1]=0;
        }

         return false;
    }

    public void solveMaze(int maze[][]){
        int sol[][]={{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        sol[0][0]=5;

        if(!solveMazeUtil(0,0,sol,maze))
            System.out.println("Solution is not Possible");
        else
            printSolution(sol);

    }

    public static void main(String [] args){
        int maze[][]={{1,1,1,1},
                      {1,0,1,1},
                      {0,1,0,1},
                      {1,1,1,1}};

        RevisionRatMaze ob = new RevisionRatMaze();
        ob.solveMaze(maze);
    }

}
