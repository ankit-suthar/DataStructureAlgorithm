package com.algorithm.dynamicprogramming;

public class LongestPalindromeInStringDP2
{

    static int longestPalSubstr(String str) {
        int maxLength = 1;
        int start = 0;
        int n = str.length();

        int low, high;

        for(int i=1;i<n;i++){

            low = i-1;
            high = i;

            while(low>=0 && high<n &&
                    str.charAt(low)==str.charAt(high)){
                if(high-low+1>maxLength){
                    start = low;
                    maxLength = high-low+1;
                }
                low--;
                high++;
            }

            low = i-1;
            high = i+1;

            while(low>=0 && high<n &&
                    str.charAt(low)==str.charAt(high)){
                if(high-low+1>maxLength){
                    start = low;
                    maxLength = high-low+1;
                }
                low--;
                high++;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength));
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "aaaabbaa";
        System.out.println("Length is: " +
                longestPalSubstr(str));
    }
}
//Time complexity: O ( n^2 ) where n is the length of input string.
//Auxiliary Space: O ( 1 )
