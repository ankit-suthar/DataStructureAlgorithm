package com.datastructure.array;

public class LargestSumContiguousSubarrayMthd1 {

    static int getLongestSumContiguousSubarray(int[] arr,int n){
        int sum=0;
        int max_sum_far=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>max_sum_far){
                max_sum_far=sum;
            }

            if(sum<0){
                sum=0;
            }
        }
        return max_sum_far;
    }

    public static void main(String[] a){
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;

        int longestLength = getLongestSumContiguousSubarray(arr,n);
        System.out.println(longestLength);
    }
}
//Time complexity: O(n)
//Space Complexity: O(1)