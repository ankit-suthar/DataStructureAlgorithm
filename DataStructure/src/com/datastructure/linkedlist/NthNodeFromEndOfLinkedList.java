package com.datastructure.linkedlist;

public class NthNodeFromEndOfLinkedList {

    Node head;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }

    void nthNodeFromEnd(Node n,int index){
        if(n==null){
            return;
        }
        int count=1;

        Node first = n;
        Node second = n;

        while(count<index){
            second=second.next;
            count++;
        }

        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        System.out.println(first.data);
    }

    public static void main(String[] a){
        NthNodeFromEndOfLinkedList nth = new NthNodeFromEndOfLinkedList();
        int index = 3;
        nth.head = nth.new Node(1);
        nth.head.next = nth.new Node(2);
        nth.head.next.next = nth.new Node(3);
        nth.head.next.next.next = nth.new Node(4);
        nth.head.next.next.next.next = nth.new Node(5);
        nth.head.next.next.next.next.next = nth.new Node(6);
        nth.head.next.next.next.next.next.next = nth.new Node(7);
        nth.head.next.next.next.next.next.next.next = nth.new Node(8);
        nth.head.next.next.next.next.next.next.next.next = nth.new Node(9);

        nth.nthNodeFromEnd(nth.head,index);
    }
}
//Time Complexity: O(n) where n is the length of linked list