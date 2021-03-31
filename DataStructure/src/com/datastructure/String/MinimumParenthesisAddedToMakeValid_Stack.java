package com.datastructure.String;

import java.util.Stack;

public class MinimumParenthesisAddedToMakeValid_Stack {

    static boolean validate(char c1,char c2){
        if(c1==c2){
            return true;
        }else{
            return false;
        }
    }

    static int findTotalParenthesisNeedToValid(String parenthesis){
        int n = parenthesis.length();
        Stack<Character> stack = new Stack<>();
        char c;
        for(int i=n-1;i>=0;i--){
            c = parenthesis.charAt(i);
            if(!stack.isEmpty()){
                if(validate(c,stack.peek())){
                    stack.push(c);
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] a){
        String parenthesis="((()())";
        System.out.println(findTotalParenthesisNeedToValid(parenthesis));
    }
}
//Time Complexity: O(n)
//Auxillary Space: O(n)