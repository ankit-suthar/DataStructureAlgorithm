package com.datastructure.array;

import java.util.Stack;

public class  StockSpanProblemMthd1 {

    static void calculateSpan(int[] price,int n,int[] span){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0]=1;

        for(int i=1;i<n;i++){
            while (!stack.isEmpty() && price[i]>=price[stack.peek()]){
                stack.pop();
            }
            span[i] = (stack.isEmpty()) ? (i+1):(i-stack.peek());
            stack.push(i);
        }

        for(int index:span){
            System.out.print(index+" ");
        }
    }

    public static void main(String[] a){
        int price[] = { 10, 4, 5, 90, 70, 120, 80 };
        //int price[] = { 3,4,9,6,1 };
        int n = price.length;
        int[] span = new int[n];

        calculateSpan(price,n,span);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(n)