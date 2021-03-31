package com.datastructure.binarytree;

public class PrintLongestLeafToLeafPathInBinaryTree {
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

    int max=Integer.MIN_VALUE;
    Node node;
    int lH,rH,flag;

    int printLongestPathLeafToLeaf(Node n){
        if(n==null){
            return 0;
        }
        int lHeight = printLongestPathLeafToLeaf(n.left);
        int rHeight = printLongestPathLeafToLeaf(n.right);

        if(max<1+lHeight+rHeight){
            max = 1+lHeight+rHeight;
            node = n;
            lH=lHeight;
            rH=rHeight;
        }

        return 1+Math.max(lHeight,rHeight);
    }

    void printNodes(Node n,int arr[],int index){
        if(n==null){
            return;
        }

        arr[index]=n.data;
        index++;

        if(n.left==null && n.right==null){
            printNodesUtil(arr,index);
        }else{
            printNodes(n.left,arr,index);
            printNodes(n.right,arr,index);
        }
    }

    void printNodesUtil(int arr[],int index){
        if(flag==0){
            if(index==lH){
                for(int i=index-1;i>=0;i--){
                    System.out.print(arr[i]+" ");
                }
                flag=2;
            }
        }else if(flag==1){
            if(index==rH){
                for(int i=0;i<index;i++){
                    System.out.print(arr[i]+" ");
                }
                flag=2;
            }
        }
    }

    public static void main(String[] a){
        PrintLongestLeafToLeafPathInBinaryTree tree = new PrintLongestLeafToLeafPathInBinaryTree();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.left.right.left = tree.new Node(6);
        tree.root.left.right.right = tree.new Node(7);
        tree.root.left.left.right = tree.new Node(8);
        tree.root.left.left.right.left = tree.new Node(9);

        tree.printLongestPathLeafToLeaf(tree.root);
        int arr[] = new int[1000];
        tree.flag=0;
        tree.printNodes(tree.node.left,arr,0);
        arr = new int[1000];
        tree.flag=1;
        System.out.print(tree.node.data+" ");
        tree.printNodes(tree.node.right,arr,0);
    }
}
