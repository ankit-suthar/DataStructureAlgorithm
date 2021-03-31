package com.algorithm.sorting;

public class HeapSort {

    void hepify(int[] arr,int n,int index){
        int i = index;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && arr[i]<arr[l]){
            i=l;
        }

        if(r<n && arr[i]<arr[r]){
            i=r;
        }

        if(i!=index){
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            hepify(arr,n,i);
        }
    }

    void sort(int[] arr,int n){

        for(int i=n/2-1;i>=0;i--){
            hepify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            hepify(arr,i,0);
        }
    }

    void printArray(int arr[],int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        HeapSort heapSort = new HeapSort();
        int arr[] = {3,6,5,8,9,7,1};
        int n = arr.length;
        heapSort.printArray(arr,n);
        heapSort.sort(arr,n);
        heapSort.printArray(arr,n);
    }
}
//Time complexiy: O(nlogn)