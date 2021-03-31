package com.datastructure.binarytree;

public class LowestCommonAncestorBinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node bstAncestor(Node node, int d1, int d2) {
        if (node == null) {
            return null;
        }

        if (node.data > d1 && node.data > d2) {
            return bstAncestor(node.left, d1, d2);
        } else if (node.data < d1 && node.data < d2) {
            return bstAncestor(node.right, d1, d2);
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorBinarySearchTree tree = new LowestCommonAncestorBinarySearchTree();
        tree.root = tree.new Node(20);
        tree.root.left = tree.new Node(8);
        tree.root.right = tree.new Node(22);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(12);
        tree.root.left.right.left = tree.new Node(10);
        tree.root.left.right.right = tree.new Node(14);

        Node node = tree.bstAncestor(tree.root, 10, 14);

        if (node == null) {
            System.out.println("no");
        } else {
            System.out.println(node.data);
        }
    }
}
