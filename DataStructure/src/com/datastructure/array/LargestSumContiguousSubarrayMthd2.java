package com.datastructure.array;

public class LargestSumContiguousSubarrayMthd2 {

    static void getLongestSumContiguousSubarray(int[] arr,int n){
        int sum=0;
        int max_sum_far=Integer.MIN_VALUE;
        int start=0,s=0,end=0;

        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>max_sum_far){
                max_sum_far=sum;
                start = s;
                end = i;
            }

            if(sum<0){
                sum=0;
                s = i+1;
            }
        }
        System.out.println("Maximum contiguous sum is "+max_sum_far);
        System.out.println("Starting index: "+start);
        System.out.println("Ending index: "+end);
    }

    public static void main(String[] a){
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = arr.length;
        getLongestSumContiguousSubarray(arr,n);
    }
}
//Time complexity: O(n)
//Space Complexity: O(1)