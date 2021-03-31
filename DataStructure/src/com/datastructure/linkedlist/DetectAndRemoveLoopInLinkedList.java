package com.datastructure.linkedlist;

public class DetectAndRemoveLoopInLinkedList {
    Node head;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    void detectAndRemoveLoop(Node n){

        Node slow=n;
        Node fast=n;

        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                removeLoop(slow,fast,n);
                break;
            }
        }
    }

    void removeLoop(Node slow,Node fast,Node n){
        slow=n.next;

        while(fast.next!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }

    public static void main(String[] a){
        DetectAndRemoveLoopInLinkedList list = new DetectAndRemoveLoopInLinkedList();
        list.head = list.new Node(50);
        list.head.next = list.new Node(20);
        list.head.next.next = list.new Node(15);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(10);

        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop(list.head);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(1)