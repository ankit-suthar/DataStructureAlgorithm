/*
1. If curr is not null then add to stack
2. If curr is null then check stack peek's right, if it is null then print stack peek until temp is not right of stack peek
3. If stack peek's right is not null then curr is that one
*/
package com.datastructure.binarytree;

import java.util.Stack;

public class PostOrderTraversalIterativeUsing1Stack {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    void postOrderIterative(Node node) {

        Stack<Node> stack = new Stack<>();
        Node curr = node;

        while(curr!=null || !stack.isEmpty()){
            if(curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }else {
                Node tempNode = stack.peek().right;
                if(tempNode==null){
                    tempNode = stack.pop();
                    System.out.print(tempNode.data+" ");

                    while(!stack.isEmpty() && stack.peek().right==tempNode){
                        tempNode = stack.pop();
                        System.out.print(tempNode.data+" ");
                    }
                }else{
                    curr = stack.peek().right;
                }
            }

        }

    }

    public static void main(String[] args) {
        PostOrderTraversalIterativeUsing1Stack tree = new PostOrderTraversalIterativeUsing1Stack();

        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);

        tree.postOrderIterative(tree.root);
    }
}
//Time complexity: O(n)
//Space Complexity: O(h) , h = height of tree