package com.algorithm.dynamicprogramming;

public class CountNumberWaysToTraverseMatrix {

    static int countWays(int m,int n){

        if(m==1 || n==1){
            return 1;
        }

        return countWays(m-1,n) + countWays(m,n-1);
    }

    public static void main(String[] a){
        int m=3,n=3;
        System.out.println(countWays(m,n));
    }
}
