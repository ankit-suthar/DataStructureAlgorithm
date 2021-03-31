package com.algorithm.sorting;

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int arr[],int n){
        for(int i=1;i<n;i++){
            int j = i-1;
            int key = arr[i];

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] a){
        int arr[] = { 12, 11, 13, 5, 6 };
        int n = arr.length;
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
        insertionSort(arr,n);
        System.out.println();
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(1)