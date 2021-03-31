package com.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalQueue {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void levelOrderTraversal(Node node){
        if(node==null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node node1 = queue.poll();

            System.out.print(node1.data+" ");

            if(node1.left!=null){
                queue.add(node1.left);
            }

            if(node1.right!=null){
                queue.add(node1.right);
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversalQueue tree = new LevelOrderTraversalQueue();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);

        tree.levelOrderTraversal(tree.root);
    }
}
