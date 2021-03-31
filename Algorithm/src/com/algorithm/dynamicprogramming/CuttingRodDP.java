package com.algorithm.dynamicprogramming;

public class CuttingRodDP {

    int maxValueFromCuttingRod(int arr[],int size){
        int[] c = new int[size+1];
        c[0]=0;
        int max_val;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<=size;i++){
            max_val = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                max_val = Math.max(max_val,arr[j] + c[i-j-1]);
                if(max<max_val){
                    max=max_val;
                }
            }
            c[i] = max_val;
        }
        return max;
    }

    public static void main(String[] a){
        CuttingRodDP cr = new CuttingRodDP();
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+cr.maxValueFromCuttingRod(arr,size));
    }
}
//Time Complexity: O(n^2)
