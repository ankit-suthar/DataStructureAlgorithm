package com.datastructure.binarytree;

public class MirrorToItself {
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

    boolean isMirror(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public static void main(String[] args) {
        MirrorToItself tree = new MirrorToItself();

        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(2);
        tree.root.left.left = tree.new Node(3);
        tree.root.left.right = tree.new Node(4);
        tree.root.right.left = tree.new Node(4);
        tree.root.right.right = tree.new Node(3);
//        tree.root.right.right.left = tree.new Node(3);

        boolean res = tree.isMirror(tree.root.left, tree.root.right);

        if (res == true) {
            System.out.println("It is Symmetric Tree (Mirror Image of itself)");
        } else {
            System.out.println("It is not Symmetric Tree (Mirror Image of itself)");
        }
    }
}
//Time complexity: O(n)