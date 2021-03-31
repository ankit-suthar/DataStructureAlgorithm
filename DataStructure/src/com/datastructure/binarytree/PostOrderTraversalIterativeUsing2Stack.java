/*
1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack
*/
package com.datastructure.binarytree;

import java.util.Stack;

public class PostOrderTraversalIterativeUsing2Stack {
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
        if (node == null) {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty()) {
            Node node1 = stack1.pop();
            stack2.push(node1);

            if (node1.left != null) {
                stack1.push(node1.left);
            }

            if (node1.right != null) {
                stack1.push(node1.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void main(String[] args) {
        PostOrderTraversalIterativeUsing2Stack tree = new PostOrderTraversalIterativeUsing2Stack();

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
//Space Complexity: n