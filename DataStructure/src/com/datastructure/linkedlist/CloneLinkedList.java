package com.datastructure.linkedlist;

public class CloneLinkedList {

    class Node{
        int data;
        Node next,random;

        Node(int data){
            this.data=data;
            next=null;
            random=null;
        }
    }

    void createCloneLinkedList(Node start){
        Node clone;
        Node node;
        Node n=start;

        while(n!=null){
            clone = new Node(n.data);
            node = n.next;
            n.next = clone;
            clone.next=node;
            n=node;
        }
        n=start;

        while(n!=null){
            if(n.random!=null){
                n.next.random = n.random.next;
            }
            n=n.next.next;
        }

        Node n1=start;
        clone=n1.next;
        Node n2=n1.next;;

        while(n2.next!=null){
            node=n1.next.next;
            n1.next=node;
            n2.next=node.next;
            n1=n1.next;
            n2=n2.next;
        }
        n1.next=null;
        n2.next=null;

        printLinkedList(start);
        printLinkedList(clone);
    }

    void printLinkedList(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    public static void main(String[] a){
        CloneLinkedList linkedList = new CloneLinkedList();

        Node start = linkedList.new Node(1);
        start.next = linkedList.new Node(2);
        start.next.next = linkedList.new Node(3);
        start.next.next.next = linkedList.new Node(4);
        start.next.next.next.next = linkedList.new Node(5);
        start.next.next.next.next.next = linkedList.new Node(6);

        // 1's random points to 3
        start.random = start.next.next;

        // 2's random points to 1
        start.next.random = start;

        // 3's and 4's random points to 5
        start.next.next.random = start.next.next.next.next;
        start.next.next.next.random = start.next.next.next.next;

        // 5's random points to 2
        start.next.next.next.next.random = start.next;

        linkedList.createCloneLinkedList(start);

    }
}
