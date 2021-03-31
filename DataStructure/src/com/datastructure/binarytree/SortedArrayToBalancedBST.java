package com.datastructure.binarytree;

public class SortedArrayToBalancedBST {

    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    Node balancedBST(int arr[],int l,int h){
        if(l>h){
            return null;
        }
        int mid = (l+h)/2;
        Node n = new Node(arr[mid]);
        n.left = balancedBST(arr,l,mid-1);
        n.right = balancedBST(arr,mid+1,h);
        return n;
    }

    void printTree(Node n){
        if(n==null){
            return;
        }
        printTree(n.left);
        System.out.print(n.data+" ");
        printTree(n.right);
    }

    public static void main(String[] args) {
        SortedArrayToBalancedBST tree=new SortedArrayToBalancedBST();
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        Node root = tree.balancedBST(arr,0,arr.length-1);
        tree.printTree(root);
    }
}
//Time Complexity: O(n)