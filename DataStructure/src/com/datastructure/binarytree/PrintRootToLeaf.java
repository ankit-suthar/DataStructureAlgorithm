package com.datastructure.binarytree;

public class PrintRootToLeaf {

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

    void printPathRootToLeaf(int arr[],int index){
        for(int i=0;i<index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    void pathRootToLeafUtil(Node n,int arr[],int index){
        if(n==null){
            return;
        }
        arr[index]=n.data;
        index++;
        if(n.left==null && n.right==null){
            printPathRootToLeaf(arr,index);
            return;
        }
        pathRootToLeafUtil(n.left,arr,index);
        pathRootToLeafUtil(n.right,arr,index);
    }

    void pathRootToLeaf(Node n){
        if(n==null){
            return;
        }
        int arr[] = new int[1000];
        int index=0;
        pathRootToLeafUtil(n,arr,index);
    }

    public static void main(String[] a){
        PrintRootToLeaf tree = new PrintRootToLeaf();

        tree.root=tree.new Node(1);
        tree.root.left=tree.new Node(2);
        tree.root.right=tree.new Node(3);
        tree.root.left.left=tree.new Node(4);
        tree.root.left.right=tree.new Node(5);
        tree.root.right.left=tree.new Node(6);
        tree.root.right.right=tree.new Node(7);

        tree.pathRootToLeaf(tree.root);
    }
}
