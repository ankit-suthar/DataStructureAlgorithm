/*
We are given a string S, we need to find count of all contiguous substrings starting and ending with same character.

Examples :

Input  : S = "abcab"
Output : 7
There are 15 substrings of "abcab"
a, ab, abc, abca, abcab, b, bc, bca
bcab, c, ca, cab, a, ab, b
Out of the above substrings, there
are 7 substrings : a, abca, b, bcab,
c, a and b.

Input  : S = "aba"
Output : 4
The substrings are a, b, a and aba
*/
package com.datastructure.String;

public class CountSubstringsWithSameFirstAndLastCharactersMthd2 {

    static int countSubstringWithEqualEnds(String str){
        int sum = 0;

        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)){
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String args[]){
        //String str = "abcab"; //7
        String str = "aba"; //4
        System.out.println(countSubstringWithEqualEnds(str));
    }
}
//Time complexity: O(n^2)
//Space complexity: O(1)