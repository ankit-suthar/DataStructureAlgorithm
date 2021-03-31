package com.datastructure.graph;

import java.util.ArrayList;
import java.util.ListIterator;

public class DFS {
    int size;
    ArrayList<Integer>[] al;

    public DFS(int size){
        this.size=size;
        al = new ArrayList[size];
        for(int i=0;i<size;i++){
            al[i] = new ArrayList<>();
        }
    }

    void addEdge(int src,int dest){
        al[src].add(dest);
    }

    void dfsTraversal(boolean[] visited,int index){
        ListIterator<Integer> itr = al[index].listIterator();

        while(itr.hasNext()){
            int indx = itr.next();
            if(!visited[indx]){
                System.out.print(indx+" ");
                visited[indx]=true;
                dfsTraversal(visited,indx);
            }
        }
    }

    public static void main(String [] a){
        DFS dfs = new DFS(4);
        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);
        boolean[] visited = new boolean[dfs.size];
        dfs.dfsTraversal(visited,2);
    }
}
