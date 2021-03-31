package com.company.question.others;

import java.util.HashSet;
import java.util.Set;

public class Test {

    static void printAllKLength(char[] charArray, int k, Set<String> set){
        int n = charArray.length;
        printAllKLengthRec(charArray, "", 0,n-1, k,set);
    }

    static void printAllKLengthRec(char[] charArray, String prefix
            , int start, int end, int k, Set<String> set){
        if (k == 0){
            set.add(prefix);
            return;
        }

        for (int i = start; i <= end; ++i){
            String newPrefix = prefix + charArray[i];
            printAllKLengthRec(charArray, newPrefix, i+1, end, k - 1, set);
        }
    }

    public static int distinctMoves(String s, int n, int x, int y) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> ans = new HashSet<>();

        char[] charArray = s.toCharArray();
        for(int i=0;i<=s.length();i++){
            printAllKLength(charArray, i, set);
        }

        int tempX = x;
        int tempY = y;

        for(String string : set) {
            tempX = x;
            tempY = y;

            for(int i=0;i<string.length();i++){
                if(string.charAt(i)=='r'){
                    if(tempX+1>n){
                        tempX=-1;
                        break;
                    }
                    tempX++;
                }else if(string.charAt(i)=='l'){
                    if(tempX-1<0){
                        tempX=-1;
                        break;
                    }
                    tempX--;
                }
            }
            if(tempX==tempY){
                ans.add(string);
            }
        }
        return ans.size();
    }

    public static void main(String[] args){
        String str = "rrlrlr";
        int n = 6;
        int x = 1;
        int y = 2;
        //7
        /*String str = "rrlrlr";
        int n = 6;
        int x = 1;
        int y = 3;*/
        //5
        /*String str = "rrrlrr";
        int n = 7;
        int x = 0;
        int y = 0;*/
        //2
        int size = distinctMoves(str,n,x,y);
        System.out.println(size);
    }
}
