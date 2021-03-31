package com.datastructure.String;

public class Anagram {

    boolean areAnagram(String s1,String s2){

        if(s1.length()!=s2.length()){
            return false;
        }
        int val=0;

        for(int i=0;i<s1.length();i++){
            val = val ^ (int)s1.charAt(i);
            val = val ^ (int)s2.charAt(i);
        }

        if(val==0){
            return true;
        }
        return false;
    }

    public static void main(String[] a){
        Anagram anagram = new Anagram();
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";
        if (anagram.areAnagram(str1, str2))
            System.out.println("The two strings are anagram of each other");
        else
            System.out.println("The two strings are not anagram of each other");
    }
}
//Time Complexity: O(n)
//Space Complexity: O(1)