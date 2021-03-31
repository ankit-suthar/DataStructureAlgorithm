/*
Find start and end range of an element in sorted array.
*/
package com.datastructure.array;

public class FindStartAndEndRangeOfElementInSortedArray {

    static void searchRangeUtilHigher(int[] arr,int l,int h,int target,int[] ans){
        if(l>h){
            ans[1]=-1;
            return;
        }

        int mid = (l+h)/2;

        if((mid==arr.length-1 || mid==h) && target==arr[mid]){
            ans[1]=mid;
            return;
        }else if(mid<h && arr[mid]==target && arr[mid+1]>target){
            ans[1]=mid;
            return;
        }else if(arr[mid]>target){
            searchRangeUtilHigher(arr,l,mid-1,target,ans);
        }else if(arr[mid]<target){
            searchRangeUtilHigher(arr,mid+1,h,target,ans);
        }else{
            searchRangeUtilHigher(arr,mid+1,h,target,ans);
        }
    }

    static void searchRangeUtilLower(int[] arr,int l,int h,int target,int[] ans){
        if(l>h){
            ans[0]=-1;
            return;
        }

        int mid = (l+h)/2;

        if((mid==0 || mid==l) && target==arr[mid]){
            ans[0]=mid;
            return;
        }else if(l<mid && arr[mid-1]<target && arr[mid]==target){
            ans[0]=mid;
            return;
        }else if(arr[mid]>target){
            searchRangeUtilLower(arr,l,mid-1,target,ans);
        }else if(arr[mid]<target){
            searchRangeUtilLower(arr,mid+1,h,target,ans);
        }else{
            searchRangeUtilLower(arr,l,mid-1,target,ans);
        }
    }

    static void searchRange(int arr[],int n,int target){
        int[] ans = new int[2];
        searchRangeUtilLower(arr,0,n-1,target,ans);
        searchRangeUtilHigher(arr,0,n-1,target,ans);
        System.out.println(ans[0]+" "+ans[1]);
    }

    public static void main(String[] a){
        int[] arr = {5,7,8,8,8,8};
        int n = arr.length;
        int target = 6;
        searchRange(arr,n,target);
    }
}
