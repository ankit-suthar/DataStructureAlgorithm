package com.datastructure.binarytree;

public class BinaryTreeToDLL {
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

    Node prev;
    Node head;

    void convertBinaryTreeToDLL(Node n){
        if(n==null){
            return;
        }

        convertBinaryTreeToDLL(n.left);
        if(prev==null){
            head = n;
            prev=n;
        }else{
            prev.right=n;
            n.left=prev;
            prev=n;
        }
        convertBinaryTreeToDLL(n.right);
    }

    void printInorder(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n=n.right;
        }
    }

    public static void main(String[] a){
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.root = tree.new Node(10);
        tree.root.left = tree.new Node(12);
        tree.root.right = tree.new Node(15);
        tree.root.left.left  = tree.new Node(25);
        tree.root.left.right = tree.new Node(30);
        tree.root.right.left = tree.new Node(36);
        tree.convertBinaryTreeToDLL(tree.root);
        tree.printInorder(tree.head);
    }
}
