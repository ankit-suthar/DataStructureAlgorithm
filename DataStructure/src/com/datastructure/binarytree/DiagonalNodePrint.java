package com.datastructure.binarytree;

import java.util.*;

public class DiagonalNodePrint {

    Node root;

    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    class QueueNode{
        Node node;
        int level;

        QueueNode(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }

    void diagonalPrintUtil(Node n,Map<Integer,List<Integer>> map,int level){
        if(n==null){
            return;
        }

        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(n,level));

        while(!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            List<Integer> list = map.getOrDefault(queueNode.level,new ArrayList<Integer>());
            list.add(queueNode.node.data);
            map.put(queueNode.level,list);

            if(queueNode.node.right!=null){
                queue.add(new QueueNode(queueNode.node.right,queueNode.level));
            }
            if(queueNode.node.left!=null){
                queue.add(new QueueNode(queueNode.node.left,queueNode.level+1));
            }
        }
        map.forEach((key,value)->{
            System.out.println(key+": "+value);
        });
    }

    void diagonalPrint(Node n){
        if(n==null){
            return;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        diagonalPrintUtil(n,map,1);

    }

    public static void main(String[] args) {
        DiagonalNodePrint tree = new DiagonalNodePrint();

        tree.root = tree.new Node(8);
        tree.root.left = tree.new Node(3);
        tree.root.right = tree.new Node(10);
        tree.root.left.left = tree.new Node(1);
        tree.root.left.right = tree.new Node(6);
        tree.root.right.right = tree.new Node(14);
        tree.root.right.right.left = tree.new Node(13);
        tree.root.left.right.left = tree.new Node(4);
        tree.root.left.right.right = tree.new Node(7);

        tree.diagonalPrint(tree.root);
    }
}
