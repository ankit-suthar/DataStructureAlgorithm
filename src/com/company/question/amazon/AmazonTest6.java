package com.company.question.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AmazonTest6 {

    static class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> grid, int row, int column, boolean visited[][]){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row,column));
        int rows = grid.size();
        int columns = grid.get(0).size();

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            visited[p.i][p.j]=true;

            if(row-1>=0 && grid.get(row-1).get(column)==1 && grid.get(row-1).get(column)==1 && !visited[row-1][column]){
                queue.add(new Pair(row-1,column));
            }

            if(row+1<rows && grid.get(row+1).get(column)==1 && grid.get(row+1).get(column)==1 && !visited[row+1][column]){
                queue.add(new Pair(row+1,column));
            }

            if(column+1<columns && grid.get(row).get(column+1)==1 && grid.get(row).get(column+1)==1 && !visited[row][column+1]){
                queue.add(new Pair(row,column+1));
            }

            if(column-1>=0 && grid.get(row).get(column-1)==1 && grid.get(row).get(column-1)==1 && !visited[row][column-1]){
                queue.add(new Pair(row,column-1));
            }
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
                    bfs(grid,i,j,visited);
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
