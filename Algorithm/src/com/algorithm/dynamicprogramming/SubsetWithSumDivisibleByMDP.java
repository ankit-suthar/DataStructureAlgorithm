package com.algorithm.dynamicprogramming;

public class SubsetWithSumDivisibleByMDP {

    public static void main(String[] a){
        SubsetWithSumDivisibleByMDP sumDivisibleByM = new SubsetWithSumDivisibleByMDP();
        int arr[] = {3, 1, 7, 5 };
        int m = 6;
        int n = arr.length;
        if (sumDivisibleByM.isSubsetSumDivisibleByMUtil(arr, n, m) == true){
            System.out.println("There exists a subset with sum which is divisible by \"m\": "+m);
        }else{
            System.out.println("No subset with sum which is divisible by \"m\"");
        }
    }

    boolean isSubsetSumDivisibleByMUtil(int arr[],int n,int m){
        return isSubsetSumDivisibleByM(arr,n,m,0);
    }

    boolean isSubsetSumDivisibleByM(int arr[],int n,int m,int sum){
        //boolean[][] table = new boolean[][];

        if(n<0){
            return false;
        }

        if(sum!=0 && sum%m==0){
            return true;
        }
        return isSubsetSumDivisibleByM(arr,n-1,m,sum+arr[n-1])||isSubsetSumDivisibleByM(arr,n-1,m,sum);
    }
}
