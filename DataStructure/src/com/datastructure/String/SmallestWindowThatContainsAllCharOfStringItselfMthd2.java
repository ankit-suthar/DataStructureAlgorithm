/*
Given a string, find the smallest window length with all distinct characters of the given string.
For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .

Examples:

Input  : aabcbcdbca
Output : dbca
Explanation :
dbca of length 4 is the smallest
window with highest number of distinct
characters.

Input : aaab
Output : ab
Explanation :
ab of length 2 is the smallest window
with highest number of distinct characters.
*/
package com.datastructure.String;

public class SmallestWindowThatContainsAllCharOfStringItselfMthd2 {

    static int MAX_CHAR=256;

    static String findSubString(String str){
        boolean[] visited = new boolean[MAX_CHAR];
        int[] strArr = new int[MAX_CHAR];
        int start = 0, startIndex = -1, count = 0, distinctCount = 0, minLen = Integer.MAX_VALUE;

        for(int i=0;i<str.length();i++){
            if(!visited[str.charAt(i)]){
                visited[str.charAt(i)]=true;
                distinctCount++;
            }
        }

        int len;

        for(int i=0;i<str.length();i++){
            strArr[str.charAt(i)]++;

            if(strArr[str.charAt(i)]==1){
                count++;
            }

            if(count==distinctCount){
                len = i-start+1;
                if(len<minLen){
                    minLen=len;
                    startIndex=start;
                }
                while(strArr[str.charAt(start)]>1){

                    if(strArr[str.charAt(start)]>1){
                        strArr[str.charAt(start)]--;
                    }
                    start++;

                    len = i-start+1;
                    if(len<minLen){
                        minLen=len;
                        startIndex=start;
                    }
                }
            }
        }
        return str.substring(startIndex,startIndex+minLen);
    }

    public static void main(String[] a){
        //String str = "aaab"; //ab
        String str = "aabcbcdbca"; //dbca
        System.out.println(findSubString(str));
    }
}
