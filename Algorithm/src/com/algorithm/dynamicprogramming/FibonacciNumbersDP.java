package com.algorithm.dynamicprogramming;

public class FibonacciNumbersDP {

    int fibonacciNumbers(int num){
        int dp[] = new int[num+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2;i<=num;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[num];
    }

    public static void main(String[] a){
        FibonacciNumbersDP fn = new FibonacciNumbersDP();
        int num = 9;
        System.out.println(fn.fibonacciNumbers(num));
    }
}
