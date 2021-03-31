package com.company.question.amazon;

import java.util.*;

public class AmazonTest5 {

    static void dfs(ArrayList<ArrayList<Integer>> grid, int row, int column, boolean visited[][]){
        visited[row][column]=true;

        int rows = grid.size();
        int columns = grid.get(0).size();

        if(row-1>=0 && grid.get(row-1).get(column)==1 && grid.get(row-1).get(column)==1 && !visited[row-1][column]){
            dfs(grid,row-1,column,visited);
        }

        if(row+1<rows && grid.get(row+1).get(column)==1 && grid.get(row+1).get(column)==1 && !visited[row+1][column]){
            dfs(grid,row+1,column,visited);
        }

        if(column+1<columns && grid.get(row).get(column+1)==1 && grid.get(row).get(column+1)==1 && !visited[row][column+1]){
            dfs(grid,row,column+1,visited);
        }

        if(column-1>=0 && grid.get(row).get(column-1)==1 && grid.get(row).get(column-1)==1 && !visited[row][column-1]){
            dfs(grid,row,column+1,visited);
        }
    }

    static int numberAmazonGoStores(int rows, int columns, ArrayList<ArrayList<Integer>> grid)
    {
        // WRITE YOUR CODE HERE
        /*ArrayList<ArrayList<Integer>> grid = new ArrayList<>();

        for(int i=0;i<grid2.size();i++){
            ArrayList<Integer> al = new ArrayList(grid2.get(i));
            grid.add(al);
        }*/
        boolean visited[][] = new boolean[rows][columns];
        int count = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid.get(i).get(j)==1 && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] a) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>(List.of(new ArrayList<Integer>(List.of(1, 1, 0, 0)), new ArrayList<Integer>(List.of(0, 0, 0, 0)), new ArrayList<Integer>(List.of(0, 0, 1, 1)), new ArrayList<Integer>(List.of(0, 0, 0, 0))));

        int ans = numberAmazonGoStores(grid.size(), grid.get(0).size(), grid);
        System.out.println(ans);
    }
}
