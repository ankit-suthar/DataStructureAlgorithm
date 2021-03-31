package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeDP1 {

    int count(int arr[],int n,int sum){
        int[] ans = new int[sum+1];
        Arrays.fill(ans,0);

        ans[0]=1;
        for(int i=0;i<n;i++) {
            for (int j = arr[i]; j <= sum; j++) {
                ans[j] += ans[j - arr[i]];
            }
        }
        return ans[sum];
    }

    public static void main(String[] a){
        CoinChangeDP1 ch = new CoinChangeDP1();
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(ch.count(arr, m, 4));
    }
}
//Time Complexity: O(n*sum)
