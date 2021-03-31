package com.datastructure.linkedlist;

public class SwapNodesInLinkedList {
    Node head;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    void push(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    void printList(){
        Node node = head;
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    void swapNode(int data1,int data2){
        Node prevX=null;
        Node currX=head;

        while(currX!=null && currX.data!=data1){
            prevX=currX;
            currX=currX.next;
        }

        Node prevY=null;
        Node currY=head;

        while(currY!=null && currY.data!=data2){
            prevY=currY;
            currY=currY.next;
        }

        if(currX==null || currY==null){
            return;
        }

        if(prevX!=null){
            prevX.next=currY;
        }else{
            head=currY;
        }

        if(prevY!=null){
            prevY.next=currX;
        }else{
            head=currX;
        }

        Node temp = currX.next;
        currX.next=currY.next;
        currY.next=temp;
    }

    public static void main(String[] a){
            SwapNodesInLinkedList swapNodesInLinkedList = new SwapNodesInLinkedList();
            swapNodesInLinkedList.push(7);
            swapNodesInLinkedList.push(1);
            swapNodesInLinkedList.push(9);
            swapNodesInLinkedList.push(2);
            swapNodesInLinkedList.push(3);
            swapNodesInLinkedList.push(8);
            swapNodesInLinkedList.push(5);

        System.out.println("\nCreated Linked list is: ");
        swapNodesInLinkedList.printList();
        swapNodesInLinkedList.swapNode(2,7);
        System.out.println("\nLinkedlist after swap node position: ");
        swapNodesInLinkedList.printList();

    }
}
