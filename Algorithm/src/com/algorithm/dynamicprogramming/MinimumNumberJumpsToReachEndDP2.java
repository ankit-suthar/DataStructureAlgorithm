package com.algorithm.dynamicprogramming;

public class MinimumNumberJumpsToReachEndDP2 {

    int minJumps(int arr[],int n){
        if(arr[0]==0){
            return -1;
        }
        if(n==1){
            return 0;
        }

        int step = arr[0];
        int jump = 1;
        int maxReach = arr[0];

        for(int i=1;i<n;i++){
            if(i==n-1){
                return jump;
            }

            maxReach = Math.max(maxReach,i+arr[i]);
            step--;

            if(step==0){
                jump++;
                if(i>=maxReach){
                    return -1;
                }
                step=maxReach-i;
            }
        }
        return -1;
    }

    public static void main(String[] a){
        MinimumNumberJumpsToReachEndDP2 minJump = new MinimumNumberJumpsToReachEndDP2();
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is "+ minJump.minJumps(arr, n));
    }
}
//Time Complexity: O(n)