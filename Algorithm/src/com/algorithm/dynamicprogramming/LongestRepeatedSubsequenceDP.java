package com.algorithm.dynamicprogramming;

public class LongestRepeatedSubsequenceDP {

    int getLengthOfLongestRepeatedSubsequence(char[] X,int m,int n){
        int ans[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    ans[i][j]=0;
                }else if(X[i-1]==X[j-1] && i!=j){
                    ans[i][j] = 1 + ans[i-1][j-1];
                }else{
                    ans[i][j] = Math.max(ans[i][j-1],ans[i-1][j]);
                }
            }
        }
        return ans[m][n];
    }

    public static void main(String[] a){
        LongestRepeatedSubsequenceDP sub = new LongestRepeatedSubsequenceDP();
        String str = "AABEBCDD";
        System.out.println(sub.getLengthOfLongestRepeatedSubsequence(str.toCharArray(),str.length(),str.length()));
    }
}
