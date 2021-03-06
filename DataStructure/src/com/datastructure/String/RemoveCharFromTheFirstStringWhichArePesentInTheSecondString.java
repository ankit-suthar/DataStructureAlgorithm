/*
Algorithm: Let first input string be”test string” and the string which has characters to be removed from first string be “mask”
1: Initialize:
res_ind = 0 // index to keep track of processing of each character in i/p string
ip_ind = 0 // index to keep track of processing of each character in the resultant string

2: Construct count array from mask_str. Count array would be:
(We can use Boolean array here instead of int count array because we don’t need count,
we need to know only if character is present in mask string)
count[‘a’] = 1
count[‘k’] = 1
count[‘m’] = 1
count[‘s’] = 1

3: Process each character of the input string and if count of that character is 0 then only add the character to the resultant string.
str = “tet tringng” // ’s’ has been removed because ’s’ was present in mask_str but we we have got two extra characters “ng”
ip_ind = 11
res_ind = 9

4: Put a ‘\0′ at the end of the string?
*/
package com.datastructure.String;

public class RemoveCharFromTheFirstStringWhichArePesentInTheSecondString {

    static int MAX_CHAR=26;

    static String removeDirtyChars(String str,String maskStr){
        int charArr[] = new int[MAX_CHAR];
        String answer="";
        int index=0;

        for(int i=0;i<maskStr.length();i++){
            charArr[maskStr.charAt(i)-'a']++;
        }

        while(index<str.length()){
            if(str.charAt(index)==' ' || charArr[str.charAt(index)-'a']==0){
                answer+=str.charAt(index);
            }
            index++;
        }

        return answer;
    }

    public static void main(String[] args){
        /*String str = "geeksforgeeks";
        String maskStr = "mask";*/
        //geeforgee
        String str = "test string";
        String maskStr = "mask";
        //tet tring
        System.out.println(removeDirtyChars(str, maskStr));
    }
}
//Time Complexity: O(m+n) Where m is the length of mask string and n is the length of the input string