package com.algorithm.dynamicprogramming;

public class LongestPalindromeInStringDP1 {

    void lengthOfLongestPalindromeInString(String str,int n){
        boolean[][] table = new boolean[n][n];
        int maxLength=Integer.MIN_VALUE;
        int start=-1;

        for(int i=0;i<n;i++){
            table[i][i] = true;
        }

        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                table[i][i+1]=true;
                if(maxLength<2){
                    maxLength=2;
                    start=i;
                }
            }
        }

        for(int i=3;i<=n;i++){
            for(int j=0;j<n-i+1;j++){
                int k = j+i-1;
                if(table[j+1][k-1] && str.charAt(j)==str.charAt(k)){
                    table[j][k]=true;
                    if(i>maxLength){
                        maxLength=i;
                        start=j;
                    }
                }
            }
        }
        System.out.println("Longest palindromic String is: "+str.substring(start,start+maxLength));
    }

    public static void main(String[] a){
        LongestPalindromeInStringDP1 lps = new LongestPalindromeInStringDP1();
        String str = "aaaabbaa";
        lps.lengthOfLongestPalindromeInString(str,str.length());
    }
}
//Time complexity: O ( n^2 )
//Auxiliary Space: O ( n^2 )