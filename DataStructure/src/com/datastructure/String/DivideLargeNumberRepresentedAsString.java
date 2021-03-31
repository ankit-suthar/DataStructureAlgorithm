/*
Given a large number (represented as string) which has to divided by another number (represented as int data type).
The large number can be very large which does not even fit in long long in C++. The task is to find division of these numbers.

Examples:

Input : number  = 1260257
        divisor = 37
Output : 34061

Input : number  = 12313413534672234
        divisor = 754
Output : 16330787181262

Input : number  = 1248163264128256512
        divisor = 125
Output : 9985306113026052
*/
package com.datastructure.String;

public class DivideLargeNumberRepresentedAsString {

    static String longDivision(String number,int divisor){
        String ans = "";
        String str;
        int index=0;

        str = Character.toString(number.charAt(0));

        while(Integer.parseInt(str)<divisor){
            str = String.valueOf(Integer.parseInt(str)*10+Integer.parseInt(Character.toString(number.charAt(++index))));
        }

        ans += Integer.parseInt(str)/divisor;
        str = String.valueOf(Integer.parseInt(str)%divisor);
        index++;

        while(index<number.length()){
            str = String.valueOf(Integer.parseInt(str)*10+Integer.parseInt(Character.toString(number.charAt(index))));
            ans += Integer.parseInt(str)/divisor;
            str = String.valueOf(Integer.parseInt(str)%divisor);
            index++;
        }

        if(ans.length()==0){
            return "0";
        }
        return ans;
    }

    public static void main(String[] a){
        /*String number = "1248163264128256512";
        int divisor = 125;*/
        //9985306113026052
        /*String number = "1260257";
        int divisor = 37;*/
        //34061
        String number = "12313413534672234";
        int divisor = 754;
        //16330787181262

        System.out.println(longDivision(number, divisor));
    }
}
