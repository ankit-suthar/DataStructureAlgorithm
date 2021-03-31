/*
Given an unsorted array, find the minimum difference between any pair in given array.

Examples :

Input  : {1, 5, 3, 19, 18, 25};
Output : 1
Minimum difference is between 18 and 19

Input  : {30, 5, 20, 9};
Output : 4
Minimum difference is between 5 and 9

Input  : {1, 19, -4, 31, 38, 25, 100};
Output : 5
Minimum difference is between 1 and -4
*/
package com.datastructure.array;

import java.util.Arrays;

public class FindMinDiffBTAnyTwoElements {

    static int findMinDiff(int[] arr,int n){

        if (n <= 1) {
            return 0;
        }

        int minDist = Integer.MAX_VALUE;

        Arrays.sort(arr);

        int firstIndex = 0, secondIndex = 1, diff;

        while(secondIndex<n){
            diff = Math.abs(arr[firstIndex]-arr[secondIndex]);
            if(diff < minDist){
                minDist = diff;
            }
            firstIndex++;
            secondIndex++;
        }
        return minDist;
    }

    public static void main(String[] a){
        //int arr[] = new int[]{1, 5, 3, 19, 18, 25}; //1
        //int arr[] = new int[]{1, 19, -4, 31, 38, 25, 100}; //5
        int arr[] = new int[]{30, 5, 20, 9}; //4

        System.out.println("Minimum difference is "+ findMinDiff(arr, arr.length));
    }
}
//Sorting Takes : Time Complexity: O(n Log n)
//Initialise diff: Time Complexity: O(1)
//Find Min: Time Complexity: O(n)