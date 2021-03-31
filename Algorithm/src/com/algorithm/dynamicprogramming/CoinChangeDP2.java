package com.algorithm.dynamicprogramming;

public class CoinChangeDP2 {

    int count(int arr[],int n,int sum){
        int[][] table = new int[n+1][sum+1];

        for(int i=0;i<=n;i++){
            table[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    table[i][j] = table[i-1][j];
                }else{
                    table[i][j] = table[i-1][j] + table[i][j-arr[i-1]];
                }
            }
        }

        return table[n][sum];
    }

    public static void main(String[] a){
        CoinChangeDP2 ch = new CoinChangeDP2();
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(ch.count(arr, m, 4));
    }
}
