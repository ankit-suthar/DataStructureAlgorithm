/*
In this article, first count of possible BST (Binary Search Trees)s is discussed, then construction of all possible BSTs.

How many structurally unique BSTs for keys from 1..N?

For example, for N = 2, there are 2 unique BSTs
     1               2
      \            /
       2         1

For N = 3, there are 5 possible BSTs
  1              3        3         2      1
    \           /        /        /  \      \
     3        2         1        1    3      2
    /       /            \                    \
   2      1               2                    3
We strongly recommend you to minimize your browser and try this yourself first.

We know that all node in left subtree are smaller than root and in right subtree are larger
than root so if we have ith number as root, all numbers from 1 to i-1 will be in left subtree
and i+1 to N will be in right subtree. If 1 to i-1 can form x different trees and i+1 to N can
from y different trees then we will have x*y total trees when ith number is root and we also have N
choices for root also so we can simply iterate from 1 to N for root and another loop for left and right subtree.
If we take a closer look, we can notice that the count is basically n’th Catalan number.
We have discussed different approaches to find n’th Catalan number here.

How to construct all BST for keys 1..N?
The idea is to maintain a list of roots of all BSTs. Recursively construct all possible
left and right subtrees. Create a tree for every pair of left and right subtree and add
the tree to list. Below is detailed algorithm.

1) Initialize list of BSTs as empty.
2) For every number i where i varies from 1 to N, do following
......a)  Create a new node with key as 'i', let this node be 'node'
......b)  Recursively construct list of all left subtrees.
......c)  Recursively construct list of all right subtrees.
3) Iterate for all left subtrees
   a) For current leftsubtree, iterate for all right subtrees
        Add current left and right subtrees to 'node' and add
        'node' to list.
 */
package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;

public class ConstructPossibleBST1toN {

    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    List<Node> constructBinaryTree(int start, int end) {
        List<Node> al = new ArrayList<>();

        if (start > end) {
            al.add(null);
            return al;
        }

        for (int i = start; i <= end; i++) {
            Node node = new Node(i);

            List<Node> leftList = constructBinaryTree(start, i - 1);
            List<Node> rightList = constructBinaryTree(i + 1, end);

            for (int j = 0; j < leftList.size(); j++) {
                node.left = leftList.get(j);

                for (int k = 0; k < rightList.size(); k++) {
                    node.right = rightList.get(k);
                    al.add(node);
                }
            }
        }
        return al;
    }

    void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        ConstructPossibleBST1toN tree = new ConstructPossibleBST1toN();
        List<Node> listOfNodes = tree.constructBinaryTree(1, 3);
        listOfNodes.stream().forEach((node) -> {
            tree.preOrderTraversal(node);
            System.out.println();
        });
    }
}
