package com.datastructure.String;

public class PrintAllPermutationsOfGivenString {

    void permutations(String str,int l,int h){

        if(l==h){
            System.out.println(str);
        }else{
            for(int i=l;i<=h;i++){
                str = swap(str,l,i);
                permutations(str,l+1,h);
                str = swap(str,l,i);
            }
        }
    }

    String swap(String str,int l,int h){
        char[] ch = str.toCharArray();
        char c = ch[l];
        ch[l]=ch[h];
        ch[h]=c;
        return String.valueOf(ch);
    }

    public static void main(String[] a){
        PrintAllPermutationsOfGivenString permute = new PrintAllPermutationsOfGivenString();
        String str = "ABC";
        int n = str.length();
        permute.permutations(str,0,n-1);
    }
}
