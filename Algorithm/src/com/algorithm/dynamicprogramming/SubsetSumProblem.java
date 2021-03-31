package com.algorithm.dynamicprogramming;

public class SubsetSumProblem {

    boolean isSubsetSum(int arr[],int n,int sum){
        if(n==0 && sum!=0){
            return false;
        }

        if(sum==0){
            return true;
        }

        if(arr[n-1]>sum){
            return isSubsetSum(arr,n-1,sum);
        }

        return isSubsetSum(arr,n-1,sum)||isSubsetSum(arr,n-1,sum-arr[n-1]);
    }

    public static void main(String[] a){
        SubsetSumProblem subSetSumProblem = new SubsetSumProblem();
        int arr[] = { 6, 2, 5 };
        int sum = 7;
        int n = arr.length;
        if (subSetSumProblem.isSubsetSum(arr, n, sum) == true)
            System.out.println("There exists a subset with given sum");
        else
            System.out.println("No subset exists with given sum");
    }
}
