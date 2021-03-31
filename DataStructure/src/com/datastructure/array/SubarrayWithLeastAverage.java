/*
Given an array arr[] of size n and integer k such that k <= n.
Examples :

Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3
Output: Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average
among all subarrays of size 3.

Input:  arr[] = {3, 7, 5, 20, -10, 0, 12}, k = 2
Output: Subarray between [4, 5] has minimum average
*/
package com.datastructure.array;

public class SubarrayWithLeastAverage {

    static void findMinAvgSubarray(int[] arr,int n,int k){
        int sum = 0, minAvg = Integer.MAX_VALUE, start = 0, avg, s = 0, e = 0;

        for(int i=0;i<n;i++){
            sum += arr[i];

            if(i >= k-1){
                avg = sum/k;
                if(minAvg > avg){
                    s = start;
                    e = i;
                    minAvg = avg;
                }
                sum -= arr[start];
                start++;
            }
        }
        System.out.println("Subarray between ["+s+", "+e+"] has minimum average");
    }

    public static void main(String[] a){
        /*int arr[] = { 3, 7, 90, 20, 10, 50, 40 }; //Subarray between [3, 5] has minimum average
        int n = arr.length;
        int k = 3;*/

        int arr[] = {3, 7, 5, 20, -10, 0, 12}; //Subarray between [4, 5] has minimum average
        int n = arr.length;
        int k = 2;
        findMinAvgSubarray(arr, n, k);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(1)