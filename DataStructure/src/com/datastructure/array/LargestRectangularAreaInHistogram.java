/*
1) Create an empty stack.

2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater.
     Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar.
     For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).

3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
*/
package com.datastructure.array;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {

    static int returnLargestRectangularArea(int[] hist){
        Stack<Integer> stack = new Stack<>();
        int n = hist.length;
        int tp;
        int area;
        int maxArea=0;
        int i=0;

        while(i<n){
            if(stack.isEmpty() || hist[stack.peek()]<=hist[i]){
                stack.push(i);
                i++;
            }else{
                tp = stack.pop();
                area = hist[tp] * (stack.isEmpty()?i:i-stack.peek()-1);
                if(area>maxArea){
                    maxArea=area;
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] a){
        int hist[] = {6,2,5,4,5,1,6};

        int ans = returnLargestRectangularArea(hist);
        System.out.println(ans);
    }
}
//Time Complexity: O(n)