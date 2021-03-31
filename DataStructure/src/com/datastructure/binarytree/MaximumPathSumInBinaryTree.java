package com.datastructure.binarytree;

public class MaximumPathSumInBinaryTree {
    Node root;

    class Node {
        int data;
        Node left,right;

        Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }

    class GetMaxSum{
        int maxSum=Integer.MIN_VALUE;
    }

    int getMaxSumPath(Node n,GetMaxSum getMaxSum){
        if(n==null){
            return 0;
        }

        int leftSum = getMaxSumPath(n.left,getMaxSum);
        int rightSum = getMaxSumPath(n.right,getMaxSum);

        getMaxSum.maxSum = Math.max(getMaxSum.maxSum,n.data+leftSum+rightSum);

        return Math.max(leftSum,rightSum)+n.data;
    }

    public static void main(String[] args) {
        MaximumPathSumInBinaryTree tree = new MaximumPathSumInBinaryTree();

        tree.root = tree.new Node(10);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(10);
        tree.root.left.left = tree.new Node(20);
        tree.root.left.right = tree.new Node(1);
        tree.root.right.right = tree.new Node(-25);
        tree.root.right.right.left = tree.new Node(3);
        tree.root.right.right.right = tree.new Node(4);

        GetMaxSum getMaxSum = tree.new GetMaxSum();

        tree.getMaxSumPath(tree.root,getMaxSum);
        System.out.println("Maximum Path Sum is: "+getMaxSum.maxSum);
    }
}
