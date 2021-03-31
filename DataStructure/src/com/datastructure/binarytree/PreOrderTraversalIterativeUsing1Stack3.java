/*
1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Pop elements from second stack and place in first stack
4. Print first stack
*/
package com.datastructure.binarytree;

import java.util.Stack;

public class PreOrderTraversalIterativeUsing1Stack3 {
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

        Node curr = node;
        Stack<Node> stack = new Stack<>();
        stack.push(curr);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.print(curr.data + " ");

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }

        }

    }

    public static void main(String[] args) {
        PreOrderTraversalIterativeUsing1Stack3 tree = new PreOrderTraversalIterativeUsing1Stack3();

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