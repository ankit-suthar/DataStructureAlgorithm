/*
Calculate difficulty of a given sentence. Here a Word is considered hard if it has 4 consecutive consonants or
number of consonants are more than number of vowels. Else word is easy.
Difficulty of sentence is defined as 5*(number of hard words) + 3*(number of easy words).

Examples:
Input : str = "Difficulty of sentence"
Output : 13
Hard words = 2(Difficulty and sentence)
Easy words = 1(of)
So, answer is 5*2+3*1 = 13

Implementation:
Start traversing the string and perform following steps:-

Increment vowels count, if current character is vowel and set conecutive consonants count=0.
Else increment consonants count, also increment consecutive consonants count.
Check if consecutive consonants becomes 4, then current word is hard, so increment its count
and move to the next word.Reset all counts to 0.
Else check if a word is completed and count of consonants is greater than count of vowels,
then it is a hard word else easy word.Reset all counts to 0.
*/
package com.datastructure.String;

public class CalculateTheDifficultyOfSentence {

    static boolean isVowels(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }

    static int calcDiff(String str){
        int hardWords=0, easyWords=0, countVowels=0, countConso=0, consecutiveConso=0;

        for(int i=0;i<str.length();i++){

            if(str.charAt(i)!=' ' && isVowels(Character.toLowerCase(str.charAt(i)))){
                countVowels++;
                consecutiveConso=0;
            }else if(str.charAt(i)!=' '){
                countConso++;
                consecutiveConso++;
            }

            if(consecutiveConso==4){
                hardWords++;

                while(i<str.length() && str.charAt(i)!=' '){
                    i++;
                }
                countConso=0;
                consecutiveConso=0;
                countVowels=0;
            }else if(i<str.length() && (str.charAt(i)==' ' || i==str.length()-1)){
                if(countConso>countVowels){
                    hardWords++;
                }else{
                    easyWords++;
                }
                countConso=0;
                countVowels=0;
                consecutiveConso=0;
            }
        }
        return 5*hardWords + 3*easyWords;
    }

    public static void main (String[] args){
        String str = "I am a geek";
        String str2 = "We are geeks";
        System.out.println(calcDiff(str));
        System.out.println(calcDiff(str2));
    }
}
