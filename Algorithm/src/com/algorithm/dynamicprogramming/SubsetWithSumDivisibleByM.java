package com.algorithm.dynamicprogramming;

import java.util.Arrays;

public class SubsetWithSumDivisibleByM {

    public static void main(String[] a){
        SubsetWithSumDivisibleByM sumDivisibleByM = new SubsetWithSumDivisibleByM();
        int arr[] = {3, 1, 7, 5 };
        int m = 6;
        int n = arr.length;
        if (sumDivisibleByM.isSubsetSumDivisibleByM(arr, n, m,0) == true){
            System.out.println("There exists a subset with sum which is divisible by \"m\"");
        }else{
            System.out.println("No subset with sum which is divisible by \"m\"");
        }

        System.out.println(sumDivisibleByM.checkDivByM(arr, n, m));
    }

    boolean isSubsetSumDivisibleByM(int arr[],int n,int m,int sum){
        if(sum!=0 && sum%m==0){
            return true;
        }

        if(n==0){
            return false;
        }

        return isSubsetSumDivisibleByM(arr,n-1,m,sum+arr[n-1])||isSubsetSumDivisibleByM(arr,n-1,m,sum);
    }

    //DP
    boolean checkDivByM(int[] arr, int n, int div) {
        boolean result = false;
        int[] dp = new int[div];

        for (int num : arr) {
            int[] tmp = Arrays.copyOf(dp, div);

            for(int j = 0;j<div;j++) {
                dp[(num + tmp[j]) % div] = num + tmp[j];
            }

            if(dp[0] > 0) {
                return true;
            }
        }

        return false;
    }
}
