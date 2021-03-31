package com.datastructure.linkedlist;

public class DeleteNodeWithoutHeadPointer {
    Node head;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    void deleteNodeWithoutHead(Node deleteNode) {
        if (deleteNode.next == null) {
            return;
        }

        Node prev=null;

        while (deleteNode.next != null) {
            prev = deleteNode;
            deleteNode.data = deleteNode.next.data;
            deleteNode = deleteNode.next;
        }

        prev.next = null;
    }

    void printLinkedList(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        DeleteNodeWithoutHeadPointer list = new DeleteNodeWithoutHeadPointer();
        list.head = list.new Node(1);
        list.head.next = list.new Node(12);
        list.head.next.next = list.new Node(5);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(7);
        Node deleteNode = list.head.next.next.next;

        list.printLinkedList(list.head);
        System.out.println();
        list.deleteNodeWithoutHead(deleteNode); //4
        list.printLinkedList(list.head);
    }
}
