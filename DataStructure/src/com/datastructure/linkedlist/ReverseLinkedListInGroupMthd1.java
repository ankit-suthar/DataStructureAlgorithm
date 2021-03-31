package com.datastructure.linkedlist;

public class ReverseLinkedListInGroupMthd1 {

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    Node head;

    void push(int data){
        Node n = new Node(data);
        if(head==null){
            head=n;
            return;
        }
        n.next=head;
        head=n;
    }

    Node reverseInGroup(Node n,int size){
        if(n==null){
            return null;
        }
        Node curr=n;
        Node prev=null;
        Node next=null;
        int c=0;

        while(c!=size && curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        n.next = reverseInGroup(next,size);
        return prev;
    }

    void printNodes(){
        Node n = head;
        while (n!=null){
            System.out.print(n.data+" ");
            n=n.next;
        }
        System.out.println();
    }

    public static void main(String[] a){
        ReverseLinkedListInGroupMthd1 linkedlist = new ReverseLinkedListInGroupMthd1();
        linkedlist.push(1);
        linkedlist.push(2);
        linkedlist.push(3);
        linkedlist.push(4);
        linkedlist.push(5);
        linkedlist.push(6);
        linkedlist.push(7);
        linkedlist.push(8);
        linkedlist.push(9);
        linkedlist.push(10);
        linkedlist.printNodes();
        linkedlist.head = linkedlist.reverseInGroup(linkedlist.head,3);
        linkedlist.printNodes();
    }
}
