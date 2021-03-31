package com.datastructure.linkedlist;

public class SumOfTwoLinkedlistMthd2 {

    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            next=null;
        }
    }

    Node head1;
    Node head2;
    Node result;
    int sum;
    int carry;
    void push(int data,int level){

        Node node = new Node(data);

        if(level==1){
            node.next = head1;
            head1 = node;
        }else if(level==2){
            node.next = head2;
            head2 = node;
        }else{
            node.next = result;
            result = node;
        }
    }

    void addOperationForSameSize(Node n1, Node n2){

        if(n1==null && n2==null){
            return;
        }

        addOperationForSameSize(n1.next,n2.next);

        sum = n1.data + n2.data + carry;
        push(sum%10,3);
        carry = sum/10;
    }

    void addOperation(Node n1,Node n2,int diff){
        while(diff>0){
            n1 = n1.next;
            diff--;
        }
        addOperationForSameSize(n1,n2);
    }

    void addAdditionalNodeValues(Node node1,int count){

        if(count>1){
            addAdditionalNodeValues(node1.next,count-1);
        }
        sum = node1.data + carry;
        carry = sum/10;
        push(sum%10,3);
    }


    public static void main(String[] a){
        SumOfTwoLinkedlistMthd2 sum = new SumOfTwoLinkedlistMthd2();

       /* int arr1[] = { 9, 9, 9 };
        int arr2[] = { 1, 8 };*/
        //1017

        int arr1[] = {2,8,5,6,3};
        int arr2[] = {8,4,2};
        //1405

        for(int i=arr1.length-1;i>=0;i--){
            sum.push(arr1[i],1);
        }

        for(int i=arr2.length-1;i>=0;i--){
            sum.push(arr2[i],2);
        }

        int m = arr1.length;
        int n = arr2.length;

        if(m==n){
            sum.addOperationForSameSize(sum.head1,sum.head2);
        }else{
            if(m<n){
                Node temp = sum.head1;
                sum.head1 = sum.head2;
                sum.head2 = temp;
            }
            sum.addOperation(sum.head1,sum.head2,Math.abs(m-n));
            sum.addAdditionalNodeValues(sum.head1,Math.abs(m-n));
        }

        if(sum.carry!=0){
            sum.push(sum.carry,3);
        }

        Node n1 = sum.head1;

        while(n1!=null){
            System.out.print(n1.data+" ");
            n1 = n1.next;
        }
        System.out.println();

        Node n2 = sum.head2;

        while(n2!=null){
            System.out.print(n2.data+" ");
            n2 = n2.next;
        }
        System.out.println();

        Node r = sum.result;

        while(r!=null){
            System.out.print(r.data+" ");
            r = r.next;
        }

    }
}
//Time Complexity: O(m+n) where m and n are the sizes of given two linked lists