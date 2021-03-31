package com.datastructure.binarytree;

public class PrintAllNodesAtDistanceKFromGivenNode {
    Node root;

    class Node
    {
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    void printKDistanceNodesDown(Node n,int k){
        if(n==null || k<0){
            return;
        }
        if(k==0){
            System.out.print(n.data+" ");
            return;
        }
        printKDistanceNodesDown(n.left,k-1);
        printKDistanceNodesDown(n.right,k-1);
    }

    int printKDistanceNodes(Node n,Node target,int k){
        if(n==null){
            return -1;
        }

        if(n==target){
            printKDistanceNodesDown(n,k);
            return 0;
        }

        int dL = printKDistanceNodes(n.left,target,k);

        if(dL!=-1){
            if(dL+1==k){
                System.out.print(n.data+" ");
            }else{
                printKDistanceNodesDown(n.right,k-dL-2);
            }
            return dL+1;
        }

        int dR = printKDistanceNodes(n.right,target,k);

        if(dR!=-1){
            if(dR+1==k){
                System.out.print(n.data+" ");
            }else{
                printKDistanceNodesDown(n.left,k-dR-2);
            }
            return dR+1;
        }
        return -1;
    }

    public static void main(String[] a){
        PrintAllNodesAtDistanceKFromGivenNode tree = new PrintAllNodesAtDistanceKFromGivenNode();
        /*tree.root = tree.new Node(20);
        tree.root.left = tree.new Node(8);
        tree.root.right = tree.new Node(22);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(12);
        tree.root.left.right.left = tree.new Node(10);
        tree.root.left.right.right = tree.new Node(14);*/
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.left.left = tree.new Node(6);
        tree.root.left.left.right = tree.new Node(7);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(8);
        tree.root.right.left.left = tree.new Node(10);
        tree.root.right.left.right = tree.new Node(11);
        tree.root.right.left.right.left = tree.new Node(12);
        tree.root.right.right = tree.new Node(9);

        Node target = tree.root.left.right;
        tree.printKDistanceNodes(tree.root, target, 3);
    }

}
