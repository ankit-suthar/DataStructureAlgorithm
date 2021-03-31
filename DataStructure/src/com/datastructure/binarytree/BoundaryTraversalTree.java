/*
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting
from the root. For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”

We break the problem in 3 parts:

1. Print the left boundary in top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…..2.1 Print all leaf nodes of left sub-tree from left to right.
…..2.2 Print all leaf nodes of right subtree from left to right.
3. Print the right boundary in bottom-up manner.

We need to take care of one thing that nodes are not printed again.
e.g. The left most node is also the leaf node of the tree.
												  20
											    /   \
											  /		 \
										    8         22
										 /   \         \
								       /	  \         \
									 4		  12        25
													   /  \
												     /     \
												   10      14
O/P : 20  8  4  10  14  25  22
*/
package com.datastructure.binarytree;

public class BoundaryTraversalTree {

    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    void leftSide(Node node){
        if(node == null){
            return;
        }

        if(node.left==null && node.right==null){
            return;
        }

        if(node.left!=null){
            System.out.print(node.data+" ");
            leftSide(node.left);
        }else{
            System.out.print(node.data+" ");
            leftSide(node.right);
        }
    }

    void rightSide(Node node){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            return;
        }

        if(node.right!=null){
            System.out.print(node.data+" ");
            rightSide(node.right);
        }else{
            System.out.print(node.data+" ");
            rightSide(node.left);
        }
    }

    void bottomSide(Node node){
        if(node == null){
            return;
        }

        if(node.left==null && node.right==null){
            System.out.print(node.data + " ");
            return;
        }

        bottomSide(node.left);
        bottomSide(node.right);
    }

    void printBoundary(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.data+" ");

        leftSide(node.left);
        rightSide(node.right);
        bottomSide(node);
    }

    public static void main(String[] args) {
        BoundaryTraversalTree tree=new BoundaryTraversalTree();

        tree.root = tree.new Node(20);
        tree.root.left = tree.new Node(8);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(12);
        tree.root.left.right.left = tree.new Node(10);
        tree.root.left.right.right = tree.new Node(14);
        tree.root.right = tree.new Node(22);
        tree.root.right.right = tree.new Node(25);

        tree.printBoundary(tree.root);
    }
}
//Time Complexity: O(n)