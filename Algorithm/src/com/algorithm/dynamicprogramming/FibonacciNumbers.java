package com.algorithm.dynamicprogramming;

public class FibonacciNumbers {

    int fibonacciNumbers(int num){
        if(num<=1){
            return num;
        }

        return fibonacciNumbers(num-1)+fibonacciNumbers(num-2);
    }

    public static void main(String[] a){
        FibonacciNumbers fn = new FibonacciNumbers();
        int num = 9;
        System.out.println(fn.fibonacciNumbers(num));
    }
}
