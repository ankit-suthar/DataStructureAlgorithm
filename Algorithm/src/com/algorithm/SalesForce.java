package com.algorithm;

import java.util.HashSet;
import java.util.Set;

public class SalesForce {

    public boolean isAvailable(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        set.add("sales");
        set.add("force");
        set.add("sale");
        set.add("the");

        return helper(str, set);
    }

    boolean helper(String str, Set<String> set) {
        if(str.equals("")) {
            return true;
        }

        for (int i = 0;i < str.length();i++) {
            if (set.contains(str.substring(0,i+1)) && helper(str.substring(i+1),set)) {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args){
        SalesForce t = new SalesForce();

        System.out.println(t.isAvailable("thesalesforce"));
    }
}
//Time Complexity: O(N), Where N = size of an input string
//Space Complexity: O(1)