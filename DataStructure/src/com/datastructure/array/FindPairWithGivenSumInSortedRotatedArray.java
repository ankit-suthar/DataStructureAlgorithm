/*
Given an array that is sorted and then rotated around an unknown point.
Find if the array has a pair with a given sum ‘x’. It may be assumed that all elements in the array are distinct.
Examples :

Input: arr[] = {11, 15, 6, 8, 9, 10}, x = 16
Output: true
There is a pair (6, 10) with sum 16

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 35
Output: true
There is a pair (26, 9) with sum 35

Input: arr[] = {11, 15, 26, 38, 9, 10}, x = 45
Output: false
There is no pair with sum 45.
*/
package com.datastructure.array;

public class FindPairWithGivenSumInSortedRotatedArray {

    static int getMinElementIndex(int[] arr,int l,int h){

        if(l>h){
            return 0;
        }

        if(l==h){
            return l;
        }

        int mid = (l+h)/2;

        if(mid < h && arr[mid] > arr[mid+1]){
            return mid+1;
        }

        if(mid > l && arr[mid] < arr[mid-1]){
            return mid;
        }

        if(arr[mid]<arr[h]){
            return getMinElementIndex(arr,l,mid-1);
        }
        return getMinElementIndex(arr,mid+1,h);
    }

    static boolean getPairOfSumInSortedRotatedArray(int[] arr,int n,int sum){

        //int l = getMinElementIndex(arr,0,n-1);
        int minIndex = getMinElementIndex(arr,0,n-1);
        int l = minIndex, r = (minIndex-1+n)%n;

        while(l!=r){
            if(arr[l]+arr[r]==sum){
                return true;
            }else if(arr[l]+arr[r]>sum){
                r = (r-1+n)%n;
            }else if(arr[l]+arr[r]<sum){
                l = (l+1)%n;
            }
        }

        return false;
        /*int h = (n+(l-1))%n;

        while(l!=h){
            if(arr[l]+arr[h]==sum){
                return true;
            }else if(arr[l]+arr[h]>sum){
                h--;
                if(h<0){
                  h = h+n;
                }
            }else{
                l++;
                if(l==n){
                    l = l%n;
                }
            }
        }
        return false;*/
    }

    public static void main(String[] a){
        /*int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 16;
        int n = arr.length;*/
        //true

        /*int arr[] = {11, 15, 26, 38, 9, 10};
        int sum = 35;
        int n = arr.length;*/
        //true

        int arr[] = {11, 15, 6, 8, 9, 10};
        int sum = 45;
        int n = arr.length;
        System.out.println(getPairOfSumInSortedRotatedArray(arr,n,sum));
    }
}
//Time Complexity: O(nlogn)
//Auxiliary Space: O(1)