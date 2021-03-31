/*
Given a binary string, count number of substrings that start and end with 1.
For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
a) Count the number of 1’s. Let the count of 1’s be m
b) Return m(m-1)/2
*/
package com.datastructure.String;

public class GivenBinaryStringCountNumberOfSubstringsStartAndEndWith1 {

    static int countSubStr(String str,int n){
        int countOf1=0;

        for(int i=0;i<n;i++){
            if(str.charAt(i)=='1'){
                countOf1++;
            }
        }

        return (countOf1)*(countOf1-1)/2;
    }

    public static void main(String[] args){
        String str = "00100101";
        int n = str.length();
        System.out.println(countSubStr(str,n));
    }
}
//Time Complexity: O(n)