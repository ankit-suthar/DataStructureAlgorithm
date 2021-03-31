/*
Given an array with positive and negative numbers, find the maximum average subarray of given length.
Example:

Input:  arr[] = {1, 12, -5, -6, 50, 3}, k = 4
Output: Maximum average subarray of length 4 begins
        at index 1.
Maximum average is (12 - 5 - 6 + 50)/4 = 51/4
*/
package com.datastructure.array;

public class FindMaxAvgSubarrayOfKLength {

    static void findMaxAverage(int[] arr,int n,int k){
        int maxFar = 0, maxAvg = Integer.MIN_VALUE;
        int start = 0, s = 0, avg;

        for(int i=0;i<n;i++){
            maxFar += arr[i];

            if(i>=k-1){
                if (i - (k - 1) != 0) {
                    maxFar = maxFar - arr[start];
                    start += 1;
                }
                avg = (maxFar/k);

                if(maxAvg < avg){
                    maxAvg = avg;
                    s = start;
                }
            }
        }

        System.out.println("Range is: " +s+ " - " +(s+k-1)+ ",average value is: "+maxAvg);
    }

    public static void main(String[] a){
        int arr[] = {1, 12, -5, -6, 50, 3};
        int k = 4;
        int n = arr.length;
        findMaxAverage(arr,n,k);
    }
}
//Time complexity: O(n)