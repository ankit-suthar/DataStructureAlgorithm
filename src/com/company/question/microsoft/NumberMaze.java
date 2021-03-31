package com.company.question.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberMaze {

    static class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int count=0;

    static int getCount(ArrayList<String> input){
        int row = input.size();
        int col = input.get(0).length();
        TreeMap<String,Pair> map = new TreeMap<>();

        for(int i=0;i<row;i++){
            String ans = input.get(i);
            for(int j=0;j<col;j++){
                if((int)ans.charAt(j) >= 48 && (int) ans.charAt(j) <= 57){
                    map.put(ans.substring(j,j+1),new Pair(i,j));
                }
            }
        }

        Pair pair = map.get("0");

        if(pair.i==0 && pair.j==0){
            count++;
        }else{
            return count;
        }

        Pair pair1;

        for(int i=1;i<10;i++){
            if(i==1){
                pair = map.get("0");
                int i1=pair.i;
                int j1=pair.j;
                pair1 = map.get("1");
                int i2=pair1.i;
                int j2=pair1.j;

                if(getConditionStatus(pair,pair1,map)
                        || (i2-1==i1 && j2-1==j1) || (i2+1==i1 && j2+1==j1) || (i2-1==i1 && j2+1==j1) || (i2+1==i1 && j2-1==j1)){
                    count++;
                }else{
                    return count;
                }
            }else{
                if(!getUpdate(String.valueOf(i-1),String.valueOf(i),map)){
                    return count;
                }
            }
        }
        return count;
    }

    static boolean getUpdate(String str1,String str2,TreeMap<String,Pair> map){
        Pair pair1 = map.get(str1);
        Pair pair2 = map.get(str2);

        if(getConditionStatus(pair1,pair2,map)){
            count++;
            return true;
        }else{
            return false;
        }
    }

    static boolean getConditionStatus(Pair pair1,Pair pair2, TreeMap<String,Pair> map){
        int i1,j1,i2,j2;

        i1=pair1.i;
        j1=pair1.j;
        i2=pair2.i;
        j2=pair2.j;

        if((i2==i1 && j2-1==j1) || (i2==i1 && j2+1==j1) || (i2+1==i1 && j2==j1) || (i2-1==i1 && j2==j1)){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] a){
        ArrayList<String> list = new ArrayList<String>(List.of("0...567","12..4..8","3......9"));

        System.out.println(getCount(list));
    }
}
