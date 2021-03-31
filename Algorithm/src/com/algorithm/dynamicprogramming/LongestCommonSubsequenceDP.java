package com.algorithm.dynamicprogramming;

public class LongestCommonSubsequenceDP {

    int getLongestCommonSubsequence(char[] A,char[] B,int m,int n){
        int[][] ans = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    ans[i][j]=0;
                }else if(A[i-1]==B[j-1]){
                    ans[i][j]=ans[i-1][j-1]+1;
                }else{
                    ans[i][j] = Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        return ans[m][n];
    }

    public static void main(String[] a){
        LongestCommonSubsequenceDP longestCommonSubsequenceDP = new LongestCommonSubsequenceDP();
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        char[] A = X.toCharArray();
        char[] B = Y.toCharArray();

        System.out.println("Longest common subsequence: "+longestCommonSubsequenceDP.getLongestCommonSubsequence(A,B,A.length,B.length));
    }
}
