package com.datastructure.String;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
//    Node node;

    class Node{
        int data;
        Node left,right;

        public Node(int data){
            this.data=data;
            left=right=null;
        }
    }

    class MaxVal{
        int maxVal=Integer.MIN_VALUE;
    }

    int maxPathSumUtil(Node node,MaxVal maxVal){
        if(node==null){
            return 0;
        }

        int l = maxPathSumUtil(node.left,maxVal);
        int r = maxPathSumUtil(node.right,maxVal);

        List<Integer> list = Arrays.asList(node.data, l+r+node.data, l+node.data, r+node.data);
        maxVal.maxVal = Math.max(maxVal.maxVal, Collections.max(list));
        //return node.data + Math.max(l,r);
        return Collections.max(Arrays.asList(node.data, l+node.data, r+node.data));
    }

    public int maxPathSum(Node node) {
        if(node==null){
            return 0;
        }

        MaxVal maxVal = new MaxVal();
        maxPathSumUtil(node,maxVal);
        return maxVal.maxVal;
    }
//[5,4,8,11,null,13,4,7,2,null,null,null,1]
    public static void main(String[] a){
        Test t = new Test();
        Node node = t.new Node(-10);
        node.left = t.new Node(9);
        node.right = t.new Node(20);
        node.right.left = t.new Node(15);
        node.right.right = t.new Node(7);
        /***/
//        Node node = t.new Node(2);
//        node.left = t.new Node(-1);
        /***/
//        Node node = t.new Node(9);
//        node.left = t.new Node(6);
//        node.right = t.new Node(-3);
//        node.right.left = t.new Node(-6);
//        node.right.right = t.new Node(2);
//        node.right.right.left = t.new Node(2);
//        node.right.right.left.left = t.new Node(-6);
//        node.right.right.left.right = t.new Node(-6);
//        node.right.right.left.left.left = t.new Node(-6);

        System.out.println(t.maxPathSum(node));
    }
}
