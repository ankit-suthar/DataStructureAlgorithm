package com.datastructure.binarytree;

public class PrintFirstShortestRootToLeafPathInBinaryTree {
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
        int minLen=Integer.MAX_VALUE;
    }

    void printShortestPathFromRootToLeaf(Node n,Result res,int level){
        if (n == null) {
            return;
        }

        if(n.left==null && n.right==null){
            if(level < res.minLen){
                res.minLen=level;
            }
            return;
        }

        printShortestPathFromRootToLeaf(n.left,res,level+1);
        printShortestPathFromRootToLeaf(n.right,res,level+1);
    }

    void printShortestPathFromRootToLeafUtil(Node n,Result res,int arr[],int index){
        if(n==null){
            return;
        }

        arr[index]=n.data;
        index++;

        if(n.left==null && n.right==null && res.minLen==index){
            for(int i=0;i<index;i++){
                System.out.print(arr[i]+" ");
            }
            res.minLen=-1;
        }
        printShortestPathFromRootToLeafUtil(n.left,res,arr,index);
        printShortestPathFromRootToLeafUtil(n.right,res,arr,index);
    }

    public static void main(String[] a){
        PrintFirstShortestRootToLeafPathInBinaryTree tree = new PrintFirstShortestRootToLeafPathInBinaryTree();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.right.left = tree.new Node(5);
        tree.root.right.right = tree.new Node(7);
        tree.root.left.left.left = tree.new Node(10);
        tree.root.left.left.right = tree.new Node(11);
        tree.root.right.right.left = tree.new Node(8);

        int arr[] = new int[1000];
        Result res = tree.new Result();
        tree.printShortestPathFromRootToLeaf(tree.root,res,1);
        tree.printShortestPathFromRootToLeafUtil(tree.root,res,arr,0);
    }
}
