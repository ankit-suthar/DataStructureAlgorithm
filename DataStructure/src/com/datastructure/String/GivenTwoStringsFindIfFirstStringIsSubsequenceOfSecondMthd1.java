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

Recursive Implementation
*/
package com.datastructure.String;

public class GivenTwoStringsFindIfFirstStringIsSubsequenceOfSecondMthd1 {

    static boolean isSubSequence(String str1,String str2,int m,int n){

        if(m==0){
            return true;
        }

        if(n==0){
            return false;
        }

        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return isSubSequence(str1,str2,m-1,n-1);
        }
        return isSubSequence(str1,str2,m,n-1);
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
