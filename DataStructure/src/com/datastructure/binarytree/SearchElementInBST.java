/*
Binary Search Tree, is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.
There must be no duplicate nodes.

The above properties of Binary Search Tree provide an ordering among keys so that
the operations like search, minimum and maximum can be done fast. If there is no
ordering, then we may have to compare every key to search a given key.

Searching a key
To search a given key in Binary Search Tree, we first compare it with root, if the key
is present at root, we return root. If key is greater than root’s key, we recur for
right subtree of root node. Otherwise we recur for left subtree.

Illustration to search 6 in below tree:
1. Start from root.
2. Compare the inserting element with root, if less than root, then recurse for left, else recurse for right.
3. If element to search is found anywhere, return true, else return false.

Insertion of a key
A new key is always inserted at leaf. We start searching a key from root till we hit a leaf node.
Once a leaf node is found, the new node is added as a child of the leaf node.

         100                               100
        /   \        Insert 40            /    \
      20     500    --------->          20     500
     /  \                              /  \
    10   30                           10   30
                                              \
                                              40
*/
package com.datastructure.binarytree;

public class SearchElementInBST {
    Node root;

    class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    void insert(int data){
        root = insertUtil(root,data);
    }

    Node insertUtil(Node root,int data){
        if(root==null){
            root = new Node(data);
            return root;
        }

        if(root.data<data){
            root.right = insertUtil(root.right,data);
        }else{
            root.left= insertUtil(root.left,data);
        }
        return root;
    }

    Node searchNode(Node node,int data) {
        if(node==null || node.data==data) {
            return node;
        }

        if(node.data>data){
            return searchNode(node.left, data);
        }
        return searchNode(node.right,data);
    }

    public static void main(String[] a) {
        SearchElementInBST searchElementInBST = new SearchElementInBST();
        searchElementInBST.insert(50);
        searchElementInBST.insert(30);
        searchElementInBST.insert(20);
        searchElementInBST.insert(40);
        searchElementInBST.insert(70);
        searchElementInBST.insert(60);
        searchElementInBST.insert(80);

        Node node = searchElementInBST.searchNode(searchElementInBST.root, 30);
        if (node == null){
            System.out.println("Not available");
        }
        else{
            System.out.println("Node " + node.data + " is Available");
        }
    }
}
