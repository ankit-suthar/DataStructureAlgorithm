/*
Given an array, only rotation operation is allowed on array.
We can rotate the array as many times as we want.
Return the maximum possible of summation of i*arr[i].

We can solve this problem in O(n) time using an Efficient Solution.
Let Rj be value of i*arr[i] with j rotations.
The idea is to calculate next rotation value from previous rotation,
i.e., calculate Rj from Rj-1. We can calculate initial value of result as R0,
then keep calculating next rotation values.

Input : arr[] = {8, 3, 1, 2}
Output : 29
Explanation : Let us see all rotations
{8, 3, 1, 2} = 8*0 + 3*1 + 1*2 + 2*3 = 11
{3, 1, 2, 8} = 3*0 + 1*1 + 2*2 + 8*3 = 29
{1, 2, 8, 3} = 1*0 + 2*1 + 8*2 + 3*3 = 27
{2, 8, 3, 1} = 2*0 + 8*1 + 3*2 + 1*1 = 17

Input : arr[] = {3, 2, 1}
Output : 7

How to efficiently calculate Rj from Rj-1?
This can be done in O(1) time. Below are details.

Let us calculate initial value of i*arr[i] with no rotation
R0 = 0*arr[0] + 1*arr[1] +...+ (n-1)*arr[n-1]

After 1 rotation arr[n-1], becomes first element of array,
arr[0] becomes second element, arr[1] becomes third element
and so on.
R1 = 0*arr[n-1] + 1*arr[0] +...+ (n-1)*arr[n-2]

R1 - R0 = arr[0] + arr[1] + ... + arr[n-2] - (n-1)*arr[n-1]

After 2 rotations arr[n-2], becomes first element of array,
arr[n-1] becomes second element, arr[0] becomes third element
and so on.
R2 = 0*arr[n-2] + 1*arr[n-1] +...+ (n-1)*arr[n-3]

R2 - R1 = arr[0] + arr[1] + ... + arr[n-3] - (n-1)*arr[n-2] + arr[n-1]

If we take a closer look at above values, we can observe
below pattern

Rj - Rj-1 = arrSum - n * arr[n-j]

Where arrSum is sum of all array elements, i.e.,

arrSum = &Sum; arr[i]
        0<=i<=n-1

Below is complete algorithm:

1) Compute sum of all array elements. Let this sum be 'arrSum'.

2) Compute R0 by doing i*arr[i] for given array.
   Let this value be currVal.

3) Initialize result: maxVal = currVal // maxVal is result.

// This loop computes Rj from  Rj-1
4) Do following for j = 1 to n-1
......a) currVal = currVal + arrSum-n*arr[n-j];
......b) If (currVal > maxVal)
            maxVal = currVal

5) Return maxVal
*/
package com.datastructure.array;

public class MaxSumOfIAndArrOfIAmongAllRotations {

    static void findMaxSum(int[] arr,int n){
        int sumOfAllElements = 0;
        int currRotationSum = 0;

        for(int i=0;i<n;i++){
            sumOfAllElements += arr[i];
            currRotationSum += i*arr[i];
        }

        int res = currRotationSum;

        for(int i=1;i<n;i++){
            //currRotationSum = currRotationSum - (sumOfAllElements - arr[i-1]) + (n-1) * arr[i-1];
            currRotationSum = currRotationSum + sumOfAllElements - (n * arr[n-i]);
            res = Math.max(res,currRotationSum);
        }
        System.out.println(res);
    }

    public static void main(String[] a){
        //int arr[] = {8, 3, 1, 2}; //29
        //int arr[] = {3, 2, 1}; //7
        //int arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //330
        int arr[] = {1, 20, 2, 10}; //72
        int n = arr.length;
        findMaxSum(arr,n);
    }
}
//Time Complexity : O(n)
//Auxiliary Space : O(1)