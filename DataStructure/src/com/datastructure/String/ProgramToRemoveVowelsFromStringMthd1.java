/*
Given a string, remove the vowels from the string and print the string without vowels.

Examples:

Input : welcome to geeksforgeeks
Output : wlcm t gksfrgks

Input : what is your name ?
Output : wht s yr nm ?
*/
package com.datastructure.String;

import java.util.Arrays;
import java.util.List;

public class ProgramToRemoveVowelsFromStringMthd1 {

    static String remVowel(String str){
        Character[] vowels = {'a','e','i','o','u','A','E','I','O','U'};

        List<Character> listOfVowels = Arrays.asList(vowels);
        StringBuffer stringBuffer = new StringBuffer(str);

        for(int i=0;i<stringBuffer.length();i++){
            if(listOfVowels.contains(stringBuffer.charAt(i))){
                stringBuffer.replace(i,i+1,"");
                i--;
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        String str = "GeeeksforGeeks - A Computer Science Portal for Geeks";
        //GksfrGks - Cmptr Scnc Prtl fr Gks
        System.out.println(remVowel(str));
    }
}
