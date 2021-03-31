package com.datastructure.matrix;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    static void solve(int[][] grid,int n){
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

//        if(solveUtil(grid,row.toArray(Integer[]::new),col.toArray(Integer[]::new),0)){
//            printBoard(grid,n);
//        }else{
//            System.out.println("Not possible");
//        }
        if(solveUtil(grid,row.stream().toArray(Integer[]::new),col.stream().toArray(Integer[]::new),0)){
            printBoard(grid,n);
        }else{
            System.out.println("Not possible");
        }
    }

    static void printBoard(int[][] grid,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    static boolean solveUtil(int[][] grid,Integer[] row,Integer[] col,int pos){

        if (pos==row.length){
            return true;
        }

        for(int i=1;i<=9;i++){
            if(isSafe(grid,row[pos],col[pos],i)){
                grid[row[pos]][col[pos]] = i;

                if(solveUtil(grid,row,col,pos+1)){
                    return true;
                }

                grid[row[pos]][col[pos]] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int[][] grid, int row, int col, int val){
        int rowStart = row/3 *3;
        int rowEnd = rowStart + 3;
        int colStart = col/3 *3;
        int colEnd = colStart + 3;

        for(int i=rowStart;i<rowEnd;i++){
            for(int j=colStart;j<colEnd;j++){
                if(grid[i][j]==val){
                    return false;
                }
            }
        }

        for(int i=0;i<9;i++){
            if(grid[row][i]==val){
                return false;
            }
        }

        for(int i=0;i<9;i++){
            if(grid[i][col]==val){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] a){
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solve(grid,grid.length);
    }
}
