package com.datastructure.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListHashing {

    Node head;
    Node tail;

    class Node{
        int data;
        Node next,rand;

        Node(int d){
            data=d;
            next=rand=null;
        }
    }

    private void push(int v) {
        if(head==null){
            head = new Node(v);
            tail=head;
        }
        else{
            tail.next=new Node(v);
            tail=tail.next;
        }
    }

    void printLinkedList(Node n){
        while(n!=null){
            System.out.println(n.data+" "+n.rand.data);
            n=n.next;
        }
    }

    Node cloneLinkedList(){
        Map<Node,Node> map = new HashMap<>();
        Node node1=head;
        Node node2;

        while(node1!=null){
            node2 = new Node(node1.data);
            map.put(node1,node2);
            node1=node1.next;
        }
        node1=head;

        while(node1!=null){
            node2 = map.get(node1);
            node2.next = map.get(node1.next);
            node2.rand = map.get(node1.rand);
            node1=node1.next;
        }
        return map.get(head);
    }

    public static void main(String[] a){
        CloneLinkedListHashing cloneLinkedListHashing = new CloneLinkedListHashing();

        cloneLinkedListHashing.push(1);
        cloneLinkedListHashing.push(2);
        cloneLinkedListHashing.push(3);
        cloneLinkedListHashing.push(4);
        cloneLinkedListHashing.push(5);

        cloneLinkedListHashing.head.rand = cloneLinkedListHashing.head.next.next;
        cloneLinkedListHashing.head.next.rand = cloneLinkedListHashing.head;
        cloneLinkedListHashing.head.next.next.rand = cloneLinkedListHashing.tail;
        cloneLinkedListHashing.head.next.next.next.rand = cloneLinkedListHashing.head.next.next;
        cloneLinkedListHashing.tail.rand = cloneLinkedListHashing.head.next;

        cloneLinkedListHashing.printLinkedList(cloneLinkedListHashing.head);
        Node newHead = cloneLinkedListHashing.cloneLinkedList();
        System.out.println("-------------------");
        cloneLinkedListHashing.printLinkedList(newHead);
    }

}
