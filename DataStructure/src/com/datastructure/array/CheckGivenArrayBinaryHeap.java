/*
Given an array, how to check if the given array represents a Binary Max-Heap.

Examples:

Input:  arr[] = {90, 15, 10, 7, 12, 2}
Output: True
The given array represents below tree
       90
     /    \
   15      10
  /  \     /
 7    12  2
The tree follows max-heap property as every
node is greater than all of its descendants.

Input:  arr[] = {9, 15, 10, 7, 12, 11}
Output: False
The given array represents below tree
       9
     /    \
   15      10
  /  \     /
 7    12  11
The tree doesn't follows max-heap property 9 is
smaller than 15 and 10, and 10 is smaller than 11.
*/
package com.datastructure.array;

public class CheckGivenArrayBinaryHeap {

    static boolean checkBinaryHeap(int[] arr,int n){

        for(int i=n/2;i>=0;i--){
            int x = i*2 + 1;
            int y = i*2 + 2;

            if(x<n && arr[x]>arr[i]){
                return false;
            }

            if(y<n && arr[y]>arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        //int arr[] = {90, 15, 10, 7, 12, 2, 7, 3}; // Yes
        //int arr[] = {9, 15, 10, 7, 12, 11}; // No
        int arr[] = {90, 15, 10, 7, 12, 2}; // Yes

        if(checkBinaryHeap(arr,arr.length)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
//Time Complexity: log n