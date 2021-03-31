/*
Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Examples:

Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
Output:  3->2->1->6->5->4->8->7->NULL.

Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
Output:  5->4->3->2->1->8->7->6->NULL.

we have used a stack which will store the nodes of the given linked list.
Firstly, push the k elements of the linked list in the stack. Now pop elements one by one and keep track of
the previously popped node. Point the next pointer of prev node to top element of stack. Repeat this process,
until NULL is reached.

This algorithm uses O(k) extra space.
*/
package com.datastructure.linkedlist;

import java.util.Stack;

public class ReverseLinkedListInGroupMthd2 {

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
        Node node = new Node(data);
        node.next=head;
        head=node;
    }

    void reverseInGroup(Node n,int size){
        if(n==null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        int count=0;
        Node curr=n;
        Node prev=null;

        while(curr!=null){

            count=0;

            while(count<size && curr!=null){
                stack.push(curr);
                curr=curr.next;
                count++;
            }

            while(!stack.isEmpty()){

                if(prev == null){
                    prev = stack.peek();
                    head=prev;
                }else{
                    prev.next=stack.peek();
                    prev=stack.peek();
                }
                stack.pop();
            }
        }
    }

    void printNodes(){
        Node node = head;
        while (node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    public static void main(String[] a){
        ReverseLinkedListInGroupMthd2 linkedlist = new ReverseLinkedListInGroupMthd2();
        linkedlist.push(10);
        linkedlist.push(9);
        linkedlist.push(8);
        linkedlist.push(7);
        linkedlist.push(6);
        linkedlist.push(5);
        linkedlist.push(4);
        linkedlist.push(3);
        linkedlist.push(2);
        linkedlist.push(1);
        linkedlist.printNodes();
        linkedlist.reverseInGroup(linkedlist.head,3);
        linkedlist.printNodes();
    }
}
//Time complexity: O(n)
//O(k) extra space
