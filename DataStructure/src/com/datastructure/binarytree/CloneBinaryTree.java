package com.datastructure.binarytree;

import java.util.HashMap;
import java.util.Map;

public class CloneBinaryTree {

    class Node{
        int data;
        Node right,left,random;
        Node(int data){
            this.data=data;
            right=null;
            left=null;
            random=null;
        }
    }

    Node cloneTree(Node node,Map<Node,Node> map){
        if(node==null){
            return null;
        }

        map.put(node,new Node(node.data));
        map.get(node).left = cloneTree(node.left,map);
        map.get(node).right = cloneTree(node.right,map);
        return map.get(node);
    }

    void updateRandomPointers(Node node,Map<Node,Node> map){
        if(node==null){
            return;
        }
        map.get(node).random = map.get(node.random);
        updateRandomPointers(node.left,map);
        updateRandomPointers(node.right,map);
    }

    void preOrderTraversal(Node node){
        if(node==null) {
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
        if(node.random!=null){
            System.out.print(" Random: "+node.random.data);
        }
        System.out.println();
    }

    public static void main(String[] a){
        CloneBinaryTree clone = new CloneBinaryTree();
        Node root = clone.new Node(1);
        root.left = clone.new Node(2);
        root.right = clone.new Node(3);
        root.left.left = clone.new Node(4);
        root.left.right = clone.new Node(5);
        root.right.left = clone.new Node(6);
        root.right.right = clone.new Node(7);

        root.random = root.right.left.random;
        root.left.left.random = root.right;
        root.left.right.random = root;
        root.right.left.random = root.left.left;
        root.random = root.left;

        clone.preOrderTraversal(root);
        Map<Node,Node> map = new HashMap<>();
        Node newRoot = clone.cloneTree(root,map);
        clone.updateRandomPointers(root,map);
        System.out.println("------------------------------------------------------------");
        clone.preOrderTraversal(newRoot);
    }

}
