package com.datastructure.binarytree;

public class LongestPathInBinaryTree {
    Node root;

    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    class MaxLength{
        int max=Integer.MIN_VALUE;
    }

    int getLongestLength(Node n,MaxLength maxLength){
        if(n==null){
            return 0;
        }

        int lLength = getLongestLength(n.left,maxLength);
        int rLength = getLongestLength(n.right,maxLength);

        maxLength.max = Math.max(maxLength.max,1+lLength+rLength);

        return Math.max(lLength,rLength)+1;
    }

    public static void main(String[] a){
        LongestPathInBinaryTree tree = new LongestPathInBinaryTree();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.left.right.right = tree.new Node(10);
        tree.root.left.right.right.right = tree.new Node(11);
        tree.root.left.right.right.right.right = tree.new Node(12);
        tree.root.left.right.right.right.right.right = tree.new Node(13);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.root.left.left.left = tree.new Node(8);
        tree.root.left.left.right = tree.new Node(9);

        MaxLength maxLength = tree.new MaxLength();
        tree.getLongestLength(tree.root,maxLength);
        System.out.println("Longest Chain Length is: "+maxLength.max);
    }
}
