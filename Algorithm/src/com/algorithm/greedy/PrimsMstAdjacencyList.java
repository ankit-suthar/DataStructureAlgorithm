package com.algorithm.greedy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimsMstAdjacencyList {

    class Node{
        private int nodeId;
        private Map<Node,Integer> nodeMap = new HashMap<>();
        private int distance = Integer.MAX_VALUE;
        private int parentNode;

        public Node(int nodeId) {
            this.nodeId = nodeId;
        }

        public int getNodeId() {
            return nodeId;
        }

        public void setNodeId(int nodeId) {
            this.nodeId = nodeId;
        }

        public Map<Node, Integer> getNodeMap() {
            return nodeMap;
        }

        public void setNodeMap(Map<Node, Integer> nodeMap) {
            this.nodeMap = nodeMap;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getParentNode() {
            return parentNode;
        }

        public void setParentNode(int parentNode) {
            this.parentNode = parentNode;
        }
    }

    int N;
    Node node[];
    public PrimsMstAdjacencyList(int n) {
        N = n;
        node = new Node[N];
        for(int i=0;i<N;i++){
            node[i] = new Node(i);
        }
    }

    public void addAdjacentNode(Node srcNode, Node destNode, int distance){
        srcNode.getNodeMap().put(destNode,distance);
        destNode.getNodeMap().put(srcNode,distance);
    }

    private void calculateMinDistance(Node sourceNode) {
        Queue<Node> unsettled = new PriorityQueue<>((nodeOne,nodeTwo) -> {
            if(nodeOne.distance < nodeTwo.distance){
                return -1;
            }else if(nodeOne.distance > nodeTwo.distance){
                return 1;
            }else{
                return 0;
            }
        });
        sourceNode.setDistance(0);
        sourceNode.setParentNode(-1);
        Set<Node> settled = new HashSet<>();
        unsettled.add(sourceNode);

        while(unsettled.size()>0){
            Node currentNode = unsettled.poll();

            if(!settled.contains(currentNode)){
                settled.add(currentNode);

                currentNode.getNodeMap().forEach((key,value) -> {
                    if(!settled.contains(key)){
                        if(value < key.getDistance()){
                            unsettled.remove(key);
                            key.setDistance(value);
                            key.setParentNode(currentNode.getNodeId());
                            unsettled.add(key);
                        }
                    }
                });
            }
        }
        AtomicInteger weight = new AtomicInteger();
        settled.iterator().forEachRemaining(node -> {
//            System.out.println(node.getParentNode() + " - " + node.getNodeId());
            weight.addAndGet(node.distance);
            System.out.println(">"+node.distance);
        });
        System.out.println(weight.get());
    }

    public static void main(String[] args) {
        PrimsMstAdjacencyList mstAdjList = new PrimsMstAdjacencyList(9);

        mstAdjList.addAdjacentNode(mstAdjList.node[0],mstAdjList.node[1],4);
        mstAdjList.addAdjacentNode(mstAdjList.node[0],mstAdjList.node[7],8);

        mstAdjList.addAdjacentNode(mstAdjList.node[1],mstAdjList.node[2],8);
        mstAdjList.addAdjacentNode(mstAdjList.node[1],mstAdjList.node[7],11);

        mstAdjList.addAdjacentNode(mstAdjList.node[2],mstAdjList.node[3],7);
        mstAdjList.addAdjacentNode(mstAdjList.node[2],mstAdjList.node[8],2);
        mstAdjList.addAdjacentNode(mstAdjList.node[2],mstAdjList.node[5],4);

        mstAdjList.addAdjacentNode(mstAdjList.node[3],mstAdjList.node[4],9);
        mstAdjList.addAdjacentNode(mstAdjList.node[3],mstAdjList.node[5],14);

        mstAdjList.addAdjacentNode(mstAdjList.node[4],mstAdjList.node[5],10);

        mstAdjList.addAdjacentNode(mstAdjList.node[5],mstAdjList.node[6],2);

        mstAdjList.addAdjacentNode(mstAdjList.node[6],mstAdjList.node[7],1);
        mstAdjList.addAdjacentNode(mstAdjList.node[6],mstAdjList.node[8],6);

        mstAdjList.addAdjacentNode(mstAdjList.node[7],mstAdjList.node[8],7);

        mstAdjList.calculateMinDistance(mstAdjList.node[0]);
    }
}
