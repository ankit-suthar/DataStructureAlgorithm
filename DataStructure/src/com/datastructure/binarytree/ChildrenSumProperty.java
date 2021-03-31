/*
Given a binary tree, write a function that returns true if the tree satisfies below property.
For every node, data value must be equal to sum of data values in left and right children.
Consider data value as 0 for NULL children. Below tree is an example
                        10
                      /   \
                    /      \
                  8         2
                /  \         \
              /     \         \
             3       5         2
 */

package com.datastructure.binarytree;

public class ChildrenSumProperty {

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

    boolean isSumProperty(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }

        int left = 0, right = 0;

        if (node.left != null) {
            left = node.left.data;
        }

        if (node.right != null) {
            right = node.right.data;
        }

        return (node.data == left + right) && isSumProperty(node.left) && isSumProperty(node.right);
    }

    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();

        tree.root = tree.new Node(10);
        tree.root.left = tree.new Node(8);
        tree.root.right = tree.new Node(2);
        tree.root.left.left = tree.new Node(3);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.right = tree.new Node(2);

        if (tree.isSumProperty(tree.root)) {
            System.out.println("The given tree satisfies children sum property");
        } else {
            System.out.println("The given tree does not satisfy children sum property");
        }
    }
}
//Time complexity: O(n)