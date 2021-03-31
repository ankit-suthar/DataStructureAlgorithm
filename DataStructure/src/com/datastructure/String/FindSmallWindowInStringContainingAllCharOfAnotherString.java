/*
Given two strings string1 and string2, the task is to find the smallest substring in string1
containing all characters of string2 efficiently.

Examples:

Input: string = “this is a test string”, pattern = “tist”
Output: Minimum window is “t stri”
Explanation: “t stri” contains all the characters of pattern.

Input: string = “geeksforgeeks”, pattern = “ork”
Output: Minimum window is “ksfor”

Method :

First check if the length of string is less than the length of the given pattern, if yes then “no such window can exist “.
Store the occurrence of characters of the given pattern in a hash_pat[].
Start matching the characters of pattern with the characters of string i.e. increment count if a character matches.
Check if (count == length of pattern ) this means a window is found.
If such window found, try to minimize it by removing extra characters from the beginning of the current window.
Update min_length.
Print the minimum length window.
*/
package com.datastructure.String;

public class FindSmallWindowInStringContainingAllCharOfAnotherString {

    static int MAX_CHAR=256;

    static String findSubString(String str,String pat){
        int start=0, count=0, startIndex = -1, minLen=Integer.MAX_VALUE;
        int[] strArr = new int[MAX_CHAR];
        int[] patArr = new int[MAX_CHAR];

        if (str.length() < pat.length()){
            System.out.println("No such window exists");
            return "";
        }

        for(int i=0;i<pat.length();i++){
            patArr[pat.charAt(i)]++;
        }

        for(int i=0;i<str.length();i++){

            strArr[str.charAt(i)]++;
            if(patArr[str.charAt(i)] != 0 && strArr[str.charAt(i)]<=patArr[str.charAt(i)]){
                count++;
            }

            if(count==pat.length()){

                while((strArr[str.charAt(start)]>patArr[str.charAt(start)]) || (patArr[str.charAt(start)]==0)){

                    if(strArr[str.charAt(start)]>patArr[str.charAt(start)]){
                        strArr[str.charAt(start)]--;
                    }
                    start++;
                }

                int len = i-start+1;
                if(len<minLen){
                    minLen = len;
                    startIndex = start;
                }
            }
        }

        if (startIndex == -1){
            System.out.println("No such window exists");
            return "";
        }
        return str.substring(startIndex,startIndex+minLen);
    }

    public static void main(String[] a){
        /*String str = "this is a test string";
        String pat = "tist";*/
        //t stri
        String str = "geeksforgeeks";
        String pat = "ork";
        //ksfor
        System.out.println(findSubString(str,pat));
    }
}
