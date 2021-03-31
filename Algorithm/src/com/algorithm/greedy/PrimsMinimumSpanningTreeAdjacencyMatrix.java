package com.algorithm.greedy;

import java.util.Arrays;

public class PrimsMinimumSpanningTreeAdjacencyMatrix {

    int getMinimumValue(int[] unsettled, boolean[] settled, int m){

        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            if(!settled[i] && unsettled[i] < minValue){
                minValue = unsettled[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    void primMST(int[][] graph,int src){
        int m = graph.length;

        int[] unsettled = new int[m];
        int[] parent = new int[m];
        boolean[] settled = new boolean[m];

        Arrays.fill(unsettled,Integer.MAX_VALUE);
        unsettled[src] = 0;
        parent[0] = -1;

        for (int i=0;i<m-1;i++){
            int minVal = getMinimumValue(unsettled,settled,m);
            settled[minVal] = true;

            for(int j=0;j<m;j++){
                if(!settled[j] && graph[minVal][j]!=0 && graph[minVal][j] < unsettled[j]){
                    unsettled[j] = graph[minVal][j];
                    parent[j] = minVal;
                }
            }
        }

        printMST(parent,graph);
    }

    void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i=1;i<graph.length;i++){
            System.out.println(parent[i] + "-" + i + "\t\t  " + graph[parent[i]][i]);
        }
    }

    public static void main(String[] args) {
        PrimsMinimumSpanningTreeAdjacencyMatrix mst = new PrimsMinimumSpanningTreeAdjacencyMatrix();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 9 },
                                      { 0, 5, 7, 9, 0 } };
        mst.primMST(graph,0);
    }
}
// Time Complexity: O(V^2) (V - No. of Vertex)
// It can be reduced to O(E log V) If the input graph is represented using adjacency list