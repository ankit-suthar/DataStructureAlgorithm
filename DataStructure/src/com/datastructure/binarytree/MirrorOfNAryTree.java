package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MirrorOfNAryTree {
    Node root;

    class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data=data;
            children=new ArrayList<>();
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

    void convertToMirror(Node n){
        if (n==null){
            return;
        }

        for(int i=0;i<n.children.size();i++){
            convertToMirror(n.children.get(i));
        }
        Collections.reverse(n.children);
    }

    void printLevelOrder(Node n){
        if(n==null){
            return;
        }
        int max=0;
        Queue<QueueNode> queue = new LinkedList<>();
        queue.add(new QueueNode(n,1));

        while(!queue.isEmpty()){
            QueueNode queueNode = queue.poll();

            if(max<queueNode.level){
                max=queueNode.level;
                System.out.print("Level "+max+": ");
            }
            System.out.print(queueNode.node.data+" ");

            for(int i=0;i<queueNode.node.children.size();i++){
                queue.add(new QueueNode(queueNode.node.children.get(i),queueNode.level+1));
            }
        }
    }

    void printRecursive(Node n){
        if(n==null){
            return;
        }
        System.out.print(n.data+" ");

        for(int i=0;i<n.children.size();i++){
            printRecursive(n.children.get(i));
        }
    }

    public static void main(String[] a){
        MirrorOfNAryTree tree = new MirrorOfNAryTree();
        Node n1 = tree.new Node(1);
        Node n2 = tree.new Node(2);
        Node n3 = tree.new Node(3);
        Node n4 = tree.new Node(4);
        Node n5 = tree.new Node(5);
        Node n6 = tree.new Node(6);
        Node n7 = tree.new Node(7);
        Node n8 = tree.new Node(8);
        Node n9 = tree.new Node(9);

        tree.root=n1;
        tree.root.children.add(n2);
        tree.root.children.add(n3);
        tree.root.children.add(n4);

        n2.children.add(n5);
        n2.children.add(n6);

        n3.children.add(n7);

        n4.children.add(n8);
        n4.children.add(n9);

        System.out.println("Original tree level order traversal:" );
        tree.printLevelOrder(tree.root);
        System.out.println();

        tree.convertToMirror(tree.root);

        System.out.println("Mirror tree level order traversal:" );
        tree.printLevelOrder(tree.root);
        System.out.println();

        System.out.println("Print recursive of M-Ary Tree:");
        tree.printRecursive(tree.root);
        System.out.println();
    }
}
