/*
Given an unsorted array arr[] and two numbers x and y, find the minimum distance between x and y in arr[].
The array might also contain duplicates. You may assume that both x and y are different and present in arr[].

Examples:

Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3},  x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3},  x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
*/
package com.datastructure.array;

public class MinDistanceBetweenTwoNumbersMthd2 {

    static int minDistance(int[] arr,int n,int x,int y){
        int index = -1;
        int minDist = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            if(arr[i]==x || arr[i]==y){

                if(index!=-1 && arr[i]!=arr[index]){
                    minDist = Math.min(minDist,Math.abs(i-index));
                }
                index=i;
            }

        }
        return minDist;
    }

    public static void main(String[] a){
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;

        System.out.println("Minimum distance between " + x + " and " + y
                + " is " + minDistance(arr, n, x, y));
    }
}
//Time Complexity: O(n)