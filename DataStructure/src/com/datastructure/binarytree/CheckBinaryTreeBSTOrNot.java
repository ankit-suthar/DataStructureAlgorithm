package com.datastructure.binarytree;

public class CheckBinaryTreeBSTOrNot {

    Node root;
    Node prev;

    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    boolean isBST(Node node){

        if(node==null){
            return true;
        }else{
            if(!isBST(node.left)){
                return false;
            }

            if(prev!=null && node.data<=prev.data){
                return false;
            }
            prev=node;

            return isBST(node.right);
        }
    }

    public static void main(String[] a){
        CheckBinaryTreeBSTOrNot checkBinaryTreeBSTOrNot = new CheckBinaryTreeBSTOrNot();

        checkBinaryTreeBSTOrNot.root = checkBinaryTreeBSTOrNot.new Node(4);
        checkBinaryTreeBSTOrNot.root.left = checkBinaryTreeBSTOrNot.new Node(2);
        checkBinaryTreeBSTOrNot.root.right = checkBinaryTreeBSTOrNot.new Node(5);
        checkBinaryTreeBSTOrNot.root.left.left = checkBinaryTreeBSTOrNot.new Node(1);
        checkBinaryTreeBSTOrNot.root.left.right = checkBinaryTreeBSTOrNot.new Node(3);

        if(checkBinaryTreeBSTOrNot.isBST(checkBinaryTreeBSTOrNot.root)){
            System.out.println("BST");
        }else{
            System.out.println("Not BST");
        }
    }
}
