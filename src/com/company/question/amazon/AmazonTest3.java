package com.company.question.amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class AmazonTest3 {

    static class Pair{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int minimumDays(int rows, int columns, ArrayList<ArrayList<Integer>> grid)
    {
        HashSet<Pair> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> grid1 = cloneList(grid);
        int size = 0;
        int numOfDays=0;
        returnSizeOfSet(set,grid);

        while(true){
            size = returnSizeOfSet(set,grid);

            for(int i=0;i<grid1.size();i++){
                for(int j=0;j<grid1.get(0).size();j++){
                    if(i-1>=0 && grid1.get(i-1).get(j)==1 && grid1.get(i).get(j)==0){
                        ArrayList<Integer> list = grid.get(i);
                        list.set(j,1);
                        grid.set(i,list);
                        set.remove(new Pair(i,j));
                    }else if(i+1<rows && grid1.get(i+1).get(j)==1 && grid1.get(i).get(j)==0){
                        ArrayList<Integer> list = grid.get(i);
                        list.set(j,1);
                        grid.set(i,list);
                        set.remove(new Pair(i,j));
                    }else if(j+1<columns && grid1.get(i).get(j+1)==1 && grid1.get(i).get(j)==0){
                        ArrayList<Integer> list = grid.get(i);
                        list.set(j,1);
                        grid.set(i,list);
                        set.remove(new Pair(i,j));
                    }else if(j-1>=0 && grid1.get(i).get(j-1)==1 && grid1.get(i).get(j)==0){
                        ArrayList<Integer> list = grid.get(i);
                        list.set(j,1);
                        grid.set(i,list);
                        set.remove(new Pair(i,j));
                    }
                }
            }

            numOfDays++;
            if(set.size()==0){
                break;
            }

            if(size==set.size()){
                numOfDays=-1;
                break;
            }
            grid1 = cloneList(grid);
        }

        return numOfDays;
    }

    static ArrayList<ArrayList<Integer>> cloneList(ArrayList<ArrayList<Integer>> grid){
        ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
        for(int i=0;i<grid.size();i++){
            ArrayList<Integer> list = new ArrayList<>(grid.get(i));
            grid1.add(list);
        }
        return grid1;
    }


    static int returnSizeOfSet(HashSet<Pair> set,ArrayList<ArrayList<Integer>> grid){
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                if(grid.get(i).get(j)==0){
                    set.add(new Pair(i,j));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] a){
        //int mat[][] = new int[][]{{0,1,1,0,1},{0,1,0,1,0},{0,0,0,0,1},{0,1,0,0,0}};
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>(List.of(new ArrayList<Integer>(List.of(0,1,1,0,1)),new ArrayList<Integer>(List.of(0,1,0,1,0)),new ArrayList<Integer>(List.of(0,0,0,0,1)),new ArrayList<Integer>(List.of(0,1,0,0,0))));
        //ArrayList<ArrayList<Integer>> grid = new ArrayList<>(List.of(new ArrayList<Integer>(List.of(1,0,0,0,0)),new ArrayList<Integer>(List.of(0,1,0,0,0)),new ArrayList<Integer>(List.of(0,0,1,0,0)),new ArrayList<Integer>(List.of(0,0,0,1,0)),new ArrayList<Integer>(List.of(0,0,0,0,1))));
        //ArrayList<ArrayList<Integer>> grid = new ArrayList<>(List.of(new ArrayList<Integer>(List.of(0,0,1,0,0,0)),new ArrayList<Integer>(List.of(0,0,0,0,0,0)),new ArrayList<Integer>(List.of(0,0,0,0,0,1)),new ArrayList<Integer>(List.of(0,0,0,0,0,0)),new ArrayList<Integer>(List.of(0,1,0,0,0,0))));

        /*int mat[][] = new int[grid.size()][grid.get(0).size()];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(0).size();j++){
                mat[i][j]=grid.get(i).get(j);
            }
        }*/
        //minimumDays(grid.size(),grid.get(0).size(),mat);
       int ans = minimumDays(grid.size(),grid.get(0).size(),grid);
       System.out.println(ans);
    }
}
