package com.datastructure.linkedlist;

public class SumOfTwoLinkedlistMthd3 {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }

    Node head1, head2, prev;
    Node head;
    Node result;
    int sum;
    int carry;

    void printList(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }

    void push(int data){
        Node node = new Node(data);

        if(result==null){
            result = node;
            prev = node;
        }else{
            prev.next = node;
            prev = node;
        }
    }

    void addTwoLists(Node node1,Node node2){

        while(node1!=null || node2!=null) {
            sum = ((node1 != null) ? node1.data : 0) + ((node2 != null) ? node2.data : 0) + carry;
            push(sum % 10);
            carry = sum / 10;

            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }
        }
    }

    Node reverseList(Node node,Node prev){
        if(node==null){
            head = prev;
            return prev;
        }
        Node node1 = reverseList(node.next,node);
        node1.next = prev;
        return prev;
    }

    void reverseList1(Node node){
        Node prevNode=null,currNode=node,nextNode;

        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }
    
        
    public static void main(String[] a){
        SumOfTwoLinkedlistMthd3 list = new SumOfTwoLinkedlistMthd3();

        list.head1 = list.new Node(7);
        list.head1.next = list.new Node(5);
        list.head1.next.next = list.new Node(9);
        list.head1.next.next.next = list.new Node(4);
        list.head1.next.next.next.next = list.new Node(6);
        System.out.println("First List is ");
        list.printList(list.head1);

        list.head2 = list.new Node(8);
        list.head2.next = list.new Node(4);
        System.out.println("Second List is ");
        list.printList(list.head2);

        list.addTwoLists(list.head1, list.head2);
        System.out.println("Resultant List is ");
        list.printList(list.result);

        //reverse linkedlist method 1
        list.head = list.new Node(7);
        list.head.next = list.new Node(5);
        list.head.next.next = list.new Node(9);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(6);
        list.printList(list.head);
        System.out.println();
        list.reverseList(list.head,null);
        list.printList(list.head);

        //reverse linkedlist method 1
        list.head = list.new Node(7);
        list.head.next = list.new Node(5);
        list.head.next.next = list.new Node(9);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(6);
        list.printList(list.head);
        System.out.println();
        list.reverseList1(list.head);
        list.printList(list.head);
    }
}
//Time Complexity: O(m+n) where m and n are the sizes of given two linked lists