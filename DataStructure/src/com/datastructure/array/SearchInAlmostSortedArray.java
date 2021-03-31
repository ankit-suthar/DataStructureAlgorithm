/*
Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2
Output is index of 40 in given array

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
Output: -1
-1 is returned to indicate element is not present

The idea is to compare the key with middle 3 elements, if present then return the index.
If not present, then compare the key with middle element to decide whether to go in left half or right half.
Comparing with middle element is enough as all the elements after mid+2 must be greater than element mid
and all elements before mid-2 must be smaller than mid element.
*/
package com.datastructure.array;

public class SearchInAlmostSortedArray {

    static int searchElements(int[] arr,int l,int h,int x){
        if(l>h){
            return -1;
        }

        int mid = (l+h)/2;

        if(arr[mid]==x){
            return mid;
        }

        if(mid>l && arr[mid-1]==x){
            return mid-1;
        }

        if(mid<h && arr[mid+1]==x){
            return mid+1;
        }

        if(arr[mid]>x){
            return searchElements(arr,l,mid-2,x);
        }
        return searchElements(arr,mid+2,h,x);
    }

    public static void main(String[] a){
        int arr[] =  {10, 3, 40, 20, 50, 80, 70};
        int x = 50;
        /*int arr[] = {3, 2, 10, 4, 40};
        int x = 4;*/
        int n = arr.length;

        int result = searchElements(arr, 0, n - 1, x);
        if(result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " +
                    result);
    }
}
//Time complexity: O(Logn)