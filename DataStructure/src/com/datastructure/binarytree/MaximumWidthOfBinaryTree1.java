package com.datastructure.binarytree;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumWidthOfBinaryTree1 {
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

        int h = height(node);
        int[] count = new int[h];

        countNodesAtLevel(node, count, 0);

        return getMaxWidth(count);
    }

    int getMaxWidth(int[] count) {
        AtomicInteger max = new AtomicInteger(count[0]);
        final int[] m = {count[0]};
        Arrays.stream(count).forEach(e -> {
            if(m[0] <e){
                m[0] =e;
            }
            if (max.get() < e) {
                max.set(e);
            }
        });
        System.out.println(m[0]);
        return max.get();
    }

    void countNodesAtLevel(Node node, int[] count, int level) {
        if (node == null) {
            return;
        }

        count[level]++;
        countNodesAtLevel(node.left, count, level + 1);
        countNodesAtLevel(node.right, count, level + 1);
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree1 tree = new MaximumWidthOfBinaryTree1();
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
