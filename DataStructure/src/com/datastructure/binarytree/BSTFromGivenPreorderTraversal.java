/*
Given preorder traversal of a binary search tree, construct the BST.

For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the output should be root of following tree.

     10
   /   \
  5     40
 /  \      \
1    7      50
We have discussed O(n^2) and O(n) recursive solutions in the previous post.
Following is a stack based iterative solution that works in O(n) time.

1. Create an empty stack.

2. Make the first value as root. Push it to the stack.

3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value.
   Make this value as the right child of the last popped node. Push the new node to the stack.

4. If the next value is less than the stack’s top value, make this value as the left child of
   the stack’s top node. Push the new node to the stack.

5. Repeat steps 2 and 3 until there are items remaining in pre[].
*/
package com.datastructure.binarytree;

import java.util.Stack;

public class BSTFromGivenPreorderTraversal {
    Node root;

    class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    void bstFromPreOrder(int[] pre,int size){
        Stack<Node> stack = new Stack<>();
        root = new Node(pre[0]);
        stack.push(root);

        for(int i=1;i<size;i++){

            if(pre[i] < stack.peek().data){
                Node node = new Node(pre[i]);
                stack.peek().left = node;
                stack.push(node);
            }else{
                Node node=null;
                while(!stack.empty() && stack.peek().data<pre[i]){
                    node = stack.pop();
                }
                Node node1 = new Node(pre[i]);
                node.right = node1;
                stack.push(node1);
            }
        }
    }

    void inOrderTraversal(Node node){
        if(node == null){
            return;
        }

        inOrderTraversal(node.left);
        System.out.print(node.data+" ");
        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        BSTFromGivenPreorderTraversal bst = new BSTFromGivenPreorderTraversal();
        int pre[] = new int[]{10, 5, 1, 7, 40, 50};
        int size = pre.length;
        bst.bstFromPreOrder(pre,size);
        bst.inOrderTraversal(bst.root);
    }
}
//Time Complexity: O(n)