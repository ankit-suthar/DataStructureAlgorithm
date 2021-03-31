package com.company.question.mygate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyGateTest2 {

    static long prison(int n,int m,List<Integer> h,List<Integer> v){

        Set<Integer> hSet = new HashSet<>();
        Set<Integer> vSet = new HashSet<>();
        int val;

        for(int i=0;i<h.size();i++){
            val = h.get(i);
            hSet.add(val);
            hSet.add(val+1);
        }

        for(int j=0;j<v.size();j++){
            val = h.get(j);
            vSet.add(val);
            vSet.add(val+1);
        }


        Long l1 = new Long(hSet.size());
        Long l2 = new Long(vSet.size());
        return l1*l2;
    }

    public static void main(String[] a){
       /* int n = 3;
        int m = 2;
        int hSize = 3;
        int vSize = 2;
        List<Integer> h = new ArrayList<>(List.of(1,2,3));
        List<Integer> v = new ArrayList<>(List.of(1,2));*/
        //4
        /*int n = 2;
        int m = 2;
        int hSize = 1;
        int vSize = 1;
        List<Integer> h = new ArrayList<>(List.of(1));
        List<Integer> v = new ArrayList<>(List.of(2));*/
        //4
        int n = 3;
        int m = 3;
        int hSize = 1;
        int vSize = 1;
        List<Integer> h = new ArrayList<>(List.of(2));
        List<Integer> v = new ArrayList<>(List.of(2));
        //4
        long ans = prison(n,m,h,v);
        System.out.println(ans);
    }
}
