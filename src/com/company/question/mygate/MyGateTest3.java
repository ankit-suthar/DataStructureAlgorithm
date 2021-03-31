package com.company.question.mygate;

import java.util.List;

public class MyGateTest3 {

    public static int segment(int x, List<Integer> arr) {
        int min;
        int max = 0;

        if(arr.size()==1){
            return arr.get(0);
        }

        for(int i=0;i<arr.size() && i+x<arr.size();i++){
            min = Integer.MAX_VALUE;
            for(int j=0;j<x;j++){
                if(min>arr.get(i+j)){
                    min = arr.get(i+j);
                }
            }
            if(max<min){
                max=min;
            }
        }
        return max;
    }

    public static void main(String[] a){
        int x=1;
        List<Integer> arr = List.of(1,2,3,1,2);
        int ans = segment(x,arr);
        System.out.println(ans);
    }
}
