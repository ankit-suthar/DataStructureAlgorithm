package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PrintNodesAsTheyBecomeLeafNode {
    Node root;

    class Node
    {
        int data,order;
        Node left,right;

        Node(int data) {
            this.data=data;
            left=right=null;
        }
    }

    Node printLeafUtil(Node n,List<Integer> list){
        if(n==null){
            return null;
        }
        if(n.left==null && n.right==null){
            list.add(n.data);
            return null;
        }
        n.left = printLeafUtil(n.left,list);
        n.right = printLeafUtil(n.right,list);
        return n;
    }

    void printLeaf(Node n){
        if(n==null){
            return;
        }
        List<Integer> list;
        int count=0;
        while(n!=null){
            count++;
            list = new ArrayList<>();
            n = printLeafUtil(n,list);
            System.out.println(count+": "+list);
        }
    }

    public static void main(String[] a){
        PrintNodesAsTheyBecomeLeafNode tree = new PrintNodesAsTheyBecomeLeafNode();
        tree.root = tree.new Node(8);
        tree.root.left = tree.new Node(3);
        tree.root.right = tree.new Node(10);
        tree.root.left.left = tree.new Node(1);
        tree.root.left.right = tree.new Node(6);
        tree.root.left.left.left = tree.new Node(7);
        tree.root.left.left.right = tree.new Node(13);
        tree.root.right.left = tree.new Node(14);
        tree.root.right.right = tree.new Node(4);
        tree.printLeaf(tree.root);
    }
}
