/*
Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
Examples:

Input: K = 4, X = 35
       arr[] = {12, 16, 22, 30, 35, 39, 42,
               45, 48, 50, 53, 55, 56}
Output: 30 39 42 45


*/
package com.datastructure.array;

import java.util.Arrays;

public class FindKClosestElementsToGivenValue {

    static int getIndexOfElement(int[] arr,int l,int h,int x){

        if(l>h){
            return 0;
        }

        int mid = (l+h)/2;

        if(arr[mid] <= x && arr[mid+1]>x){
            return mid;
        }

        if(arr[mid]>x){
            return getIndexOfElement(arr,l,mid-1,x);
        }

        return getIndexOfElement(arr,mid+1,h,x);
    }

    static void printKClosestElements(int[] arr,int n,int x,int k){
        Arrays.sort(arr);

        for(int element:arr){
            System.out.print(element+" ");
        }
        System.out.println();

        int index = getIndexOfElement(arr,0,n-1,x);

        if(index==0){
            for(int i=index+1;i<=k;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        int low = index, high = index+1;
        int count = 0;

        if(arr[low]==x){
            low--;
        }

        while(low>=0 && high<n && low<high && count<k){

            if(x - arr[low]< arr[high] - x){
                System.out.print(arr[low]+" ");
                low--;
            }else{
                System.out.print(arr[high]+" ");
                high++;
            }
            count++;
        }
    }

    public static void main(String[] a){
        int arr[] = {35, 39, 42, 45, 12, 16, 50, 53, 55, 56, 22, 30,  48};
        int n = arr.length;
        int x = 35;
        int k = 4;
        printKClosestElements(arr,n,x,k);
    }
}
//Time complexity: O(n log n) + k