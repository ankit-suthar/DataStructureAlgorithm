/*
Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.
Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

Method 1 (Simple)
A simple method is to use two nested loops. The outer loop picks a starting point i. The inner loop considers all subarrays starting from i.
If size of a subarray is greater than maximum size so far, then update the maximum size.
In the below code, 0s are considered as -1 and sum of all values from i to j is calculated.
If sum becomes 0, then size of this subarray is compared with largest size so far.
*/
package com.datastructure.array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayEqualNumberOf0sAnd1sMthd1 {

    static void findSubArray(int[] arr,int size){
        Map<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLength=0;
        int end=0;

        for(int i=0;i<size;i++){
            arr[i]=(arr[i]==0)?-1:1;
        }

        for(int i=0;i<size;i++){
            sum+=arr[i];

            if(sum==0){
                maxLength=i+1;
                end=i;
            }

            if(hm.containsKey(sum)){
                if(maxLength<i-hm.get(sum)){
                    maxLength=i-hm.get(sum);
                    end=i;
                }
            }else{
                hm.put(sum,i);
            }
        }

        for(int i=0;i<size;i++){
            arr[i]=(arr[i]==-1)?0:1;
        }
        System.out.println( (end-maxLength+1)+" to "+end);
    }

    public static void main(String[] a){
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        int size = arr.length;

        findSubArray(arr, size);
    }
}
//Time Complexity: O(n)
// Auxiliary Space: O(1)