/*
Given postorder traversal of a binary search tree, construct the BST.

For example,
1. If the given traversal is {1, 7, 5, 50, 40, 10}, then following tree should be constructed
and root of the tree should be returned.

     10
   /   \
  5     40
 /  \      \
1    7      50

Input : 1 7 5 50 40 10
Output :

Inorder traversal of the constructed tree:
1 5 7 10 40 50

If the given traversal is {2, 6, 4, 9, 13, 11, 7}, then following tree should be constructed and root of the tree should be returned.

       7
     /   \
    4     11
   / \    /  \
  2   6  9    13

Input : 2 6 4 9 13 11 7
Output :

Inorder traversal of the constructed tree:
2 4 6 7 9 11 13

Left
Right
Root
Hence last node of post order will be root of tree, create it and push to stack.
If next element(i-1) is greater then it should be in right subtree.
If next element(i-1) is less then it should be in left subtree.
Algorithm:

Push root of the BST to the stack i.e, last element of the array.
Start traversing the array in reverse, if next element is > the element at the top of the stack then,
set this element as the right child of the element at the top of the stack and also push it to the stack.
Else if, next element is < the element at the top of the stack then,
start popping all the elements from the stack until either the stack is empty or the current
element becomes > the element at the top of the stack.
Make this element left child of the last popped node and repeat the above steps until the array is traversed completely.
*/
package com.datastructure.binarytree;

import java.util.Stack;

public class BSTFromGivenPostorderUsingStack {

    class Node{
        Node left;
        Node right;
        int data;

        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }

    Node constructBSTTree(int[] post,int size){
        Node root = new Node(post[size-1]);
        Stack<Node> stack = new Stack<>();
        Node node;
        Node temp;
        stack.push(root);

        for(int i=size-2;i>=0;i--){
            node = new Node(post[i]);
            temp = null;

            while(stack.size()>0 && post[i]<stack.peek().data){
                temp=stack.pop();
            }

            if(temp!=null){
                temp.left=node;
            }else{
                stack.peek().right=node;
            }
            stack.push(node);
        }
        return root;
    }

    void printPreOrderTraversal(Node node){
        if(node==null){
            return;
        }
        printPreOrderTraversal(node.left);
        System.out.print(node.data+" ");
        printPreOrderTraversal(node.right);
    }

    public static void main(String[] a){
        BSTFromGivenPostorderUsingStack bstFromGivenPostorderUsingStack = new BSTFromGivenPostorderUsingStack();
        //int post[] = new int[] { 1, 7, 5, 50, 40, 10 };
        int post[] = new int[] { 2, 6, 4, 9, 13, 11, 7};
        int size = post.length;

        Node root = bstFromGivenPostorderUsingStack.constructBSTTree(post,size);
        bstFromGivenPostorderUsingStack.printPreOrderTraversal(root);
    }
}
