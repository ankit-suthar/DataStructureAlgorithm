package com.algorithm.sorting;

public class QuickSort {

    int partition(int arr[],int l,int h){
        int pivot = h;
        int i = l-1;
        for(int j=l;j<h;j++){
            if(arr[j]<arr[pivot]){
                i++;
                swap(arr,i,j);
            }
        }
        i++;
        swap(arr,i,pivot);
        return i;
    }

    void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    void sort(int arr[],int l,int h){
        if(l<h){
            int part = partition(arr,l,h);
            sort(arr,l,part-1);
            sort(arr,part,h);
        }
    }

    void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        QuickSort quickSort = new QuickSort();
        int arr[] = {10, 7, -4, 8, 9, 400, 1, 5,100};
        int n = arr.length;
        System.out.println("Array before sorting: ");
        quickSort.printArray(arr);
        quickSort.sort(arr,0,n-1);
        System.out.println("Array after sorting: ");
        quickSort.printArray(arr);

    }
}
//Time Complexity: O(n^2)