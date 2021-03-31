package com.datastructure.String;

import java.util.ArrayList;
import java.util.List;

public class SplitStringIntoPrimeNumbers {

    public static void getTheListOfPrimeNumbers(List<Integer> list,List<List> listOfList,String num){

        String temp = "";
        int n = num.length();
        for(int i=0;i<n;i++){
            temp = num.substring(0,i+1);

            if(isPrime(Integer.valueOf(temp))){

                list.add(Integer.valueOf(temp));
                getTheListOfPrimeNumbers(list,listOfList,num.substring(i+1));

                if(i==n-1){
                    List<Integer> list1 = new ArrayList<>(list);
                    listOfList.add(list1);
                }
                if(list.size()>0){
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static void main(String[] a){
        String num = "11373";
        List<Integer> list = new ArrayList<>();
        List<List> listOfList = new ArrayList<>();
        getTheListOfPrimeNumbers(list,listOfList,num);
        System.out.println(listOfList);
    }

    private static boolean isPrime(Integer num){
        if(num<=1){
            return false;
        }
        if(num==2){
            return true;
        }
        for(int i=2; i<num; ++i){
            // condition for nonprime number
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
