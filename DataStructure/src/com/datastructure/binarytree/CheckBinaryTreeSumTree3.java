/*
 *
 * Write a function that returns true if the given Binary Tree is SumTree else false.
 * A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present
 * in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree
 * can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
 *
 *
 *
 * Write a function that returns true if the given Binary Tree is
 * SumTree else false. A SumTree is a Binary Tree where the value
 * of a node is equal to sum of the nodes present in its left subtree
 * and right subtree. An empty tree is SumTree and sum of an empty
 * tree can be considered as 0. A leaf node is also considered as SumTree.
 *
 *
 * Method 1 ( Simple )
Get the sum of nodes in left subtree and right subtree. Check if the sum
calculated is equal to root’s data. Also, recursively check if the left
and right subtrees are SumTrees.
 *
 *
Write a function that returns true if the given Binary Tree is SumTree else false.
A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Following is an example of SumTree.

          26
        /   \
      10     3
    /    \     \
  4      6      3
 *
 *
 *
 * Write a function that returns true if the given Binary Tree is
 * SumTree else false. A SumTree is a Binary Tree where the value
 * of a node is equal to sum of the nodes present in its left subtree
 * and right subtree. An empty tree is SumTree and sum of an empty
 * tree can be considered as 0. A leaf node is also considered as SumTree.
 *
 *
 * Method 2 ( Tricky )
The Method 1 uses sum() to get the sum of nodes in left and right subtrees.
The method 2 uses following rules to get the sum directly.
1) If the node is a leaf node then sum of subtree rooted with this node
is equal to value of this node.
2) If the node is not a leaf node then sum of subtree rooted with this
node is twice the value of this node (Assuming that the tree rooted with
this node is SumTree).
 *
 *
 */
package com.datastructure.binarytree;

public class CheckBinaryTreeSumTree3 {

    Node root;

    class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            data=d;
            left=right=null;
        }
    }

    boolean isLeaf(Node node){
        if(node.left==null && node.right==null){
            return true;
        }
        return false;
    }

    int isSumTree(Node node){
        if(node==null || (node.left==null && node.right==null)){
            return 1;
        }

        if(isSumTree(node.left)!=0 && isSumTree(node.right)!=0){
            int left = 0,right = 0;

            if(node.left == null){
                left = 0;
            }else if(isLeaf(node.left)){
                left = node.left.data;
            }else{
                left = 2*node.left.data;
            }

            if(node.right == null){
                right = 0;
            }else if(isLeaf(node.right)){
                right = node.right.data;
            }else{
                right = 2*node.right.data;
            }

            if(node.data == left+right){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        CheckBinaryTreeSumTree3 tree=new CheckBinaryTreeSumTree3();

        tree.root = tree.new Node(26);
        tree.root.left = tree.new Node(10);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(6);
        tree.root.right.right = tree.new Node(3);

        if (tree.isSumTree(tree.root) != 0) {
            System.out.println("The given tree is a sum tree");
        }
        else {
            System.out.println("The given tree is not a sum tree");
        }
    }
}
//Time Complexity: O(n)