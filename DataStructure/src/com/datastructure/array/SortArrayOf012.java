/*
Given an array A[] consisting 0s, 1s and 2s.
The task is to write a function that sorts the given array.
The functions should put all 0s first, then all 1s and all 2s in last.
*/
package com.datastructure.array;

public class SortArrayOf012 {

    static void sort012(int[] arr,int n){
        int low=0, mid=0, high=n-1;

       while(mid <= high){
           if(arr[mid]==0){
               swap(arr,low,mid);
               low++;
               mid++;
           }else if(arr[mid]==1){
               mid++;
           }else{
               swap(arr,mid,high);
               high--;
           }
       }
    }

    static void swap(int[] arr,int i1,int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    static void printArray(int[] arr){
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 }; // 0 0 0 0 0 1 1 1 1 1 2 2
        //int arr[] = {0, 1, 2, 0, 1, 2}; // 0 0 1 1 2 2
//            int arr[] = {0, 2, 1}; // 0 1 2
            int n = arr.length;
            System.out.println("Array before seggregation ");
            printArray(arr);
            sort012(arr, n);
            System.out.println("Array after seggregation ");
            printArray(arr);
    }
}
//Time Complexity: O(n)
//Auxillury Space: O(1)