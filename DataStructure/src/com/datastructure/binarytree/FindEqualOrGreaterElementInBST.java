package com.datastructure.binarytree;

public class FindEqualOrGreaterElementInBST {

    class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    Node root,large;

    Node addNode(Node n, int data){
        if(n==null){
            n = new Node(data);
            return n;
        }
        if(n.data>data){
            n.left = addNode(n.left,data);
        }else{
            n.right = addNode(n.right,data);
        }
        return n;
    }

    void findEqualOrGreaterNode(Node node,int value){

        if(node==null){
            return;
        }

        if(large==null && node.data>=value){
            large=node;
        }

        if(large!=null && node.data<large.data && node.data>=value){
            large = node;
        }

        if(node.data>value){
            findEqualOrGreaterNode(node.left,value);
        }else{
            findEqualOrGreaterNode(node.right,value);
        }
    }

    public static void main(String[] a){
            FindEqualOrGreaterElementInBST f = new FindEqualOrGreaterElementInBST();
            f.root = f.addNode(f.root,5);
            f.addNode(f.root,5);
            f.addNode(f.root,2);
            f.addNode(f.root,1);
            f.addNode(f.root,3);
            f.addNode(f.root,12);
            f.addNode(f.root,9);
            f.addNode(f.root,21);
            f.addNode(f.root,19);
            f.addNode(f.root,25);

        f.findEqualOrGreaterNode(f.root,5);
        if(f.large!=null){
            System.out.println(f.large.data);
        }else{
            System.out.println("Not");
        }
    }
}


