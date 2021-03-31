package com.algorithm.greedy;

import java.lang.reflect.Array;
import java.util.*;

public class Test{

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);

        System.out.println(wrapList);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode head = test.new ListNode(3);
        head.next = test.new ListNode(3);
//        head.next.next = test.new ListNode(5);
        /*head.next.next.next = test.new ListNode(4);
        head.next.next.next.next = test.new ListNode(5);
        head.next.next.next.next.next = test.new ListNode(6);
        head.next.next.next.next.next.next = test.new ListNode(7);
        head.next.next.next.next.next.next.next = test.new ListNode(8);*/

        String[] str1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] str2 = {"KFC","Shogun","Burger King"};
        StringBuilder sb = new StringBuilder();
        int nums[] = {1,2,1,2,1,1,1,3};
        int m = 2;
        int k = 2;


        TreeNode root = test.new TreeNode(3);
        root.left = test.new TreeNode(9);
        root.right = test.new TreeNode(20);
        root.right.left = test.new TreeNode(15);
        root.right.right = test.new TreeNode(7);

        test.levelOrderBottom(root);
    }
}


