/*
1) Sort the activities according to their finishing time
2) Select the first activity from the sorted array and print it.
3) Do following for remaining activities in the sorted array.
    a) If the start time of this activity is greater than or equal to the finish time of previously selected activity
      then select this activity and print it.
*/
package com.algorithm.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ActivitySelectionProblem {

    class Pair{
        int startValue;
        int finishValue;

        public Pair(int startValue, int finishValue) {
            this.startValue = startValue;
            this.finishValue = finishValue;
        }

        @Override
        public String toString() {
            return "{"+ startValue +
                    ", " + finishValue +
                    '}';
        }
    }

    void getActivitySelected(int[] start, int[] finish, int n){
        Queue<Pair> queue = new PriorityQueue<>((pairOne,pairTwo) -> {
            if(pairOne.finishValue < pairTwo.finishValue){
                return -1;
            }else if(pairOne.finishValue > pairTwo.finishValue){
                return 1;
            }else{
                return 0;
            }
        });

        for(int i=0;i<start.length;i++){
            queue.add(new Pair(start[i],finish[i]));
        }

        Pair pair = queue.poll();
        int fnsh = pair.finishValue;
        List<Pair> pairList = new ArrayList<>();
        pairList.add(pair);

        while(!queue.isEmpty()){
            pair = queue.poll();

            if(fnsh < pair.startValue){
                pairList.add(pair);
                fnsh = pair.finishValue;
            }
        }
        pairList.stream().forEach(p -> System.out.print(p+" | "));
    }

    public static void main(String[] args) {
        ActivitySelectionProblem selection = new ActivitySelectionProblem();
        int start[] =  {1, 3, 0, 5, 8, 5};
        int finish[] =  {2, 4, 6, 7, 9, 9};
        int n = start.length;

        selection.getActivitySelected(start, finish, n);
    }
}
