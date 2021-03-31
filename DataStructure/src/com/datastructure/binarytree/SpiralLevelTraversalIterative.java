package com.datastructure.binarytree;

import java.util.Stack;

public class SpiralLevelTraversalIterative {
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

    void printSpiralLevel(Node n){
        if(n==null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        boolean flag=true;
        stack1.push(n);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(flag){
                while(!stack1.isEmpty()){
                    Node node = stack1.pop();
                    System.out.print(node.data+" ");
                    if(node.left!=null){
                        stack2.push(node.left);
                    }
                    if(node.right!=null){
                        stack2.push(node.right);
                    }
                }
                flag=!flag;
            }else{
                while(!stack2.isEmpty()){
                    Node node = stack2.pop();
                    System.out.print(node.data+" ");
                    if(node.right!=null){
                        stack1.push(node.right);
                    }
                    if(node.left!=null){
                        stack1.push(node.left);
                    }
                }
                flag=!flag;
            }
        }
    }

    public static void main(String[] a){
        SpiralLevelTraversalIterative tree = new SpiralLevelTraversalIterative();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(7);
        tree.root.left.right = tree.new Node(6);
        tree.root.right.left = tree.new Node(5);
        tree.root.right.right = tree.new Node(4);
        System.out.println("Spiral Order traversal of Binary Tree is ");
        tree.printSpiralLevel(tree.root);
    }
}
