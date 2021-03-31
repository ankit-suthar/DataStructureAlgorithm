package com.datastructure.array;

public class ArrayRotationLeft {

    static void rotateArray(int[] arr,int n,int d){
        rotateArrayUtil(arr,0,d-1);
        rotateArrayUtil(arr,d,n-1);
        rotateArrayUtil(arr,0,n-1);
    }

    static void rotateArrayUtil(int arr[],int start,int end){
        int temp;
        while(start<end){
            temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    static void printArray(int[] arr){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
    }

    public static void main(String[] a){
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 2;
        printArray(arr);
        rotateArray(arr,n,d);
        System.out.println();
        printArray(arr);
    }
}
//Time complexity : O(n)
//Auxiliary Space : O(1)