package com.datastructure.array;

public class PrintLeftRotation {

    static void leftRotate(int[] arr,int n,int k){
        int mod = k % n;

        for(int i=0;i<n;i++){
            System.out.print(arr[(i+mod) % n]+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        int arr[] = { 1, 3, 5, 7, 9 };  //5 7 9 1 3
        int n = arr.length;
        int k = 2;
        /*int arr[] = { 1, 3, 5, 7, 9 }; // 9 1 3 5 7
        int n = arr.length;
        int k = 14;*/
        leftRotate(arr,n,k);
    }
}
//Time Complexity: O(n)