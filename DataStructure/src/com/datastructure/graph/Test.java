package com.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    LinkedList<Integer>[] linkedLists;
    int size;

    public Test(int size) {
        linkedLists = new LinkedList[size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            linkedLists[i] = new LinkedList<>();
        }
    }

    void addBFS(int src, int dest) {
        linkedLists[src].add(dest);
    }

    void bfsTraversal(boolean[] visited, int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (!visited[i]) {
                System.out.print(i + " ");
                visited[i] = true;
                queue.addAll(linkedLists[i]);
            }
        }
    }

    void dfsTraversal(boolean[] visited, int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(linkedLists[index]);

        while (!queue.isEmpty()) {
            int i = queue.poll();

            if (!visited[i]) {
                System.out.print(i + " ");
                visited[i] = true;
                dfsTraversal(visited, i);
            }

        }
    }

    public static void main(String[] args) {
        Test bfs = new Test(4);
        bfs.addBFS(0, 1);
        bfs.addBFS(0, 2);
        bfs.addBFS(1, 2);
        bfs.addBFS(2, 0);
        bfs.addBFS(2, 3);
        bfs.addBFS(3, 3);
        boolean[] visited = new boolean[bfs.size];
        bfs.bfsTraversal(visited, 2);
        System.out.println("\n--------------------------");
        visited = new boolean[bfs.size];
        bfs.dfsTraversal(visited, 0);
    }
}
