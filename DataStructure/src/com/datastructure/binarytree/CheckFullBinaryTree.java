/*
 * A full binary tree is defined as a binary tree in which
 * all nodes have either zero or two child nodes. Conversely,
 * there is no node in a full binary tree, which has one child node.
 *
 *
 * To check whether a binary tree is a full binary tree we need to test the following cases:-

1) If a binary tree node is NULL then it is a full binary tree.
2) If a binary tree node does have empty left and right sub-trees, then it is a full binary tree by definition
3) If a binary tree node has left and right sub-trees, then it is a part of a full binary tree by definition. In this case recursively check if the left and right sub-trees are also binary trees themselves.
4) In all other combinations of right and left sub-trees, the binary tree is not a full binary tree.
*/
package com.datastructure.binarytree;

public class CheckFullBinaryTree {

    Node root;

    class Node{
        int data;
        Node left;
        Node right;

        Node(int item){
            data=item;
            left=right=null;
        }
    }

    boolean isBinary(Node node){
        if(node.left == null && node.right == null){
            return true;
        }

        if(node.left == null || node.right == null){
            return false;
        }

        return isBinary(node.left) && isBinary(node.right);
    }

    public static void main(String[] args) {
        CheckFullBinaryTree tree=new CheckFullBinaryTree();

        tree.root=tree.new Node(1);
        tree.root.left=tree.new Node(2);
        tree.root.right=tree.new Node(3);
        tree.root.left.left=tree.new Node(4);
        tree.root.left.right=tree.new Node(5);
        tree.root.right.right=tree.new Node(7);
        tree.root.right.left=tree.new Node(6);

        boolean res;

        if(tree.root!=null){
            res= tree.isBinary(tree.root);

            if(res==true) {
                System.out.println("This tree is binary tree.");
            }else {
                System.out.println("This tree is not binary tree.");
            }
        }
        else if(tree.root == null) {
            System.out.println("This tree is binary tree.");
        }else if(tree.root.left==null && tree.root.right==null) {
            System.out.println("This tree is binary tree.");
        }
    }
}
