/*
A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.
Examples:

Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1

A simple solution is to traverse the complete array and find minimum. This solution requires O(n) time.
We can do it in O(Logn) using Binary Search. If we take a closer look at above examples, we can easily figure out following pattern:

The minimum element is the only element whose previous is greater than it.
If there is no previous element element, then there is no rotation (first element is minimum).
We check this condition for middle element by comparing it with (mid-1)’th and (mid+1)’th elements.
If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half or right half.
If middle element is smaller than last element, then the minimum element lies in left half
Else minimum element lies in right half.
*/
package com.datastructure.array;

public class FindMinimumElementInSortedRotatedArray {

    static int getMinElement(int[] arr,int l,int h){
        int n = arr.length;
        int mid = (l+h)/2;

        if(l>h){
            return arr[0];
        }

        if(l==h){
            return arr[l];
        }

        if(mid<h && arr[mid]>arr[mid+1]) {
            return arr[mid + 1];
        }

        if(mid>l && arr[mid]<arr[mid-1]){
            return arr[mid];
        }

        if(arr[h]>arr[mid]){
            return getMinElement(arr,l,mid-1);
        }
        return getMinElement(arr,mid+1,h);
    }

    public static void main(String[] a){
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int n1 = arr1.length;
        System.out.println("The minimum element is "+ getMinElement(arr1, 0, n1-1));

        int arr2[] =  {1, 2, 3, 4};
        int n2 = arr2.length;
        System.out.println("The minimum element is "+ getMinElement(arr2, 0, n2-1));

        int arr3[] =  {1};
        int n3 = arr3.length;
        System.out.println("The minimum element is "+ getMinElement(arr3, 0, n3-1));

        int arr4[] =  {1, 2};
        int n4 = arr4.length;
        System.out.println("The minimum element is "+ getMinElement(arr4, 0, n4-1));

        int arr5[] =  {2, 1};
        int n5 = arr5.length;
        System.out.println("The minimum element is "+ getMinElement(arr5, 0, n5-1));

        int arr6[] =  {5, 6, 7, 1, 2, 3, 4};
        int n6 = arr6.length;
        System.out.println("The minimum element is "+ getMinElement(arr6, 0, n6-1));

        int arr7[] =  {1, 2, 3, 4, 5, 6, 7};
        int n7 = arr7.length;
        System.out.println("The minimum element is "+ getMinElement(arr7, 0, n7-1));

        int arr8[] =  {2, 3, 4, 5, 6, 7, 8, 1};
        int n8 = arr8.length;
        System.out.println("The minimum element is "+ getMinElement(arr8, 0, n8-1));

        int arr9[] =  {3, 4, 5, 1, 2};
        int n9 = arr9.length;
        System.out.println("The minimum element is "+ getMinElement(arr9, 0, n9-1));
    }
}
//Time complexity: O(Logn)