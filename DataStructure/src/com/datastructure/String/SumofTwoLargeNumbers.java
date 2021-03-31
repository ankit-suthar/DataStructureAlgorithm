/*
Given two numbers as strings. The numbers may be very large (may not fit in long long int), the task is to find sum of these two numbers.

Examples:

Input  : str1 = "3333311111111111",
         str2 =   "44422222221111"
Output : 3377733333332222

Input  : str1 = "7777555511111111",
         str2 =    "3332222221111"
Output : 7780887733332222
*/
package com.datastructure.String;

public class SumofTwoLargeNumbers {

    static String findSum(String str1,String str2){
        int m = str1.length()-1;
        int n = str2.length()-1;
        int carry=0, num1=0, num2=0, sum=0;
        String ans = "";

        while(m>=0 && n>=0){
            num1=Integer.parseInt(Character.toString(str1.charAt(m)));
            num2=Integer.parseInt(Character.toString(str2.charAt(n)));
            sum = (num1+num2+carry);
            ans = sum%10 + ans;
            carry = sum/10;
            m--;
            n--;
        }

        while(m>=0){
            num1=Integer.parseInt(Character.toString(str1.charAt(m)));
            sum = (num1+carry);
            ans = sum%10 + ans;
            carry = sum/10;
            m--;
        }

        while(n>=0){
            num2=Integer.parseInt(Character.toString(str2.charAt(n)));
            sum = (num2+carry);
            ans = sum%10 + ans;
            carry = sum/10;
            n--;
        }

        return ans;
    }

    public static void main(String[] a){
        String str1 = "3333311111111111";
        String str2 =   "44422222221111";
        //3377733333332222
        /*String str1 = "7777555511111111";
        String str2 =   "3332222221111";*/
        //7780887733332222
        /*String str1 = "12";
        String str2 = "198111";*/
        //198123
        System.out.println(findSum(str1, str2));
    }
}
//Time Complexity : O(n1 + n2) where n1 and n2 are lengths of two input strings representing numbers.