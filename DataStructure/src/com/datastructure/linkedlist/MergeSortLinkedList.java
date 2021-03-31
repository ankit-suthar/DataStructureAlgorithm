package com.datastructure.linkedlist;

public class MergeSortLinkedList {
    Node head;

    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }

    void push(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    void printLinkedList(){
        Node node = head;
        while (node!=null){
            System.out.print(node.data+" ");
            node= node.next;
        }
        System.out.println();
    }

    public Node getMiddle(Node node){
        Node slow=node;
        Node fast=node.next;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    Node sortLinkedList(Node a,Node b){
        Node result;

        if(a==null){
            return b;
        }

        if(b==null){
            return a;
        }

        if(a.data<b.data){
            result = a;
            result.next = sortLinkedList(a.next,b);
        }else{
            result = b;
            result.next = sortLinkedList(a,b.next);
        }
        return result;
    }

    Node mergeSort(Node node){
        if(node==null || node.next==null){
            return node;
        }
        Node middle = getMiddle(node);

        Node node1 = node;
        Node node2 = middle.next;
        middle.next=null;

        Node left = mergeSort(node1);
        Node right = mergeSort(node2);

        Node result = sortLinkedList(left,right);
        return result;
    }

    public static void main(String[] a){
        MergeSortLinkedList mergeSortLinkedList = new MergeSortLinkedList();
        mergeSortLinkedList.push(15);
        mergeSortLinkedList.push(10);
        mergeSortLinkedList.push(5);
        mergeSortLinkedList.push(1);
        mergeSortLinkedList.push(20);
        mergeSortLinkedList.push(3);
        mergeSortLinkedList.push(2);

        mergeSortLinkedList.printLinkedList();
        mergeSortLinkedList.head = mergeSortLinkedList.mergeSort(mergeSortLinkedList.head);
        mergeSortLinkedList.printLinkedList();

    }
}
//Time Complexity: O(n Log n)