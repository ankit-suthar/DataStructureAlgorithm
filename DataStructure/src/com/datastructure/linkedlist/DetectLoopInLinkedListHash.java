package com.datastructure.linkedlist;

import java.util.HashSet;

public class DetectLoopInLinkedListHash {

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
        HashSet<Node> hs = new HashSet<>();

        while(n!=null){
            if(hs.contains(n)){
                System.out.println("Loop found in linked list");
                return;
            }
            hs.add(n);
            n=n.next;
        }
        System.out.println("There is no loop in linked list");
    }

    public static void main(String[] a){
        DetectLoopInLinkedListHash dlil = new DetectLoopInLinkedListHash();
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
//Auxiliary Space: O(n)