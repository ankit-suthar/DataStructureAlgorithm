/*
Find and print the uncommon characters of the two given strings in sorted order.
Here uncommon character means that either the character is present in one string
or it is present in other string but not in both. The strings contain only lowercase characters and can contain duplicates.

Input: str1 = “characters”, str2 = “alphabets”
Output: b c l p r

Input: str1 = “geeksforgeeks”, str2 = “geeksquiz”
Output: f i o q r u z

Efficient Approach: An efficient approach is to use hashing.

Use a hash table of size 26 for all the lowercase characters.
Initially, mark presence of each character as ‘0’ (denoting that the character is not present in both the strings).
Traverse the 1st string and mark presence of each character of 1st string as ‘1’ (denoting 1st string) in the hash table.
Now, traverse the 2nd string. For each character of 2nd string, check whether its presence in the hash table is ‘1’ or not.
If it is ‘1’, then mark its presence as ‘-1’ (denoting that the character is common to both the strings),
else mark its presence as ‘2’ (denoting 2nd string).
*/
package com.datastructure.String;

public class FindUncommonCharOfTwoStringsMthd1 {

    static int MAX_CHAR = 26;

    static void findAndPrintUncommonChars(String str1,String str2){
        int[] finalArray = new int[MAX_CHAR];
        String answer="";

        for(int i=0;i<str1.length();i++){
            if(finalArray[str1.charAt(i)-'a']==0){
                finalArray[str1.charAt(i)-'a']++;
            }
        }

        for(int i=0;i<str2.length();i++){
            if(finalArray[str2.charAt(i)-'a']==0){
                finalArray[str2.charAt(i)-'a']=2;
            }else if(finalArray[str2.charAt(i)-'a']==1){
                finalArray[str2.charAt(i)-'a']=-1;
            }
        }

        for(int i=0;i<MAX_CHAR;i++){
            if(finalArray[i]==2 || finalArray[i]==1){
                answer+=Character.toString((char) (i+'a'))+" ";
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args){
        String str1 = "abcs";
        String str2 = "cxzca";
        //b s x z
        /*String str1 = "geeksforgeeks";
        String str2 = "geeksquiz";*/
        //f i o q r u z
        /*String str1 = "characters";
        String str2 = "alphabets";*/
        //b c l p r
        findAndPrintUncommonChars(str1, str2);
    }
}
//Time Complexity: O(m + n), where m and n are the sizes of the two strings respectively