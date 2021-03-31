package com.algorithm.sorting;

public class BubbleSort {

    void sort(int[] arr,int n){
        boolean flag;
        for(int i=0;i<n;i++){
            flag=false;
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void printArray(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        BubbleSort bubbleSort = new BubbleSort();
        int arr[] = {3,6,5,8,9,7};
        int n = arr.length;
        bubbleSort.printArray(arr,n);
        bubbleSort.sort(arr,n);
        bubbleSort.printArray(arr,n);
    }
}
//Time complexiy: O(n^2)