package com.company.question.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayBurstProblem {

    static List<String> getShrunkArray(List<String> inputArray,int burstLength){

        return null;
    }

    public static void main(String[] a){
        List<String> list1 = Arrays.asList(new String[]{"a", "b", "c", "c", "c", "d", "e", "e"});
        List<String> list = new ArrayList<>(list1);

        List<String> ans = getShrunkArray(list,3);
    }
}
