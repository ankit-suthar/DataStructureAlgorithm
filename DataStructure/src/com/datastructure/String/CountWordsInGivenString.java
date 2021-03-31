/*
Given a string, count number of words in it. The words are separated by following characters: space (‘ ‘) or
new line (‘\n’) or tab (‘\t’) or a combination of these.
*/
package com.datastructure.String;

public class CountWordsInGivenString {

    static int countWords(String str){
        int IN=1;
        int OUT=0;
        int state=OUT;
        int wordCount=0;

        for(int i=0;i<str.length();i++){

            if(str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t'){
                state = OUT;
            }else{
                if(state == OUT){
                    wordCount++;
                    state = IN;
                }
            }
        }
        return wordCount;
    }

    public static void main(String args[]){
        String str = "One two       three\n four\tfive  ";
        System.out.println("No of words : " + countWords(str));
    }
}
//Time complexity: O(n)