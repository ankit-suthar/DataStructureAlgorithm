package com.algorithm;

import java.util.*;

class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class test {

    /*int size;
//    Map<Integer,Node[]> map;
    Node head;
    Map<Integer,Node> map;
    Node last;

    public test(int size) {
        this.size = size;
        map = new HashMap<>();
    }

    void delete(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = last.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = head.next;
        }
    }

    int get(int value) {
        if (map.containsKey(value)) {
            Node node = map.get(value);

            delete(node);
        }

        return -1;
    }*/
    /*int get(int value) {
        if(map.containsKey(value)) {
            Node[] arr = map.get(value);

            arr[0].next = arr[1];
            arr[1].prev = arr[0];

            Node newNode = new Node(value);
            map.put(head.data,new Node[]{newNode, head.next});
            newNode.next = head;
            head.prev = newNode;
            head = newNode;

            return value;
        } else {
            return -1;
        }
    }

    void add(int value) {
        if (map.containsKey(value)) {
            if (map.size() == size) {
                if(last.next == null) {
                    last = null;
                    head = null;
                } else {
                    Node[] arr = map.get(last.prev.data);
                    arr[1] = null;

                    map.remove(last.data);
                    Node tmp = last.prev;
                    tmp.next = null;
                    last = tmp;
                }
            } else {
                Node[] arr = map.get(value);

                arr[0].next = arr[1];
                arr[1].prev = arr[0];

                Node newNode = new Node(value);
                Node[] a = map.get(head.data);

                newNode.next = head;
                head.prev = newNode;
                a[0] = newNode;

                head = newNode;

                Node newNode = new Node(value);
                map.put(head.data,new Node[]{newNode, head.next});

                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                map.put(head.data,new Node[]{null, head.next});
            }
        }
    }*/

    static int maxLeftSubArraySum(int a[], int size, int sum[]) {
        int max_so_far = a[0];
        int curr_max = a[0];
        sum[0] = max_so_far;

        for (int i = 1; i < size; i++) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
            sum[i] = max_so_far;
        }

        return max_so_far;
    }

    static int maxRightSubArraySum(int a[], int n, int sum[]) {
        int max_so_far = a[n];
        int curr_max = a[n];
        sum[n] = max_so_far;

        for (int i = n - 1; i >= 0; i--) {
            curr_max = Math.max(a[i], curr_max + a[i]);
            max_so_far = Math.max(max_so_far, curr_max);
            sum[i] = max_so_far;
        }

        return max_so_far;
    }

    static int minLeftSubArraySum(int a[], int size, int sum[]) {
        int min_so_far = a[0];
        int curr_min = a[0];
        sum[0] = min_so_far;

        for (int i = 1; i < size; i++) {
            curr_min = Math.min(a[i], curr_min + a[i]);
            min_so_far = Math.min(min_so_far, curr_min);
            sum[i] = min_so_far;
        }

        return min_so_far;
    }

    static int minRightSubArraySum(int a[], int n, int sum[]) {
        int min_so_far = a[n];
        int curr_min = a[n];
        sum[n] = min_so_far;

        for (int i = n - 1; i >= 0; i--) {
            curr_min = Math.min(a[i], curr_min + a[i]);
            min_so_far = Math.min(min_so_far, curr_min);
            sum[i] = min_so_far;
        }

        return min_so_far;
    }

    public static void main (String[] args){
//        test t = new test(3);
        test t = new test();
//        int[] arr = {1,-3,2,3,-4};
        int[] nums = {2,-5,1,-4,3,-2};
        int n = nums.length;

        int leftMax[] = new int[n];
        maxLeftSubArraySum(nums, n, leftMax);
        int max1 = 0;
        for(int num : leftMax) {
            if(num > max1) {
                max1 = num;
            }
        }

        int rightMax[] = new int[n];
        maxRightSubArraySum(nums, n - 1, rightMax);
        int max2 = 0;
        for(int num : leftMax) {
            if(num > max2) {
                max2 = num;
            }
        }

        int val1 = max1>max2 ? max1 : max2;

        int leftMin[] = new int[n];
        minLeftSubArraySum(nums, n, leftMin);
        int min1 = Integer.MAX_VALUE;
        for(int num : leftMin) {
            if(num < min1) {
                min1 = num;
            }
        }

        int rightMin[] = new int[n];
        minRightSubArraySum(nums, n - 1, rightMin);
        int min2 = Integer.MAX_VALUE;
        for(int num : rightMin) {
            if(num < min2) {
                min2 = num;
            }
        }

        int val2 = min1<min2 ? min1 : min2;

        System.out.println(Math.max(Math.abs(val1),Math.abs(val2)));
    }
}
