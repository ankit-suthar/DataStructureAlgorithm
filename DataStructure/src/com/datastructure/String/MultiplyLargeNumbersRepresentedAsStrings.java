/*
Given two numbers as strings. The numbers may be very large (may not fit in long long int),
the task is to find product of these two numbers.

Examples:

Input : num1 = 4154
        num2 = 51454
Output : 213739916

Input :  num1 = 654154154151454545415415454
         num2 = 63516561563156316545145146514654
Output : 41549622603955309777243716069997997007620439937711509062916

We start from last digit of second number multiply it with first number. Then we multiply second digit of second number with first number,
and so on. We add all these multiplications. While adding, we put i-th multiplication shifted.

The approach used in below solution is to keep only one array for result. We traverse all digits first and second numbers
in a loop and add the result at appropriate position.
*/
package com.datastructure.String;

public class MultiplyLargeNumbersRepresentedAsStrings {

    static String multiply(String str1,String str2){
        int carry, sum, num1 = 0,num2;
        int arr[] = new int[str1.length()+str2.length()];

        for(int i=str1.length()-1;i>=0;i--){
            num2 = 0;
            carry = 0;
            int n1 = str1.charAt(i)-'0';

            for(int j=str2.length()-1;j>=0;j--){
                int n2 = str2.charAt(j)-'0';
                sum = (n1)*(n2) + arr[num1+num2] + carry;
                arr[num1+num2] = sum%10;
                carry = sum/10;
                num2++;
            }

            if(carry>0){
                arr[num1+num2] += carry;
            }
            num1++;
        }
        String ans="";
        Boolean flag=true;

        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]!=0 || !flag){
                ans+=arr[i];
                flag=false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "4154";
        String str2 = "51454";
        //213739916
        /*String str1 = "654154154151454545415415454";
        String str2 = "63516561563156316545145146514654";*/
        //41549622603955309777243716069997997007620439937711509062916
        /*String str1 = "1235421415454545454545454544";
        String str2 = "1714546546546545454544548544544545";*/
        //2118187521397235888154583183918321221520083884298838480662480
        /*String str1 = "123";
        String str2 = "456";*/
        //56088

        if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') &&
                (str1.charAt(0) != '-' || str2.charAt(0) != '-'))
            System.out.print("-");

        if (str1.charAt(0) == '-' &&
                str2.charAt(0) != '-')
        {
            str1 = str1.substring(1);
        }
        else if (str1.charAt(0) != '-' &&
                str2.charAt(0) == '-')
        {
            str2 = str2.substring(1);
        }
        else if (str1.charAt(0) == '-' &&
                str2.charAt(0) == '-')
        {
            str1 = str1.substring(1);
            str2 = str2.substring(1);
        }

        System.out.println(multiply(str1, str2));
    }
}
//Time Complexity: O(m*n), where m and n are length of two number that need to be multiplied