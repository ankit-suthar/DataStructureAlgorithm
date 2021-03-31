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

public class CountSubstringsWithSameFirstAndLastCharactersMthd1 {

    static int MAX_CHAR = 26;

    static int countSubstringWithEqualEnds(String str){
        int[] arr = new int[MAX_CHAR];
        int sum = 0;

        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']++;
        }

        for(int i=0;i<MAX_CHAR;i++){
            if(arr[i]!=0){
                sum += ((arr[i])*(arr[i]+1)/2);
            }
        }
        return sum;
    }

    public static void main(String args[]){
        String s = "abcab";
        System.out.println(countSubstringWithEqualEnds(s));
    }
}
//Time complexity: O(n)
//Space complexity: O(1)