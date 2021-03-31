package com.datastructure.binarytree;

/**
 * This program tells weather given sum is exists from root to leaf.
 */
public class RootToLeafSumEqualToGivenNumber {
    Node root;

    class Node{
        Node left,right;
        int data;

        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }

    boolean isRootToLeafSumEqualToGivenNumber(Node n,int sum){
            if(n==null){
                return false;
            }

            int residue = sum - n.data;

            if(n.left==null && n.right==null && residue==0){
                return true;
            }
            return (isRootToLeafSumEqualToGivenNumber(n.left,residue) || isRootToLeafSumEqualToGivenNumber(n.right,residue));
    }

    public static void main(String[] a){
        RootToLeafSumEqualToGivenNumber tree = new RootToLeafSumEqualToGivenNumber();
        tree.root=tree.new Node(10);
        tree.root.left=tree.new Node(8);
        tree.root.right=tree.new Node(2);
        tree.root.left.left=tree.new Node(3);
        tree.root.left.right=tree.new Node(4);
        tree.root.right.left=tree.new Node(2);
        int sum = 12;
        boolean valid;
        if(tree.root==null){
            valid = (sum==0);
        }else{
            valid = tree.isRootToLeafSumEqualToGivenNumber(tree.root,sum);
        }

        if(valid){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
