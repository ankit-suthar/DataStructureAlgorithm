package com.algorithm.dynamicprogramming;

public class MinCostPath {

    int minCostPathEvaluate(int[][] cost,int m,int n){
        if(m==0 && n==0){
            return cost[m][n];
        }else if(m<0 || n<0){
            return Integer.MAX_VALUE;
        }

        return cost[m][n] + Math.min(Math.min(minCostPathEvaluate(cost,m-1,n)
                ,minCostPathEvaluate(cost,m,n-1))
                ,minCostPathEvaluate(cost,m-1,n-1));
    }

    public static void main(String[] a){
        MinCostPath minCostPath = new MinCostPath();
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3} };
        int m = cost.length;
        int n = cost[0].length;

        System.out.println(minCostPath.minCostPathEvaluate(cost,m-1,n-1));
    }
}
