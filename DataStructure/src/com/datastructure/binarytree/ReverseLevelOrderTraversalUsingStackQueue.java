package com.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversalUsingStackQueue {
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

    void reverseLevelOrderTraversal(Node n){
        if(n==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            stack.push(node);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().data+" ");
        }
    }

    public static void main(String[] a){
        ReverseLevelOrderTraversalUsingStackQueue tree = new ReverseLevelOrderTraversalUsingStackQueue();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.reverseLevelOrderTraversal(tree.root);
    }
}
