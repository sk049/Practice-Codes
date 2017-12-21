package com.salil.algorithms.backtracking;

/**
 * Created by Salil on 30/08/17.
 */
public class NumberOfWays {
    static int R = 4;
    static int C = 4;
    public int getNumberOfPaths(int maze[][]){
        int i,j;
        if(maze[0][0]==-1)
            return 0;
        for(i=0;i<R;i++){
            if(maze[i][0]==0)
                maze[i][0]=1;
            else
                break;
        }
        for(j=1;j<C;j++){
            if(maze[0][j]==0)
                maze[0][j]=1;
            else
                break;
        }
        for(i=1;i<R;i++){
            for(j=1;j<C;j++){
                if(maze[i][j]==-1)
                   continue;
                if(maze[i-1][j]>0)
                    maze[i][j]=maze[i-1][j]+maze[i][j];
                if(maze[i][j-1]>0)
                    maze[i][j]=maze[i][j-1]+maze[i][j];
            }
        }
        return maze[R-1][C-1]>0?maze[R-1][C-1]:0;
    }

    public static void main(String[] args){
        int maze[][] =  {
                {0,  0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0,  0, 0, 0}};
        NumberOfWays obj = new NumberOfWays();
        System.out.println(obj.getNumberOfPaths(maze));
    }
}
