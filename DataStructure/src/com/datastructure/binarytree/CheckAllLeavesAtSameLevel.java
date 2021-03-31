/*
Given a Binary Tree, check if all leaves are at same level or not.

          12
        /    \
      5       7
    /          \
   3            1
  Leaves are at same level

          12
        /    \
      5       7
    /
   3
  Leaves are Not at same level

          12
        /
      5
    /   \
   3     9
  /      /
 1      2
 Leaves are at same level

The idea is to first find level of the leftmost leaf and store it
in a variable leafLevel. Then compare level of all other leaves with
leafLevel, if same, return true, else return false. We traverse the given
Binary Tree in Preorder fashion. An argument leaflevel is passed to all
calls. The value of leafLevel is initialized as 0 to indicate that the
first leaf is not yet seen yet. The value is updated when we find first
leaf. Level of subsequent leaves (in preorder) is compared with leafLevel.
*/
package com.datastructure.binarytree;

public class CheckAllLeavesAtSameLevel {
    Node root;

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    class LeafLevel{
        int level;
    }

    boolean checkAllLeavesAtSameLevel(Node node,LeafLevel leafLevel,int level){
        if(node == null){
            return true;
        }

        if(node.left == null && node.right == null){
            if(leafLevel.level==0){
                leafLevel.level = level;
                return true;
            }

            if(leafLevel.level == level){
                return true;
            }else{
                return false;
            }
        }

        return checkAllLeavesAtSameLevel(node.left,leafLevel,level+1) && checkAllLeavesAtSameLevel(node.right,leafLevel,level+1);
    }

    public static void main(String[] args) {
        CheckAllLeavesAtSameLevel tree=new CheckAllLeavesAtSameLevel();

        tree.root = tree.new Node(12);
        tree.root.left = tree.new Node(5);
        tree.root.left.left = tree.new Node(3);
        tree.root.left.right = tree.new Node(9);
        tree.root.left.left.left = tree.new Node(1);
        tree.root.left.right.left = tree.new Node(1);

        LeafLevel leafLevel = tree.new LeafLevel();

        if (tree.checkAllLeavesAtSameLevel(tree.root,leafLevel,0)) {
            System.out.println("All leaves are at same level");
        }
        else {
            System.out.println("All leaves are not at same level");
        }
    }
}
//Time complexity: O(n)