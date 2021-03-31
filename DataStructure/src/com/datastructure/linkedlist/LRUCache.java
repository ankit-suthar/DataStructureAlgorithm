package com.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;

public class LRUCache {

    ArrayList<Integer> al;
    HashSet<Integer> hs;
    int size;

    public LRUCache(int m){
        al = new ArrayList<>();
        hs = new HashSet<>();
        size = m;
    }

    void add(int data){
        int index=-1;
        if(hs.contains(data)){
            index = al.indexOf(data);
            al.remove(index);
        }else{
            if(al.size()==size){
                hs.remove(al.get(size-1));
                al.remove(size-1);
            }
        }
        al.add(0,data);
        hs.add(data);
    }

    public static void main(String[] a){
        LRUCache lc = new LRUCache(3);
        lc.add(3);
        lc.add(1);
        lc.add(2);
        lc.add(3);
        lc.add(4);
        System.out.println(lc.al);
        System.out.println(lc.hs);
    }
}
