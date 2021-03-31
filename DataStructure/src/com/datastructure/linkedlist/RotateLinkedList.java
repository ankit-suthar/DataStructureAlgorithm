package com.datastructure.linkedlist;

public class RotateLinkedList {

    Node head;

    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void push(int new_data)
    {
        Node new_node = new Node(new_data);

        new_node.next = head;

        head = new_node;
    }

    void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    void rotate(int count){
        int c = 1;
        Node n = head;

        while(c<count && n!=null){
            n=n.next;
            c++;
        }

        if(n==null){
            return;
        }

        Node newNode = n.next;
        Node lastNode = n.next;
        while(lastNode.next!=null){
            lastNode=lastNode.next;
        }
        lastNode.next=head;
        n.next=null;
        head=newNode;
    }

    public static void main(String args[])
    {
        RotateLinkedList llist = new RotateLinkedList();

        for (int i = 60; i >= 10; i -= 10)
            llist.push(i);
        /*for (int i = 2; i >= 1; i -= 1)
            llist.push(i);*/

        System.out.println("Given list");
        llist.printList();

        llist.rotate(4);

        System.out.println("Rotated Linked List");
        llist.printList();
    }
}
//Time Complexity: O(n) where n is the number of nodes in Linked List.