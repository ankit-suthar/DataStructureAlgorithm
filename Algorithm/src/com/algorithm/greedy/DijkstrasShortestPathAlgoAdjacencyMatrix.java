package com.algorithm.greedy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class DijkstrasShortestPathAlgoAdjacencyMatrix {

    static int getMinimumDistanceIndex(int[] distance, boolean[] settled, int len){
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for(int i=0;i<len;i++){
            if(!settled[i] && distance[i] < minValue){
                minIndex = i;
                minValue = distance[i];
            }
        }
        return minIndex;
    }

    static void calculateMinimumDistance(int[][] graph, int source){
        int m = graph.length;

        boolean[] settled = new boolean[m];
        int[] distance = new int[m];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[source] = 0;

        for(int j=0;j<m-1;j++){
            int index = getMinimumDistanceIndex(distance, settled, m);
            settled[index] = true;

            for(int i=0;i<m;i++){

                if(!settled[i] && graph[index][i] != 0 && distance[index]!= Integer.MAX_VALUE && distance[index] + graph[index][i] < distance[i]){
                    distance[i] = distance[index] + graph[index][i];
                }
            }
        }

        AtomicInteger count = new AtomicInteger();
        System.out.println("Vertex   Distance from Source");
        Arrays.stream(distance).forEach(value -> {
            System.out.println("  " + count.get() + "              " + distance[count.get()]);
            count.getAndIncrement();
        });

    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {   { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        calculateMinimumDistance(graph,0);
    }
}
// Time Complexity: O(V^2) (V - No. of Vertex)
// It can be reduced to O(E log V) If the input graph is represented using adjacency list