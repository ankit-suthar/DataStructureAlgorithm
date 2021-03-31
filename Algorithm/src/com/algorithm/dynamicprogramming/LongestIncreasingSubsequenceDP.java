package com.algorithm.dynamicprogramming;

public class LongestIncreasingSubsequenceDP {

    int lis(int arr[],int n){
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            ans[i]=1;
        }
        int max=0;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j]>arr[i] && ans[j]<ans[i]+1){
                    ans[j]=ans[i]+1;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(ans[i]>max){
                max=ans[i];
            }
        }
        return max;
    }

    public static void main(String[] a){
        LongestIncreasingSubsequenceDP lis = new LongestIncreasingSubsequenceDP();
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 ,55,65};
        int n = arr.length;
        System.out.println("Length of lis is "+ lis.lis(arr, n) + "\n");
    }
}
//Time complexity: O(n^2)