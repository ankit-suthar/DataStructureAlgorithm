package com.algorithm.searching;

public class LinearSearch {

    int linearSearch(int arr[],int n,int element){
            for(int i=0;i<n;i++){
                if(arr[i]==element){
                    return i;
                }
            }
            return -1;
    }

    public static void main(String[] a){
        LinearSearch ls = new LinearSearch();
        int arr[] = {3,6,2,9,8,1};
        int index = ls.linearSearch(arr,arr.length,6);
        if(index!=-1){
            System.out.println("Element is at position: "+index);
        }else{
            System.out.println("Element is not present in the array");
        }
    }
}
