package com.algorithm.sorting;

import java.util.Arrays;

public class SelectionSort {

    static void selectionSort(int[] arr,int n){

        for(int i=0;i<n-1;i++){
            int maxValIndex = i;

            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[maxValIndex]){
                    maxValIndex=j;
                }
            }
            swap(arr,i,maxValIndex);
        }
    }

    static void swap(int[] arr,int i,int j){
        int tempValue = arr[i];
        arr[i] = arr[j];
        arr[j] = tempValue;
    }

    public static void main(String args[]){
        int arr[] = {64,25,12,22,11};
        int n = arr.length;
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
        selectionSort(arr,n);
        System.out.println();
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
    }
}
//Time Complexity: O(n^2)
//Space Complexity: O(1)