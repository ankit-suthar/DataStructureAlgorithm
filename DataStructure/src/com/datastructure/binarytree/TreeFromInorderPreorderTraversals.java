package com.datastructure.binarytree;

public class TreeFromInorderPreorderTraversals {

    class Node{
        char data;
        Node left;
        Node right;

        Node(char d){
            data=d;
            left=right=null;
        }
    }

    static int prefix = 0 ;

    Node buildTree(char[] in,char[] pre,int l,int h){

        if(l>h){
            return null;
        }

        Node n = new Node(pre[prefix]);
        int mid = determineIndex(pre[prefix],in);
        prefix++;

        n.left = buildTree(in,pre,l,mid-1);
        n.right = buildTree(in,pre,mid+1,h);
        return n;
    }

    int determineIndex(char c,char[] in){
        int i;
        for(i=0;i<in.length;i++){
            if(c==in[i]){
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
        TreeFromInorderPreorderTraversals tree=new TreeFromInorderPreorderTraversals();
        char in[]=new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[]=new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len=in.length;

        Node root=tree.buildTree(in,pre,0,len-1);

        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
/**
 * Time Complexity: O(n^2)
 * Worst case occurs when tree is left skewed.
 * Ex.: Preorder and Inorder traversals for worst case are {A, B, C, D} and {D, C, B, A}
 */