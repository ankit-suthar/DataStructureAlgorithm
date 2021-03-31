package com.algorithm.sorting;

import java.util.Arrays;

public class RadixSort {

    static void radixSortUtil(int[] arr,int n,int exp){
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count,0);

        for(int i=0;i<n;i++){
            count[(arr[i]/exp)%10]++;
        }

        for(int i=1;i<10;i++){
            count[i] += count[i-1];
        }

        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }

    static int getMaxValue(int[] arr,int n){
        int max = arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

    static void radixSort(int[] arr,int n){

        int maxVal = getMaxValue(arr,n);

        for(int exp=1;maxVal/exp>0;exp*=10){
            radixSortUtil(arr,n,exp);
        }
    }

    public static void main(String[] a){
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
        radixSort(arr,n);
        System.out.println();
        Arrays.stream(arr).forEach(e->System.out.print(e+" "));
    }
}
//Time complexity: O(kn) for n keys which are integers of word size k