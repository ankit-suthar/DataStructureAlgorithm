/*
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8
*/
package com.datastructure.array;

public class SmallestSubarraySumGreaterThanGivenValue {

    static int smallestSubWithSum(int[] arr,int n,int x){
        int sum = 0, len = Integer.MAX_VALUE, start = 0;

        for(int i=0;i<n;i++){

            if(arr[i] > x){
                return 1;
            }

            sum += arr[i];

            if(sum <= 0 && x > 0){
                sum = 0;
                start = i+1;
                continue;
            }

            while(sum > x){
                if(len > (i-start+1)){
                    len = i - start + 1;
                }

                sum -= arr[start];
                start++;
            }
        }
        return len;
    }

    public static void main(String[] a){
            int arr[] = {1, 4, 45, 6, 10, 19};
            int x = 51;
            int n = arr.length;
            int res = smallestSubWithSum(arr,n, x);
            if(res==Integer.MAX_VALUE){
                System.out.println("Length not found");
            }else{
                System.out.println("Length found: "+res);
            }

        arr = new int[]{1, 10, 5, 2, 7};

        n = arr.length;
        x = 9;
        res = smallestSubWithSum(arr, n, x);
        if (res == Integer.MAX_VALUE) {
            System.out.println("Length not found");
        }else {
            System.out.println("Length found: "+res);
        }

        arr = new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        n = arr.length;
        x = 280;
        res = smallestSubWithSum(arr, n, x);
        if (res == Integer.MAX_VALUE) {
            System.out.println("Length not found");
        }else {
            System.out.println("Length found: "+res);
        }

        arr = new int[]{- 8, 1, 4, 2, -6};
        n = arr.length;
        x = 6;
        res = smallestSubWithSum(arr, n, x);
        if (res == Integer.MAX_VALUE) {
            System.out.println("Length not found");
        }else {
            System.out.println("Length found: "+res);
        }

    }
}
//Time Complexity: O(n)