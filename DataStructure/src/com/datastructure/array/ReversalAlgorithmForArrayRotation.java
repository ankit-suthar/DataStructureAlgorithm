/*
Write a function rotate(arr[], d, n) that rotates arr[] of size n by d elements.
Example :

Input :  arr[] = [1, 2, 3, 4, 5, 6, 7]
         d = 2
Output : arr[] = [3, 4, 5, 6, 7, 1, 2]

Method 4 (The Reversal Algorithm) :

Algorithm :

rotate(arr[], d, n)
  reverse(arr[], 1, d) ;
  reverse(arr[], d + 1, n);
  reverse(arr[], 1, n);
Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is :

Reverse A to get ArB, where Ar is reverse of A.
Reverse B to get ArBr, where Br is reverse of B.
Reverse all to get (ArBr) r = BA.
Example :
Let the array be arr[] = [1, 2, 3, 4, 5, 6, 7], d =2 and n = 7
A = [1, 2] and B = [3, 4, 5, 6, 7]

Reverse A, we get ArB = [2, 1, 3, 4, 5, 6, 7]
Reverse B, we get ArBr = [2, 1, 7, 6, 5, 4, 3]
Reverse all, we get (ArBr)r = [3, 4, 5, 6, 7, 1, 2]
*/
package com.datastructure.array;

public class ReversalAlgorithmForArrayRotation {

    static void leftRotate(int[] arr,int d){
        int n = arr.length;

        if(n==0){
            return;
        }
        //Left Rotation
        swapElements(arr,0,d-1);
        swapElements(arr,d,n-1);
        swapElements(arr,0,n-1);

        //Right Rotation
        /*
        swapElements(arr,0,n-1);
        swapElements(arr,d,n-1);
        swapElements(arr,0,d-1);
        */
    }

    static void swapElements(int[] arr,int start,int end){
        int tempElement;

        while(start<end){
            tempElement = arr[start];
            arr[start] = arr[end];
            arr[end] = tempElement;
            start++;
            end--;
        }
    }

    static void printArray(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] a){
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;
        int d = 2;
        printArray(arr,arr.length);
        System.out.println();
        // in case the rotating factor is
        // greater than array length
        d = d % n;
        leftRotate(arr, d);
        printArray(arr,arr.length);
    }
}
//Time Complexity : O(n)