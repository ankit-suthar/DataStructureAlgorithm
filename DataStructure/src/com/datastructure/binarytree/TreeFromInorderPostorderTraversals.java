package com.datastructure.binarytree;

public class TreeFromInorderPostorderTraversals {
    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    static int postfix;

    Node buildTree(int in[],int[] post,int l,int h){
        if(l>h){
            return null;
        }

        Node n = new Node(post[postfix]);
        int mid = getIndexOfElement(in,post[postfix]);
        postfix--;
        n.right = buildTree(in,post,mid+1,h);
        n.left = buildTree(in,post,l,mid-1);
        return n;
    }

    int getIndexOfElement(int in[],int d){
        int i;
        for(i=0;i<in.length;i++){
            if(in[i]==d){
                break;
            }
        }
        return i;
    }

    void printInorder(Node n){
        if(n==null){
            return;
        }
        printInorder(n.left);
        System.out.print(n.data+" ");
        printInorder(n.right);
    }

    public static void main(String[] args) {
        TreeFromInorderPostorderTraversals tree=new TreeFromInorderPostorderTraversals();
//        int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
//        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};

        int[] in = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};

        int len=in.length;
        postfix = len-1;
        Node root=tree.buildTree(in,post,0,len-1);

        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
//Time Complexity: O(n^2)