package com.company.question.mygate;

import java.util.ArrayList;
import java.util.List;

public class SetsForGivenRangeOfSum {

    static void countChange(int arr[], int arrayLength, int sumLowerRange, int sumUpperRange
            , int sum, int index, List<Integer> changeList, List<List<Integer>> listOfList){

        if(sum > sumLowerRange && sum < sumUpperRange){
            listOfList.add(new ArrayList<>(changeList));
        }

        if(sum > sumUpperRange){
            return;
        }

        if(arrayLength<=0){
            return;
        }

        changeList.add(index,arr[arrayLength-1]);
        countChange(arr,arrayLength-1, sumLowerRange, sumUpperRange, sum+arr[arrayLength-1],index+1,changeList,listOfList);
        changeList.remove(index);
        countChange(arr,arrayLength-1, sumLowerRange, sumUpperRange,sum, index,changeList,listOfList);
    }

    public static void main(String[] a){
        int arr[] = {10,15,5,10,25,6,5,30,2,15};
        // array length
        int arrayLength = arr.length;

        int sumLowerRange = 20;

        int sumUpperRange = 40;

        List<Integer> change = new ArrayList<>();

        // List to store list of valid changes
        List<List<Integer>> listOfList = new ArrayList<>();

        countChange(arr, arrayLength, sumLowerRange, sumUpperRange,0, 0, change,listOfList);

        System.out.println(listOfList);
    }
}
