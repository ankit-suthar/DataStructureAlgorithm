package com.datastructure.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalSumOfAllNumInStringMthd1 {

    static void findSum(String str){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher m = pattern.matcher(str);
        int sum = 0;

        while(m.find()){
            sum += Integer.parseInt(m.group());
        }
        System.out.println(sum);
    }

    public static void main(String[] a){
        //String str = "1abc23"; //24
        String str = "geeks4geeks"; //4
        //String str = "1abc2x30yz67"; //100
        //String str = "123abc"; //123
        findSum(str);
    }
}
