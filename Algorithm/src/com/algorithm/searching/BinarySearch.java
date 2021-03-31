package com.algorithm.searching;

/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;*/

import java.util.*;
import java.util.stream.*;

public class BinarySearch {

    public static int searchElement(int arr[],int l,int h,int ele){

        if (l > h) {
            return -1;
        }

        int mid = (l+h)/2;

        if(arr[mid]==ele){
            return mid;
        }

        if(arr[mid]>ele){
            return searchElement(arr,l,mid-1,ele);
        }
        return searchElement(arr,mid+1,h,ele);
    }

    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] a){
        int arr[]={6,3,45,8,2,9,78};
        int ele = 45;
        Arrays.sort(arr);
        int index = searchElement(arr,0,arr.length-1,ele);
        printArray(arr);
        System.out.println("Index of "+ele+" is "+index);
    }
}
