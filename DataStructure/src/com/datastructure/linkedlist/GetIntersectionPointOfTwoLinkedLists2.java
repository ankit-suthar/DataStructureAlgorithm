package com.datastructure.linkedlist;

public class GetIntersectionPointOfTwoLinkedLists2 {
    Node head1;
    Node head2;

    class Node {
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    Node getNode(){
        Node n1 = head1;
        Node n2 = head2;

        while(n1!=n2){

            if(n1==null){
                n1=head2;
            }else {
                n1=n1.next;
            }

            if(n2==null){
                n2=head1;
            }else{
                n2=n2.next;
            }
        }
        return n1;
    }

    public static void main(String[] a){
        GetIntersectionPointOfTwoLinkedLists2 list = new GetIntersectionPointOfTwoLinkedLists2();
        // creating first linked list
        list.head1 = list.new Node(1);
        list.head1.next = list.new Node(2);
        list.head1.next.next = list.new Node(3);
        list.head1.next.next.next = list.new Node(4);
        list.head1.next.next.next.next = list.new Node(5);
        list.head1.next.next.next.next.next = list.new Node(6);
        list.head1.next.next.next.next.next.next = list.new Node(7);

        // creating second linked list
        list.head2 = list.new Node(10);
        list.head2.next = list.new Node(9);
        list.head2.next.next = list.new Node(8);
        list.head2.next.next.next = list.head1.next.next.next;

        Node ans = list.getNode();
        if(ans!=null){
            System.out.println("The node of intersection is " +ans.data);
        }else {
            System.out.println("There is no intersection between two linked list");
        }
    }
}
//Time complexity: O(m+n)
//Auxiliary Space: O(1)