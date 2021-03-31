/*
Given a string, remove the vowels from the string and print the string without vowels.

Examples:

Input : welcome to geeksforgeeks
Output : wlcm t gksfrgks

Input : what is your name ?
Output : wht s yr nm ?
*/
package com.datastructure.String;

public class ProgramToRemoveVowelsFromStringMthd2 {

    static String remVowel(String str){
        return str.replaceAll("[aeiouAEIOU]","");
    }

    public static void main(String[] args){
        String str = "welcome to geeksforgeeks";
        //wlcm t gksfrgks
        /*String str = "GeeeksforGeeks - A Computer Science Portal for Geeks";*/
        //GksfrGks - Cmptr Scnc Prtl fr Gks
        System.out.println(remVowel(str));
    }
}
