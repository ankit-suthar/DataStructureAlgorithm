package com.algorithm.dynamicprogramming;

public class LongestRepeatedSubsequence {

    int getLengthOfLongestRepeatedSubsequence(char[] X,int m,int n){
        if(m==0 || n==0){
            return 0;
        }else if(X[m-1]==X[n-1] && m!=n){
            return 1+getLengthOfLongestRepeatedSubsequence(X,m-1,n-1);
        }else{
            return Math.max(getLengthOfLongestRepeatedSubsequence(X,m-1,n),getLengthOfLongestRepeatedSubsequence(X,m,n-1));
        }
    }

    public static void main(String[] a){
        LongestRepeatedSubsequence sub = new LongestRepeatedSubsequence();
        String str = "AABEBCDD";
        System.out.println(sub.getLengthOfLongestRepeatedSubsequence(str.toCharArray(),str.length(),str.length()));
    }
}
