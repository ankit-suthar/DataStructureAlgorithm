package com.datastructure.binarytree;

public class ReverseLevelOrderTraversal {
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

    void reverseLevelOrderTraversal(Node n){
            if(n==null){
                return;
            }

            int height = heightOfTree(n);
            for(int i=height;i>0;i--){
                printReverseOrder(i,n);
            }
    }

    void printReverseOrder(int level,Node n){
        if(n==null){
            return;
        }

        if(level==1){
            System.out.print(n.data+" ");
        }else{
            printReverseOrder(level-1,n.right);
            printReverseOrder(level-1,n.left);
        }
    }

    int heightOfTree(Node n){
        if(n==null)
            return 0;
        return Math.max(heightOfTree(n.left),heightOfTree(n.right))+1;
    }

    public static void main(String[] a){
        ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();

        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);
        tree.reverseLevelOrderTraversal(tree.root);
    }
}
