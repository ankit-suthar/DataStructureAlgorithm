package com.datastructure.binarytree;

public class BSTtoDoublyLinkedList {
    Node root;
    Node prev=null;
    Node head=null;

    class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    void convertBSTToDoubleLinkedList(Node node){
        if(node==null){
            return;
        }

        convertBSTToDoubleLinkedList(node.left);

        if(prev==null){
            prev=node;
            head=prev;
        }else{
            prev.right=node;
            node.left=prev;
            prev=node;
        }

        convertBSTToDoubleLinkedList(node.right);
    }

    void printDoublyLinkedlist(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.right;
        }
        System.out.println();
    }

    public static void main(String[] a){
        BSTtoDoublyLinkedList bsTtoDoublyLinkedList = new BSTtoDoublyLinkedList();

        bsTtoDoublyLinkedList.root = bsTtoDoublyLinkedList.new Node(5);
        bsTtoDoublyLinkedList.root.left = bsTtoDoublyLinkedList.new Node(3);
        bsTtoDoublyLinkedList.root.right = bsTtoDoublyLinkedList.new Node(6);
        bsTtoDoublyLinkedList.root.left.right = bsTtoDoublyLinkedList.new Node(4);
        bsTtoDoublyLinkedList.root.left.left = bsTtoDoublyLinkedList.new Node(1);
        bsTtoDoublyLinkedList.root.right.right = bsTtoDoublyLinkedList.new Node(8);
        bsTtoDoublyLinkedList.root.left.left.right = bsTtoDoublyLinkedList.new Node(2);
        bsTtoDoublyLinkedList.root.left.left.left = bsTtoDoublyLinkedList.new Node(0);
        bsTtoDoublyLinkedList.root.right.right.left = bsTtoDoublyLinkedList.new Node(7);
        bsTtoDoublyLinkedList.root.right.right.right = bsTtoDoublyLinkedList.new Node(9);

        bsTtoDoublyLinkedList.convertBSTToDoubleLinkedList(bsTtoDoublyLinkedList.root);
        bsTtoDoublyLinkedList.printDoublyLinkedlist(bsTtoDoublyLinkedList.head);
    }
}
