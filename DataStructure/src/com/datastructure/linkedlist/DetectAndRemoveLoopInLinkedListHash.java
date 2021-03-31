package com.datastructure.linkedlist;

import java.util.HashSet;

public class DetectAndRemoveLoopInLinkedListHash {
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
        Node newNode = new Node(data);
        newNode.next=head;
        head=newNode;
    }

    void detectAndRemoveLoop(Node n){
        HashSet<Node> hs = new HashSet<>();
        Node prev=null;

        while(n!=null){
            if(hs.contains(n)){
                prev.next=null;
                break;
            }else{
                hs.add(n);
                prev=n;
                n=n.next;
            }
        }
    }

    public static void main(String[] a){
        DetectAndRemoveLoopInLinkedListHash list = new DetectAndRemoveLoopInLinkedListHash();
        list.push(10);
        list.push(4);
        list.push(15);
        list.push(30);
        list.push(50);

        list.head.next.next.next.next.next = list.head.next.next;
        list.detectAndRemoveLoop(list.head);
    }
}
//Time Complexity: O(n)
//Auxiliary Space: O(n)