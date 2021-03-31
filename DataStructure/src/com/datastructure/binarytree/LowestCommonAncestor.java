package com.datastructure.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LowestCommonAncestor {
    Node root;

    class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    boolean findLowestCommonAncestorUtil(Node n,int data,List<Integer> list){
        if(n==null){
            return false;
        }

        if(n.data==data){
            return true;
        }

        if(findLowestCommonAncestorUtil(n.left,data,list)){
            list.add(n.data);
            return true;
        }
        if (findLowestCommonAncestorUtil(n.right,data,list)){
            list.add(n.data);
            return true;
        }
        return false;
    }

    void findLowestCommonAncestor(Node n,int d1,int d2){
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        findLowestCommonAncestorUtil(n,d1,l1);
        findLowestCommonAncestorUtil(n,d2,l2);

        Integer ancestor = getAncestorValue(l1,l2);
        System.out.println("Common Ancestor: "+ancestor);
    }

    Integer getAncestorValue(List<Integer> l1,List<Integer> l2){
        return l1.stream().filter(e -> l2.contains(e)).findFirst().orElse(null);
        /*for(int i=0;i<l1.size();i++){
            if(l2.contains(l1.get(i))){
                return l1.get(i);
            }
        }
        return null;*/
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        lca.root = lca.new Node(1);
        lca.root.left = lca.new Node(2);
        lca.root.right = lca.new Node(3);
        lca.root.left.left = lca.new Node(4);
        lca.root.left.right = lca.new Node(5);
        lca.root.right.left = lca.new Node(6);
        lca.root.right.right = lca.new Node(7);
        lca.findLowestCommonAncestor(lca.root,4,5);
    }
}
