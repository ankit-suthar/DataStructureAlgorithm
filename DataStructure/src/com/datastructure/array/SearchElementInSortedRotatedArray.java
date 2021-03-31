/*
An element in a sorted array can be found in O(log n) time via binary search.
But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.

sortedPivotedArray

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10
Output : Found at index 3

The idea is to find the pivot point, divide the array in two sub-arrays and call binary search.
The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array,
pivot element is the only element for which next element to it is smaller than it.
Using above criteria and binary search methodology we can get pivot element in O(logn) time

Input arr[] = {3, 4, 5, 1, 2}
Element to Search = 1
  1) Find out pivot point and divide the array in two
      sub-arrays. (pivot = 2) //Index of 5
  2) Now call binary search for one of the two sub-arrays.
          (a) If element is greater than 0th element then
          search in left array
          (b) Else Search in right array
          (1 will go in else as 1 < 0th element(3))
  3) If element is found in selected sub-array then return index
     Else return -1.
*/
package com.datastructure.array;

public class SearchElementInSortedRotatedArray {

    static int searchElement(int [] arr,int l,int h,int ele){

        if(l>h){
            return -1;
        }

        int mid = (l+h)/2;

        if(arr[mid]==ele){
            return mid;
        }

        if(arr[mid]>arr[l]){
            if(ele>=arr[l] && ele<arr[mid]){
                return searchElement(arr,l,mid-1,ele);
            }
            return searchElement(arr,mid+1,h,ele);
        }

        if(ele>=arr[mid] && ele<=arr[h]){
            return searchElement(arr,mid+1,h,ele);
        }
        return searchElement(arr,l,mid-1,ele);
    }

    public static void main(String[] a){
        /*int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};  //index: 8
        int n = arr.length;
        int key = 3;*/

       /* int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; //index: -1
        int n = arr.length;
        int key = 30;*/

        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3}; //index: 2
        int n = arr.length;
        int key = 6;
        int i = searchElement(arr, 0, n-1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }
}
//Time Complexity: O(logn)