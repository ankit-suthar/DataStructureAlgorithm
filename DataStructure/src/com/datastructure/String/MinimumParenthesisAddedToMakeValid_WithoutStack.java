package com.datastructure.String;

public class MinimumParenthesisAddedToMakeValid_WithoutStack {

    static int findTotalParenthesisNeedToValid(String parenthesis){
        int n = parenthesis.length();
        int open=0,close=0;
        char c;
        for(int i=n-1;i>=0;i--){
            c = parenthesis.charAt(i);
            if(c=='('){
                open++;
            }else if(c==')'){
                close++;
            }
        }
        return Math.abs(open-close);
    }

    public static void main(String[] a){
        //String parenthesis="((()())";
        String parenthesis="())";
        System.out.println(findTotalParenthesisNeedToValid(parenthesis));
    }
}
//Time Complexity: O(n)
//Auxillary Space: O(1)