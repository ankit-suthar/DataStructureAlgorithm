/*
Question: Given an arbitrary binary tree, convert it to a binary tree that holds Children Sum Property.
You can only increment data values in any node (You cannot change the structure of the tree and cannot decrement the value of any node).

For example, the below tree doesn’t hold the children sum property, convert it to a tree that holds the property.

             50
           /     \
         /         \
       7             2
     / \             /\
   /     \          /   \
  3        5      1      30
Algorithm:
Traverse the given tree in post order to convert it, i.e., first change left and right children to hold
the children sum property then change the parent node.

Let difference between node’s data and children sum be diff.

     diff = node’s children sum - node’s data
If diff is 0 then nothing needs to be done.

If diff > 0 ( node’s data is smaller than node’s children sum) increment the node’s data by diff.

If diff < 0 (node’s data is greater than the node's children sum) then increment one child’s data. We can choose
to increment either left or right child if they both are not NULL. Let us always first increment the left child.
Incrementing a child changes the subtree’s children sum property so we need to change left subtree also.
So we recursively increment the left child. If left child is empty then we recursively call increment() for right child.

Let us run the algorithm for the given example.

First convert the left subtree (increment 7 to 8).

             50
           /     \
         /         \
       8             2
     / \             /\
   /     \          /   \
  3        5      1      30
Then convert the right subtree (increment 2 to 31)

          50
        /    \
      /        \
    8            31
   / \           / \
 /     \       /     \
3       5    1       30
Now convert the root, we have to increment left subtree for converting the root.

          50
        /    \
      /        \
    19           31
   / \           /  \
 /     \       /      \
14      5     1       30
Please note the last step – we have incremented 8 to 19, and to fix the subtree we have incremented 3 to 14.
*/
package com.datastructure.binarytree;

public class ConvertBTreeToChildrenSumProperty {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    void convertTree(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        convertTree(node.left);
        convertTree(node.right);
        int left = 0, right = 0;

        if (node.left != null) {
            left = node.left.data;
        }

        if (node.right != null) {
            right = node.right.data;
        }

        int diff = left + right - node.data;

        if (diff > 0) {
            node.data += diff;
        } else if (diff < 0) {
            if (node.left != null) {
                diffCheck(node.left, (-1) * diff);
            } else {
                diffCheck(node.right, (-1) * diff);
            }
        }
    }

    void diffCheck(Node node, int diff) {
        node.data += diff;

        if (node.left != null) {
            diffCheck(node.left, diff);
        } else if (node.right != null) {
            diffCheck(node.right, diff);
        }
    }

    void printInorder(Node node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    public static void main(String[] args) {
        ConvertBTreeToChildrenSumProperty tree = new ConvertBTreeToChildrenSumProperty();
        tree.root = tree.new Node(50);
        tree.root.left = tree.new Node(7);
        tree.root.right = tree.new Node(2);
        tree.root.left.left = tree.new Node(3);
        tree.root.left.right = tree.new Node(5);
        tree.root.right.left = tree.new Node(1);
        tree.root.right.right = tree.new Node(30);

        System.out.println("Inorder traversal before conversion is :");
        tree.printInorder(tree.root);
        System.out.println(" ");

        tree.convertTree(tree.root);
        System.out.println(" ");

        System.out.println("Inorder traversal after conversion is :");
        tree.printInorder(tree.root);
    }
}
//Time Complexity: O(n^2)