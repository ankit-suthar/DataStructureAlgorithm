package com.datastructure.array;

public class LongestSpanWithSameSumInTwoBinaryArrays {

    static int longestCommonSum(int[] arr1,int[] arr2){
        int arr[] = new int[arr1.length];
        int max = Integer.MAX_VALUE;

        for(int i=0;i<arr1.length;i++){
            arr[i] = arr1[i] - arr2[i];
        }

        for(int i=0;i<arr1.length;i++){

        }
        return max;
    }

    public static void main(String[] a){
        int arr1[] = new int[]{0, 1, 0, 1, 1, 1, 1};
        int arr2[] = new int[]{1, 1, 1, 1, 1, 0, 1};

        System.out.println(longestCommonSum(arr1,arr2));
    }
}
