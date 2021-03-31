/*
Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far

*/
package com.algorithm.dynamicprogramming;

public class LargestSumContiguousSubarray {

    static void maxSubArraySum(int[] arr,int n){
        int farSum = 0, maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0;

        for(int i=0;i<n;i++){
            farSum += arr[i];
            if(farSum > maxSum){
                maxSum = farSum;
                end = i;
            }
            if(farSum < 0){
                farSum = 0;
                start = i+1;
            }
        }
        System.out.println("Maximum contiguous sum is "+maxSum);
        System.out.println("Starting index: "+start+"\nEnding index: "+end);
    }

    public static void main(String[] a){
        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        maxSubArraySum(arr,n);
    }
}
//Time Complexity: O(n)