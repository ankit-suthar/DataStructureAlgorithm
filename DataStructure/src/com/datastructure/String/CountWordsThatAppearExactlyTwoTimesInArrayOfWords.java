/*
Given an array of n words. Some words are repeated twice, we need count such words.
Examples:

Input : s[] = {"hate", "love", "peace", "love",
               "peace", "hate", "love", "peace",
               "love", "peace"};
Output : 1
There is only one word "hate" that appears twice

Input : s[] = {"Om", "Om", "Shankar", "Tripathi",
                "Tom", "Jerry", "Jerry"};
Output : 2
There are two words "Om" and "Jerry" that appear
twice.
*/
package com.datastructure.String;

import java.util.HashMap;
import java.util.Map;

public class CountWordsThatAppearExactlyTwoTimesInArrayOfWords {

    static int countWords(String str[],int n){
        int total=0;
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            if(!map.containsKey(str[i])){
                map.put(str[i],1);
            }else{
                int count = map.get(str[i]);
                map.put(str[i],++count);
            }
        }

        for(Map.Entry<String,Integer> entrySet : map.entrySet()){
            if(entrySet.getValue()==2){
                total++;
            }
        }
        return total;
    }

    public static void main(String args[]){
        String str[] = { "hate", "love", "peace", "love",
                "peace", "hate", "love", "peace",
                "love", "peace" };
        int n = str.length;
        System.out.println(countWords(str, n));
    }
}
//Time complexity: O(n)