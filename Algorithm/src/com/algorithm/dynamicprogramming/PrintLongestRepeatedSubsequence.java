package com.algorithm.dynamicprogramming;

import java.util.PriorityQueue;

public class PrintLongestRepeatedSubsequence {

    class Temp{
        char ch;
        int indexM;
        int indexN;

        public Temp(char ch, int indexM, int indexN) {
            this.ch = ch;
            this.indexM = indexM;
            this.indexN = indexN;
        }
    }

    int printLongestRepeatedSubsequence(char[] A,int m,int n,PriorityQueue<Temp> priorityQueue,boolean[] validateArray){
        if(m==0 || n==0){
            return 0;
        }else if(A[m-1]==A[n-1] && m-1<n-1 && !validateArray[m-1] && !validateArray[n-1]){
            priorityQueue.add(new Temp(A[m-1],m-1,n-1));
            validateArray[m-1]=true;
            validateArray[n-1]=true;
            return 1+printLongestRepeatedSubsequence(A,m-1,n-1,priorityQueue,validateArray);
        }else{
            return Math.max(printLongestRepeatedSubsequence(A,m-1,n,priorityQueue,validateArray), printLongestRepeatedSubsequence(A,m,n-1,priorityQueue,validateArray));
        }
    }

    public static void main(String[] a){
        PrintLongestRepeatedSubsequence printSubsequence = new PrintLongestRepeatedSubsequence();
//        String str = "AABEBCDD";
        String str = "BECAABDD";
        boolean validateArray[] = new boolean[str.length()];
        PriorityQueue<Temp> priorityQueue = new PriorityQueue<>((temp1, temp2) -> {
            if(temp1.indexM<temp2.indexM){
                return -1;
            }else if(temp1.indexM>temp2.indexM){
                return 1;
            }else{
                return 1;
            }
        });
        printSubsequence.printLongestRepeatedSubsequence(str.toCharArray(),str.length(),str.length(),priorityQueue,validateArray);
        Temp prev = priorityQueue.isEmpty()? null : priorityQueue.poll();
        System.out.print(prev.ch+"");
        while(!priorityQueue.isEmpty()){
            Temp curr = priorityQueue.poll();
            if(curr.indexM>prev.indexM && curr.indexN>prev.indexN){
                System.out.print(curr.ch+"");
                prev = curr;
            }
        }
        System.out.println();
    }
}
