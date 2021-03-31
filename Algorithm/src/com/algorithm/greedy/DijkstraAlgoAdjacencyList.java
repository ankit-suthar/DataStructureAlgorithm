package com.algorithm.greedy;

import java.util.*;

public class DijkstraAlgoAdjacencyList {

    class Node{
        private String name;
        private Integer distance = Integer.MAX_VALUE;
        private List<Node> pathList = new LinkedList<>();
        private Map<Node,Integer> adjacentNodeMap = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public void addAdjacentNode(Node node,int distance){
            adjacentNodeMap.put(node,distance);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public List<Node> getPathList() {
            return pathList;
        }

        public void setPathList(List<Node> pathList) {
            this.pathList = pathList;
        }

        public Map<Node, Integer> getAdjacentNodeMap() {
            return adjacentNodeMap;
        }

        public void setAdjacentNodeMap(Map<Node, Integer> adjacentNodeMap) {
            this.adjacentNodeMap = adjacentNodeMap;
        }
    }

    static void evaluateMinimumDistanceOfNode(Node currentNode, Node evaluateNode, int distance){
        if(currentNode.getDistance() + distance < evaluateNode.getDistance()){
            evaluateNode.setDistance(currentNode.getDistance() + distance);
            List<Node> nodeList = new LinkedList<>(currentNode.getPathList());
            nodeList.add(currentNode);
            evaluateNode.setPathList(nodeList);
        }
    }

    static void calculateMinimumDistance(Node sourceNode){
        sourceNode.setDistance(0);
        Set<Node> settledNodes = new HashSet<>();
        Queue<Node> unsettledNodes = new PriorityQueue<>((nodeOne, nodeTwo) -> {
            if(nodeOne.getDistance() < nodeOne.getDistance()){
                return -1;
            }else if(nodeTwo.getDistance() > nodeTwo.getDistance()){
                return 1;
            }else{
                return 0;
            }
        });
        unsettledNodes.add(sourceNode);

        while(unsettledNodes.size()>0){
            Node currentNode = unsettledNodes.poll();

            if(!settledNodes.contains(currentNode)){
                settledNodes.add(currentNode);
                currentNode.getAdjacentNodeMap().forEach((key,value) -> {
                    evaluateMinimumDistanceOfNode(currentNode, key, value);
                    unsettledNodes.add(key);
                });
            }
        }
    }

    public static void main(String[] args) {
        DijkstraAlgoAdjacencyList dijkstra = new DijkstraAlgoAdjacencyList();

        Node nodeA = dijkstra.new Node("A");
        Node nodeB = dijkstra.new Node("B");
        Node nodeC = dijkstra.new Node("C");
        Node nodeD = dijkstra.new Node("D");
        Node nodeE = dijkstra.new Node("E");
        Node nodeF = dijkstra.new Node("F");

        nodeA.addAdjacentNode(nodeB, 10);
        nodeA.addAdjacentNode(nodeC, 15);

        nodeB.addAdjacentNode(nodeD, 12);
        nodeB.addAdjacentNode(nodeF, 15);

        nodeC.addAdjacentNode(nodeE, 10);

        nodeD.addAdjacentNode(nodeE, 2);
        nodeD.addAdjacentNode(nodeF, 1);

        nodeF.addAdjacentNode(nodeE, 5);

        calculateMinimumDistance(nodeA);
        System.out.println("Node E distance from Node A : "+nodeE.getDistance());
        nodeE.getPathList().stream().forEach(node -> {
            System.out.print("Node "+node.getName()+" - ");
        });
        System.out.print("Node E");
    }
}
