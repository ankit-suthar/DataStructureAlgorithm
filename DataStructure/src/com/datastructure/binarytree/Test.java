package com.datastructure.binarytree;

public class Test{
    Node head;
    Node head2;

    class Node{
        int data;
        Node next;
        Node random;

        public Node(int data){
            this.data=data;
        }
    }

    void createCloneLinkedList(){
        Node start = head;

        while(start!=null){
            Node node = new Node(start.data);
            Node next = start.next;
            start.next = node;
            node.next = next;
            start = next;
        }

        start = head;

        while(start!=null){
            if(start.random!=null){
                start.next.random = start.random.next;
            }
            start = start.next;
        }

        start = head;
        head2 = start.next;
        Node start2 = head2;

        while(start2.next!=null){
            Node node = start.next.next;
            start2.next = node.next;
            start.next = node;
            start = start.next;
            start2 = start2.next;
        }
        start.next=null;
        start2.next=null;
    }

    void printClonedLinkedList(){
        Node n1 = head;
        Node n2 = head;
        while(n1!=null){
            System.out.print(n1.data+" - "+n2.data+" ");
            n1 = n1.next;
            n2 = n2.next;
        }
    }

    public static void main(String[] a){
        Test linkedList = new Test();

        linkedList.head = linkedList.new Node(1);
        linkedList.head.next = linkedList.new Node(2);
        linkedList.head.next.next = linkedList.new Node(3);
        linkedList.head.next.next.next = linkedList.new Node(4);
        linkedList.head.next.next.next.next = linkedList.new Node(5);
        linkedList.head.next.next.next.next.next = linkedList.new Node(6);

        linkedList.head.random = linkedList.head.next.next;
        linkedList.head.next.random = linkedList.head;
        linkedList.head.next.next.random = linkedList.head.next.next.next.next;
        linkedList.head.next.next.next.random = linkedList.head.next.next.next.next;
        linkedList.head.next.next.next.next.random = linkedList.head.next;

        linkedList.createCloneLinkedList();
        linkedList.printClonedLinkedList();
    }
}

