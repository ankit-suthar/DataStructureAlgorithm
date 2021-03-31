package com.algorithm.dynamicprogramming;

public class LongestCommonSubsequence {

    int getLongestCommonSubsequence(char[] A,char[] B,int m,int n){
        if(m==0 || n==0){
            return 0;
        }else if(A[m-1]==B[n-1]){
            return 1+getLongestCommonSubsequence(A,B,m-1,n-1);
        }else{
            return Math.max(getLongestCommonSubsequence(A,B,m-1,n),getLongestCommonSubsequence(A,B,m,n-1));
        }
    }

    public static void main(String[] a){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        char[] A = X.toCharArray();
        char[] B = Y.toCharArray();

        System.out.println("Longest common subsequence: "+longestCommonSubsequence.getLongestCommonSubsequence(A,B,A.length,B.length));
    }
}
//Time complexity: O(2^n)
//9426897099