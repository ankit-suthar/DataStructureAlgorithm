/*
 * Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
*/
package com.datastructure.binarytree;

public class ConnectNodesAtSameLevel {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }

    void nextRightOfTheNode(Node node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            node.left.nextRight = node.right;
        }

        if (node.right != null) {
            node.right.nextRight = (node.nextRight != null) ? node.nextRight.left : null;
        }

        nextRightOfTheNode(node.left);
        nextRightOfTheNode(node.right);
    }

    void printNextNodes(Node node) {
        if (node == null) {
            return;
        }

        if (node.nextRight != null) {
            System.out.print(node.data + " - " + node.nextRight.data + "\n");
        }

        printNextNodes(node.left);
        printNextNodes(node.right);
    }

    public static void main(String[] args) {
        ConnectNodesAtSameLevel tree = new ConnectNodesAtSameLevel();

        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);

        tree.nextRightOfTheNode(tree.root);

        tree.root.nextRight = tree.new Node(-1);

        tree.printNextNodes(tree.root);
    }
}
