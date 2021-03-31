package com.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS {
    int size;
    ArrayList[] al;

    public BFS(int size){
        this.size=size;
        al = new ArrayList[size];
        for(int i=0;i<size;i++){
            al[i]=new ArrayList<>();
        }
    }

    void addEdge(int src,int dest){
        al[src].add(dest);
    }

    void bfsTraversal(boolean[] visited,int index){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(index);

        while(!linkedList.isEmpty()){
            int indx = linkedList.poll();
            ListIterator<Integer> itr = al[indx].listIterator();
            while(itr.hasNext()){
                int i = itr.next();
                if(!visited[i]){
                    visited[i]=true;
                    System.out.print(i+" ");
                    linkedList.add(i);
                }
            }
        }
    }

    public static void main(String [] a){
        BFS bfs = new BFS(4);
        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        boolean[] visited = new boolean[bfs.size];
        bfs.bfsTraversal(visited,0);
    }
}
