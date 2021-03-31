package com.algorithm.dynamicprogramming;

public class MinimumNumberJumpsToReachEndDP1 {

    int minJumps(int arr[],int n){
        if(n==0){
            return 0;
        }

        if(arr[0]==0){
            return 0;
        }
        int[] jump = new int[n];
        jump[0]=0;

        for(int i=1;i<n;i++){
            jump[i]=Integer.MAX_VALUE;
            for(int j=i-1;j>=0;j--){   //for(int j=0;j<i;j++){
                if(j+arr[j]>=i && jump[j]+1<jump[i]){
                    jump[i]=jump[j]+1;
                }
            }
        }
        return jump[n-1];
    }

    public static void main(String[] a){
        MinimumNumberJumpsToReachEndDP1 minJump = new MinimumNumberJumpsToReachEndDP1();
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
        int n = arr.length;
        System.out.print("Minimum number of jumps to reach end is "+ minJump.minJumps(arr, n));
    }
}
//Time Complexity: O(n^2)