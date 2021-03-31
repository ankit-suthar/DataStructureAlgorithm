/*
Given two strings str1 and str2, find if str1 is a subsequence of str2.
A subsequence is a sequence that can be derived from another sequence by deleting some elements
without changing the order of the remaining elements (source: wiki). Expected time complexity is linear.

Examples :

Input: str1 = "AXY", str2 = "ADXCPY"
Output: True (str1 is a subsequence of str2)

Input: str1 = "AXY", str2 = "YADXCP"
Output: False (str1 is not a subsequence of str2)

Input: str1 = "gksrek", str2 = "geeksforgeeks"
Output: True (str1 is a subsequence of str2)

Iterative Implementation
*/
package com.datastructure.String;

public class GivenTwoStringsFindIfFirstStringIsSubsequenceOfSecondMthd2 {

    static boolean isSubSequence(String str1,String str2,int m,int n){

        int j=0;

        for(int i=0;i<n && j<m;i++){
            if(str1.charAt(j)==str2.charAt(i)){
                j++;
            }
        }
        return j==m;
    }

    public static void main (String[] args){
        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        int m = str1.length();
        int n = str2.length();
        boolean res = isSubSequence(str1, str2, m, n);
        if(res)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
