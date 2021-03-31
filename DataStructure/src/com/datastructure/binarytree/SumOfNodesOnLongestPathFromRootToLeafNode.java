package com.datastructure.binarytree;

public class SumOfNodesOnLongestPathFromRootToLeafNode {
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

    class Result{
        int maxLen;
        int sum;
    }

    void getSumOfNodesOnLongestPath(Node n,Result res,int sum,int len){
        if(n==null){
            return;
        }
        sum += n.data;

        if(n.left==null && n.right==null){
            if(len>res.maxLen){
                res.sum = sum;
                res.maxLen=len;
            }else if(len==res.maxLen && sum>res.sum){
                res.sum = sum;
            }
        }
        getSumOfNodesOnLongestPath(n.left,res,sum,len+1);
        getSumOfNodesOnLongestPath(n.right,res,sum,len+1);
    }

    public static void main(String[] a){
        SumOfNodesOnLongestPathFromRootToLeafNode tree = new SumOfNodesOnLongestPathFromRootToLeafNode();
        tree.root = tree.new Node(4);              /*        4        */
        tree.root.left = tree.new Node(2);         /*       / \       */
        tree.root.right = tree.new Node(5);        /*      2   5      */
        tree.root.left.left = tree.new Node(7);    /*     / \ / \     */
        tree.root.left.right = tree.new Node(1);   /*    7  1 2  3    */
        tree.root.right.left = tree.new Node(2);   /*      /          */
        tree.root.right.right = tree.new Node(3);  /*     6           */
        tree.root.left.right.left = tree.new Node(6);
        Result res = tree.new Result();

        tree.getSumOfNodesOnLongestPath(tree.root,res,0,1);
        System.out.println("Sum of longest path from root to leaf: "+res.sum);
    }
}
//Time Complexity: O(n)