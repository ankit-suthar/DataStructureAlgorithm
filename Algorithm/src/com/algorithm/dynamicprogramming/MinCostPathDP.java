package com.algorithm.dynamicprogramming;

public class MinCostPathDP {

    int minCostPathEvaluate(int cost[][]){
        int m = cost.length;
        int n = cost[0].length;

        int c[][] = new int[m][n];
        c[0][0]=cost[0][0];

        for(int i=1;i<n;i++){
            c[0][i] = c[0][i-1] + cost[0][i];
        }

        for(int i=1;i<m;i++){
            c[i][0] = c[i-1][0] + cost[i][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                c[i][j] = cost[i][j] + Math.min(Math.min(c[i][j-1],c[i-1][j]),c[i-1][j-1]);
            }
        }
        return c[m-1][n-1];
    }

    public static void main(String[] a){
        MinCostPathDP minCostPath = new MinCostPathDP();
        int cost[][] = { {1, 2, 3},
                         {4, 8, 2},
                         {1, 5, 3} };
        System.out.println(minCostPath.minCostPathEvaluate(cost));
    }
}
