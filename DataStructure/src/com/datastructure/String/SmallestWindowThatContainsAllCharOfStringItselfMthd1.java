package com.datastructure.String;

public class SmallestWindowThatContainsAllCharOfStringItselfMthd1 {

    static int MAX_CHAR=256;

    static String findSubString(String str){
        int[] patArr = new int[MAX_CHAR];
        int[] strArr = new int[MAX_CHAR];
        int start = 0, startIndex = -1, count = 0, distinctCount = 0, minLen = Integer.MAX_VALUE;

        for(int i=0;i<str.length();i++){
            if(patArr[str.charAt(i)]==0){
                patArr[str.charAt(i)]=1;
                distinctCount++;
            }
        }

        for(int i=0;i<str.length();i++){
            strArr[str.charAt(i)]++;

            if(strArr[str.charAt(i)]==1){
                count++;
            }

            if(count==distinctCount){
                while(strArr[str.charAt(start)]>patArr[str.charAt(start)]){

                    if (strArr[str.charAt(start)] > patArr[str.charAt(start)]){
                        strArr[str.charAt(start)]--;
                    }
                    start++;

                    int len = i-start+1;
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
