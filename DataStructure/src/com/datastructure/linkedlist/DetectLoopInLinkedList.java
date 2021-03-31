package com.datastructure.linkedlist;

public class DetectLoopInLinkedList {

    Node head;
    Node last;

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }

    void addNode(int data){
        Node n = new Node(data);

        if(head==null){
            head = n;
        }else{
            last.next=n;
        }
        last=n;
    }

    void detectLoop(Node n){
        if(n.next==null){
            System.out.println("There is no loop");
            return;
        }
        if(n.next==n){
            System.out.println("There is loop in linked list");
            return;
        }
        Node slow = n.next;
        Node fast = n.next.next;
        if(fast==null){
            System.out.println("There is no loop");
            return;
        }

        while(slow!=fast && fast!=null && slow.next!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }
        }
        if(slow==fast){
            System.out.println("Loop detected");
            return;
        }
        System.out.println("There is no loop");

        /*Node slow=n;
        Node fast=n;
        while(slow!=null && fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("Loop detected");
                return;
            }
        }
        System.out.println("There is no loop");*/
    }

    public static void main(String[] a){
        DetectLoopInLinkedList dlil = new DetectLoopInLinkedList();
        dlil.addNode(1);
        dlil.addNode(2);
        dlil.addNode(3);
        dlil.addNode(4);
        dlil.addNode(5);
        dlil.addNode(6);
        dlil.head.next.next.next.next.next.next=dlil.head.next;

        dlil.detectLoop(dlil.head);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(1)