package com.algorithm.dynamicprogramming;

public class CuttingRod {

    int maxValueFromCuttingRod(int arr[],int size){
        if(size<=0){
            return 0;
        }

        int max_val = Integer.MIN_VALUE;

        for(int i=0;i<size;i++){
            max_val = Math.max(max_val,arr[i] + maxValueFromCuttingRod(arr,size-i-1));
        }
        return max_val;
    }

    public static void main(String[] a){
        CuttingRod cr = new CuttingRod();
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+cr.maxValueFromCuttingRod(arr,size));
    }
}
