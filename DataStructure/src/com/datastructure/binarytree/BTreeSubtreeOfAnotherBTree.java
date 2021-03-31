// TREE 1
/*
          26
         /   \
        10     3
       /    \     \
      4      6      3
       \
        30
*/

// TREE 2
/*
       10
     /    \
     4      6
      \
      30
*/
package com.datastructure.binarytree;

public class BTreeSubtreeOfAnotherBTree {
    Node root1,root2;

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data=data;
            left=right=null;
        }
    }

    boolean isIdentical(Node node1,Node node2){
        if(node1==null && node2==null){
            return true;
        }

        if(node1==null || node2==null){
            return false;
        }

        return (node1.data==node2.data) && isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right);
    }

    boolean checkSubtree(Node node1,Node node2){
        if(node2==null){
            return true;
        }

        if(node1==null){
            return false;
        }

        if(isIdentical(node1,node2)){
            return true;
        }

        return checkSubtree(node1.left,node2) || checkSubtree(node1.right,node2);
    }

    public static void main(String[] args) {
        BTreeSubtreeOfAnotherBTree tree = new BTreeSubtreeOfAnotherBTree();

        tree.root1 = tree.new Node(26);
        tree.root1.right = tree.new Node(3);
        tree.root1.right.right = tree.new Node(3);
        tree.root1.left = tree.new Node(10);
        tree.root1.left.left = tree.new Node(4);
        tree.root1.left.left.right = tree.new Node(30);
        tree.root1.left.right = tree.new Node(6);

        tree.root2 = tree.new Node(10);
        tree.root2.right = tree.new Node(6);
        tree.root2.left = tree.new Node(4);
        tree.root2.left.right = tree.new Node(30);

        if (tree.checkSubtree(tree.root1, tree.root2)) {
            System.out.println("Tree 2 is subtree of Tree 1 ");
        }
        else {
            System.out.println("Tree 2 is not a subtree of Tree 1");
        }
    }
}
//Time Complexity: Worst Case complexity :  O(mn) where m and n are number of nodes in given two trees