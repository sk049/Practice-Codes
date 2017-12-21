package com.salil.algorithms.backtracking;

/**
 * Created by Salil on 15/09/17.
 */
public class Sudoku {

    static int N=9;

    static class Cell{
        int row;
        int col;
        Cell(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public Cell getNextCell(Cell cur){
        int col = cur.col;
        int row = cur.row;
        col++;
        if(col>8){
            row++;
            col=0;
        }
        if(row>8)
            return null;
        Cell next = new Cell(row,col);
        return next;
    }


    public boolean usedInCol(int grid[][],int col,int num){
        for(int i=0;i<N;i++){
           if( grid[i][col]==num)
               return true;
        }
        return false;
    }

    public boolean usedInRow(int grid[][],int row,int num){
        for(int i=0;i<N;i++){
            if(grid[row][i]==num)
                return true;
        }
        return false;
    }

    public boolean usedInBox(int grid[][],int rowStart,int colStart,int num){
        for(int row =0;row<3;row++)
            for (int col =0;col<3;col++){
                if(grid[row+rowStart][col+colStart]==num)
                    return true;
            }
            return false;
    }

    public boolean isSafe(int grid[][],Cell curr,int num){
        Boolean isUsedInRow = !usedInRow(grid, curr.row, num);
        Boolean isUsedInCol = !usedInCol(grid, curr.col, num);
        Boolean isUsedInGrid = !usedInBox(grid, curr.row - curr.row%3 , curr.col - curr.col%3, num);
        return isUsedInRow&&isUsedInCol&&isUsedInGrid;
    }

    public boolean isSolveSudoku(int grid[][],Cell curr){
        if(curr==null){
            return true;
        }
        if (grid[curr.row][curr.col]!=0){
            return isSolveSudoku(grid,getNextCell(curr));
        }
        for(int num = 1;num<=9;num++){
            boolean valid = isSafe(grid,curr,num);
            if(!valid)
                continue;
            grid[curr.row][curr.col]=num;
            if(isSolveSudoku(grid,getNextCell(curr)))
                return true;
            grid[curr.row][curr.col]=0;
        }
        return false;
    }

    public void printGrid(int grid[][]){
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int grid[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, //
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, //
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, //
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, //
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, //
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, //
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, //
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, //
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        Sudoku object = new Sudoku();
        if(object.isSolveSudoku(grid,new Cell(0,0))){
            object.printGrid(grid);
        }
        else
            System.out.println("No Solution");

    }


}
