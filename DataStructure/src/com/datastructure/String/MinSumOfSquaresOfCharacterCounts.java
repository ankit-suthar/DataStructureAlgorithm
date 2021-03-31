/*
Given a string of lowercase alphabets and a number k,
the task is to print the minimum value of the string after removal of ‘k’ characters.
The value of a string is defined as the sum of squares of the count of each distinct character.
For example consider the string “saideep”, here frequencies of characters are s-1, a-1, i-1, e-2, d-1, p-1 and
value of the string is 1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 2^2 = 9

Input :  str = abccc, K = 1
Output :  6
We remove c to get the value as 12 + 12 + 22

Input :  str = aaab, K = 2
Output :  2

A Better Solution used to Priority Queue which has to the highest element on top.

Initialize empty priority queue.
Count frequency of each character and Store into temp array.
Remove K characters which have highest frequency from queue.
Finally Count Sum of square of each element and return it.
*/
package com.datastructure.String;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinSumOfSquaresOfCharacterCounts {

    static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1>o2){
                return -1;
            }else if(o1<o2){
                return 1;
            }else{
                return 0;
            }
        }
    }
    static int MAX_CHAR = 26;

    static int minStringValue(String str,int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new MyComparator());
        int freq[] = new int[MAX_CHAR];
        int count=0;
        int ans = 0;

        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }

        for(int i=0;i<MAX_CHAR;i++){
            if(freq[i]!=0){
                priorityQueue.add(freq[i]);
            }
        }

        while(count<k && !priorityQueue.isEmpty()){
            int temp = priorityQueue.peek();
            priorityQueue.poll();
            temp--;
            priorityQueue.add(temp);
            count++;
        }

        while(!priorityQueue.isEmpty()){
            ans += priorityQueue.peek()*priorityQueue.peek();
            priorityQueue.poll();
        }
        return ans;
    }

    public static void main(String[] a){
        String str = "abbccc";   // Input 1
        int k = 2;
        System.out.println(minStringValue(str, k));

        str = "aaab";           // Input 2
        k = 2;
        System.out.println(minStringValue(str, k));

    }
}
//Time Complexity: O(n)