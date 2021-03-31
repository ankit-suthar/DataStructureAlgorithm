package com.algorithm.dynamicprogramming;

public class MaximumSumIncreasingSubsequenceDP {

    int maximumSumIncrSubSeq(int arr[], int n){
        int[] sum = new int[n];

        for(int i=0;i<n;i++){
            sum[i]=arr[i];
        }

        int max=Integer.MIN_VALUE;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && sum[j]+arr[i]>sum[i]){
                    sum[i]=sum[j]+arr[i];
                    if(max<sum[i]){
                        max=sum[i];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] a){
        MaximumSumIncreasingSubsequenceDP maxSubSeq = new MaximumSumIncreasingSubsequenceDP();
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum increasing subsequence is: "+maxSubSeq.maximumSumIncrSubSeq(arr,n));
    }
}
