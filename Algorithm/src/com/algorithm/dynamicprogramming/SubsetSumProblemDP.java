package com.algorithm.dynamicprogramming;

public class SubsetSumProblemDP {

    boolean isSubsetSum(int arr[],int n,int sum){

        boolean [][] ans = new boolean[sum+1][n+1];

        for(int i=0;i<=n;i++){
            ans[0][i]=true;
        }

        for(int i=1;i<=sum;i++){
            ans[i][0]=false;
        }

        for(int i=1;i<=sum;i++){
            for(int j=1;j<=n;j++){
                if(i>=arr[j-1]){
                    ans[i][j] = ans[i-arr[j-1]][j-1]||ans[i][j-1];
                }else{
                    ans[i][j] = ans[i][j-1];
                }
            }
        }
        /*for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]>j){
                    ans[j][i] = ans[j][i-1];
                }else{
                    ans[j][i] = ans[j][i-1] || ans[j-arr[i-1]][i-1];
                }
            }
        }*/
        return ans[sum][n];
    }

    public static void main(String[] a){
        SubsetSumProblemDP subsetSumProblemDP = new SubsetSumProblemDP();
        int arr[] = { 6, 2, 5 };
        int sum = 8;
        int n = arr.length;
        if (subsetSumProblemDP.isSubsetSum(arr, n, sum) == true)
            System.out.println("There exists a subset with given sum");
        else
            System.out.println("No subset exists with given sum");
    }
}
//Time Complexity: O(n^2)