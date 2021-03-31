/*
Create a hash table with (key, value) tuple represented as (character, index) tuple.
Store the first index of each character of str in the hash table.
Now, for each character of patt check if it is present in the hash table or not.
If present then get its index from the hash table and update minIndex(minimum index encountered so far).
For no matching character print “No character present”.

Given a string str and another string patt. Find the character in patt that is present at the minimum index in str.
If no character of patt is present in str then print ‘No character present’.

Examples:

Input: str = “geeksforgeeks”, patt = “set”
Output: e
Both e and s of patt are present in str,
but e is present at minimum index, which is 1.

Input: str = “adcffaet”, patt = “onkl”
Output: No character present
*/
package com.datastructure.String;

import java.util.HashMap;
import java.util.Map;

public class FindCharacterInFirstStringThatIsPresentAtMinIndexInSecondString {

    static char printMinIndexChar(String str,String patt){
        Map<String,Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        char ch=' ';

        for(int i=0;i<patt.length();i++){
            if(!map.containsKey(patt.substring(i,i+1))){
                map.put(patt.substring(i,i+1),i);
            }
        }

        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.substring(i,i+1))){
                if(i<minIndex){
                    minIndex=i;
                    ch=str.charAt(i);
                }
            }
        }
        return ch;
    }

    public static void main(String[] args){
        String str = "adcffaet";
        String patt = "onkl";
        //No character present
        /*String str = "geeksforgeeks";
        String patt = "set";*/
        //e
        char ch = printMinIndexChar(str, patt);
        if(ch==' '){
            System.out.println("No character present");
        }else{
            System.out.println(ch);
        }
    }
}
//Time Complexity: O(m + n), where m and n are the lengths of the two strings.
//Auxiliary Space: O(d), where d is the size of hash table, which is the count of distinct characters in str