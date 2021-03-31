/*
Consider an array of distinct numbers sorted in increasing order.
The array has been rotated (clockwise) k number of times.
Given such an array, find the value of k.

Examples:

Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0

Here also we find the index of minimum element, but using Binary Search. The idea is based on the below facts :

The minimum element is the only element whose previous is greater than it.
If there is no previous element, then there is no rotation (first element is minimum).
We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.
If the minimum element is not at the middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
If middle element is smaller than last element, then the minimum element lies in left half
Else minimum element lies in right half.
*/
package com.datastructure.array;

public class FindRotationCountInRotatedSortedArray {

    static int countRotations(int[] arr,int l,int h){

        if(l>h){
            return 0;
        }

        if(l==h){
            return l;
        }

        int mid = (l+h)/2;

        if(mid>l && arr[mid-1]>arr[mid]){
            return mid;
        }

        if(mid<h && arr[mid]>arr[mid+1]){
            return mid+1;
        }

        if(arr[mid] > arr[h]){
            return countRotations(arr,mid+1,h);
        }

        return countRotations(arr,l,mid-1);
        /*if(arr[mid]>arr[l]){
            return countRotations(arr,mid+1,h);
        }

        return countRotations(arr,l,mid-1);*/
    }

    public static void main(String[] a){
        //int arr[] = {15, 18, 2, 3, 6, 12}; //2
        int arr[] = {4, 5, 6, 7, 8, 1, 2, 3}; //5
        //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8}; //0
        //int arr[] = {8, 1, 2, 3, 4, 5, 6, 7}; //1
        //int arr[] = {7, 9, 11, 12, 5}; //4
        //int arr[] = {7, 9, 11, 12, 15}; //0
        int n = arr.length;

        System.out.println(countRotations(arr, 0, n-1));
    }
}
//Time Complexity : O(Log n)
//Auxiliary Space : O(1)