/*
Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.

Input: aaabc
Output: abaca

Input: aaabb
Output: ababa

Input: aa
Output: Not Possible

Input: aaaabc
Output: Not Possible

he idea is to put the highest frequency character first (a greedy approach).
We use a priority queue (Or Binary Max Heap) and put all characters and ordered
by their frequencies (highest frequency character at root). We one by one take the
highest frequency character from the heap and add it to result. After we add, we decrease
the frequency of the character and we temporarily move this character out of priority queue
so that it is not picked next time.

We have to follow the step to solve this problem, they are:
1. Build a Priority_queue or max_heap, pq that stores characters and their frequencies.
…… Priority_queue or max_heap is built on the bases of the frequency of character.
2. Create a temporary Key that will be used as the previously visited element (the previous element in the resultant string.
Initialize it { char = ‘#’ , freq = ‘-1’ }
3. While pq is not empty.
….. Pop an element and add it to the result.
….. Decrease frequency of the popped element by ‘1’
….. Push the previous element back into the priority_queue if it’s frequency > ‘0’
….. Make the current element as the previous element for the next iteration.
4. If the length of the resultant string and original string is not equal, print “not possible”. Else print result.
*/
package com.datastructure.String;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeCharInStringSoNoTwoAdjacentAreSame {

    static class MyComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair pair1, Pair pair2) {
            if(pair1.count>pair2.count){
                return -1;
            }else if(pair1.count<pair2.count){
                return 1;
            }else{
                return 0;
            }
        }
    }

    static class Pair{
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    static final int MAX_CHAR = 26;

    static void rearrangeString(String str){
        int freq[] = new int[MAX_CHAR];
        String ans = "";
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new MyComparator());
        Pair pair;

        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }

        for(int i=0;i<MAX_CHAR;i++){
            if(freq[i]>0){
                priorityQueue.add(new Pair((char)('a'+i),freq[i]));
            }
        }

        Pair prev = new Pair('#',-1);

        while(!priorityQueue.isEmpty()){
            pair = priorityQueue.poll();
            ans += Character.toString(pair.ch);

            if(prev.count>0){
                priorityQueue.add(prev);
            }

            pair.count--;
            prev=pair;
        }

        if(ans.length()!=str.length()){
            System.out.println("Not Possible");
        }else{
            System.out.println(ans);
        }
    }

    public static void main(String[] a){
        //String str = "aaabc"; //acaba
        String str = "bbbaa" ; //babab
        //String str = "aaabb"; //ababa
        //String str = "aa"; //Not Possible
        //String str = "aaaabc"; //Not Possible

        rearrangeString(str);
    }
}
//Time complexity : O(nlog(n))