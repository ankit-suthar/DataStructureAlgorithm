package com.company.question.amazon;

import java.util.*;

public class AmazonTest2 {

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

    static int minimumDays(int rows, int columns, int[][] mat /*List<List<Integer>> grid*/)
    {
        HashSet<Pair> set = new HashSet<>();
        /*List<List<Integer>> grid1 = cloneList(grid);*/
        int[][] mat1 = cloneList(mat);
        int size = 0;
        int numOfDays=0;
        //returnSizeOfSet(set,grid);
        returnSizeOfSet(set,mat);

        while(true){
            size = returnSizeOfSet(set,mat);

            /*for(int i=0;i<grid1.size();i++){
                for(int j=0;j<grid1.get(i).size();j++){
                    if(i-1>=0 && grid1.get(i-1).get(j)==1 && grid1.get(i).get(j)==0){
                        grid.get(i).set(j,1);
                        set.remove(new Pair(i,j));
                    }else if(i+1<rows && grid1.get(i+1).get(j)==1 && grid1.get(i).get(j)==0){
                        grid.get(i).set(j,1);
                        set.remove(new Pair(i,j));
                    }else if(j+1<columns && grid1.get(i).get(j+1)==1 && grid1.get(i).get(j)==0){
                        List<Integer> temp = grid.get(i);
                        temp.set(j,1);
                        grid.set(i,temp);
                        set.remove(new Pair(i,j));
                    }else if(j-1>=0 && grid1.get(i).get(j-1)==1 && grid1.get(i).get(j)==0){
                        grid.get(i).set(j,1);
                        set.remove(new Pair(i,j));
                    }
                }
            }*/

            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(i-1>=0 && mat1[i-1][j]==1 && mat1[i][j]==0){
                        mat[i][j]=1;
                        set.remove(new Pair(i,j));
                    }else if(i+1<rows && mat1[i+1][j]==1 && mat1[i][j]==0){
                        mat[i][j]=1;
                        set.remove(new Pair(i,j));
                    }else if(j+1<columns && mat1[i][j+1]==1 && mat1[i][j]==0){
                        mat[i][j]=1;
                        set.remove(new Pair(i,j));
                    }else if(j-1>=0 && mat1[i][j-1]==1 && mat1[i][j]==0){
                        mat[i][j]=1;
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
            mat1 = cloneList(mat);
        }

        return numOfDays;
    }

    /*static List<List<Integer>> cloneList(List<List<Integer>> grid){
        List<List<Integer>> grid1 = new ArrayList<>();
        for(int i=0;i<grid.size();i++){
            List<Integer> list = new ArrayList<>(grid.get(i));
            grid1.add(list);
        }
        return grid1;
    }*/

    static int[][] cloneList(int[][] mat){
        int[][] mat1 = new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
             mat1[i][j]=mat[i][j];
            }
        }
        return mat1;
    }

    /*static int returnSizeOfSet(HashSet<Pair> set,List<List<Integer>> grid){
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(i).size();j++){
                if(grid.get(i).get(j)==0){
                    set.add(new Pair(i,j));
                }
            }
        }
        return set.size();
    }*/

    static int returnSizeOfSet(HashSet<Pair> set,int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    set.add(new Pair(i,j));
                }
            }
        }
        return set.size();
    }

    public static void main(String[] a){
        //int mat[][] = new int[][]{{0,1,1,0,1},{0,1,0,1,0},{0,0,0,0,1},{0,1,0,0,0}};
        List<List<Integer>> grid = List.of(List.of(0,1,1,0,1),List.of(0,1,0,1,0),List.of(0,0,0,0,1),List.of(0,1,0,0,0));
        //List<List<Integer>> grid = List.of(List.of(1,0,0,0,0),List.of(0,1,0,0,0),List.of(0,0,1,0,0),List.of(0,0,0,1,0),List.of(0,0,0,0,1));
        //List<List<Integer>> grid = List.of(List.of(0,0,1,0,0,0),List.of(0,0,0,0,0,0),List.of(0,0,0,0,0,1),List.of(0,0,0,0,0,0),List.of(0,1,0,0,0,0));

        int mat[][] = new int[grid.size()][grid.get(0).size()];
        for(int i=0;i<grid.size();i++){
            for(int j=0;j<grid.get(0).size();j++){
                mat[i][j]=grid.get(i).get(j);
            }
        }
        //minimumDays(grid.size(),grid.get(0).size(),mat);
       int ans = minimumDays(mat.length,mat[0].length,mat);
       System.out.println(ans);
    }
}
