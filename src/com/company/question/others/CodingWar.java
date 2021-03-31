package com.company.question.others;

import java.util.ArrayList;
import java.util.List;

public class CodingWar {

    public static void getTheListOfPrimeNumbers(List<Integer> list,List<List> listOfList,int index,int length,int[] num,int prev,int size,int count){

        if(list.size()==size){
            listOfList.add(list);
            return;
        }

        for(int i=index;i<length;i++){

            if(prev!=Integer.MIN_VALUE){
                if(prev>num[i]){
                    list.add(count,num[i]);
                    getTheListOfPrimeNumbers(list,listOfList,i+1,length,num,num[i],size,count+1);
                }else{
                    continue;
                }
            }else{
                list.add(count,num[i]);
                getTheListOfPrimeNumbers(list,listOfList,i+1,length,num,num[i],size,count+1);
            }

            list.remove(count);
        }
    }

    public static void getTheListOfPrimeNumbersLess(List<Integer> list,List<List> listOfList,int index,int length,int[] num,int prev,int size,int count){

        if(list.size()==size){
            listOfList.add(list);
            return;
        }

        for(int i=index;i<length;i++){

            if(prev!=Integer.MAX_VALUE){
                if(prev<num[i]){
                    list.add(count,num[i]);
                    getTheListOfPrimeNumbersLess(list,listOfList,i+1,length,num,num[i],size,count+1);
                }else{
                    continue;
                }
            }else{
                list.add(count,num[i]);
                getTheListOfPrimeNumbersLess(list,listOfList,i+1,length,num,num[i],size,count+1);
            }

            list.remove(count);
        }
    }

    public static void main(String[] a){
        int arr[] = new int[]{5,2,3,1,4};
        int count;
        List<Integer> list = new ArrayList<>();
        List<List> listOfList = new ArrayList<>();

        getTheListOfPrimeNumbers(list,listOfList,0,arr.length,arr,Integer.MIN_VALUE,3,0);
        count = listOfList.size();

        list = new ArrayList<>();
        listOfList = new ArrayList<>();

        getTheListOfPrimeNumbersLess(list,listOfList,0,arr.length,arr,Integer.MAX_VALUE,3,0);
        count += listOfList.size();
        System.out.println(count);
    }
}
