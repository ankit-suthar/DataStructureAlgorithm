package com.algorithm.dynamicprogramming;

public class CoinChange {

    int count(int arr[],int n,int sum){
        if(sum==0){
            return 1;
        }

        if(sum<0){
            return 0;
        }

        if(n<=0 && sum>=1){
            return 0;
        }

        return count(arr,n,sum-arr[n-1])+count(arr,n-1,sum);
    }

    public static void main(String[] a){
        CoinChange ch = new CoinChange();
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(ch.count(arr, m, 4));
    }
}
