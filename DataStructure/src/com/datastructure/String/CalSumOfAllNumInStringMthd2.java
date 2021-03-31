package com.datastructure.String;

public class CalSumOfAllNumInStringMthd2 {

    static void findSum(String str){
        int sum=0;
        String temp="";

        for(int i=0;i<str.length();i++){
            temp="";

            while(i<str.length() && str.charAt(i)>=48 && str.charAt(i)<=57){
                temp+=Character.toString(str.charAt(i));
                i++;
            }
            if(temp.length()>0){
                sum+= Integer.parseInt(temp);
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] a){
        //String str = "1abc23"; //24
        //String str = "geeks4geeks"; //4
        //String str = "1abc2x30yz67"; //100
        //String str = "123abc"; //123
        String str = "12abc20yz68"; //100
        findSum(str);
    }
}
//Time complexity: O(n), where n is length of the string