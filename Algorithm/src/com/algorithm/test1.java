package com.algorithm;

import java.util.*;

public class test1 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();

        for (List<String> keyValue : knowledge) {
            map.put(keyValue.get(0), keyValue.get(1));
        }

        boolean flag = false;
        int m = -1;
        int n = -1;
        int len = s.length();

        for (int i = 0;i < len;i++) {
            if (s.charAt(i) == '(') {
                flag = true;
                m = i;
            }

            if (s.charAt(i) == ')') {
                flag = true;
                n = i;

                if(map.containsKey(s.substring(m+1,n))) {
                    String replaceString = s.replace(s.substring(m,n+1),map.get(s.substring(m+1,n)));
                    s = new String(replaceString);
                }else {
                    String replaceString = s.replace(s.substring(m,n+1),"?");
                    s = new String(replaceString);
                }
            }
        }

        return s;

    }

    public static void main(String[] args) {
        test1 t = new test1();
        List<String> list1 = Arrays.asList("name","bob");
        List<String> list2 = Arrays.asList("age","two");
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(list1);
        knowledge.add(list2);
        System.out.println(t.evaluate("(name)is(age)yearsold",knowledge));
    }
}
