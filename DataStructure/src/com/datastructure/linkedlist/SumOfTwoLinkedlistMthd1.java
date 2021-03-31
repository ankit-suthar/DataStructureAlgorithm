package com.datastructure.linkedlist;

public class SumOfTwoLinkedlistMthd1 {

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            next=null;
        }
    }

    Node getSumOfTwoLinkedList(Node node1,Node node2){
        Node newHead=null;
        Node node3=null;
        int carry=0;
        int sum;

        while(node1!=null && node2!=null){
            sum = node1.data + node2.data + carry;

            if(sum>=10){
                carry = sum/10;
                sum = sum%10;
            }else{
                carry=0;
            }

            if(node3==null){
                node3 = new Node(sum);
                newHead = node3;
            }else {
                Node n = new Node(sum);
                node3.next = n;
                node3=n;
            }
            node1=node1.next;
            node2=node2.next;
        }

        while(node1!=null){
            sum = node1.data + carry;

            if(sum>=10){
                carry = sum/10;
                sum = sum%10;
            }

            if(node3==null){
                node3 = new Node(sum);
                newHead = node3;
            }else {
                Node n = new Node(sum);
                node3.next = n;
                node3=n;
            }
            node1=node1.next;
        }

        while (node2!=null){
            sum = node2.data + carry;

            if(sum>=10){
                carry = sum/10;
                sum = sum%10;
            }

            if(node3==null){
                node3 = new Node(sum);
                newHead = node3;
            }else {
                Node n = new Node(sum);
                node3.next = n;
                node3=n;
            }
            node2=node2.next;
        }

        if(carry!=0){
          Node n = new Node(carry);
          node3.next=n;
          node3=n;
        }
        return newHead;
    }

    void printLinkedlist(Node node){
        while(node!=null){
            System.out.print(node.data);
            node=node.next;
        }
        System.out.println();
    }

    public static void main(String[] a){
            SumOfTwoLinkedlistMthd1 sumOfTwoLinkedlist = new SumOfTwoLinkedlistMthd1();

            Node n1 = sumOfTwoLinkedlist.new Node(2);
            n1.next = sumOfTwoLinkedlist.new Node(4);
            n1.next.next = sumOfTwoLinkedlist.new Node(6);
            sumOfTwoLinkedlist.printLinkedlist(n1);

            Node n2 = sumOfTwoLinkedlist.new Node(8);
            n2.next = sumOfTwoLinkedlist.new Node(0);
            n2.next.next = sumOfTwoLinkedlist.new Node(9);
            sumOfTwoLinkedlist.printLinkedlist(n2);

        Node sum = sumOfTwoLinkedlist.getSumOfTwoLinkedList(n1,n2);
        sumOfTwoLinkedlist.printLinkedlist(sum);
    }
}
//Time complexity: O(n)