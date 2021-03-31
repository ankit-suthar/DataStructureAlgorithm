package com.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree2 {
    Node root;

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    int findMaxWidth(Node node) {
        if (node == null) {
            return 0;
        }

        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();

        queue1.add(node);
        int max = queue1.size();

        while (!queue1.isEmpty()) {

            if (queue1.size() > max) {
                max = queue1.size();
            }

            while (!queue1.isEmpty()) {
                Node node1 = queue1.poll();

                if (node1.left != null) {
                    queue2.add(node1.left);
                }

                if (node1.right != null) {
                    queue2.add(node1.right);
                }
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree2 tree = new MaximumWidthOfBinaryTree2();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.right = tree.new Node(8);
        tree.root.right.right.left = tree.new Node(6);
        tree.root.right.right.right = tree.new Node(7);

        int maxWidth = tree.findMaxWidth(tree.root);
        System.out.println(maxWidth);
    }
}
