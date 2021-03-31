/*
Given N, Find the total number of unique BSTs that can be made using values from 1 to N.

Examples:

Input: n = 3
Output: 5
For n = 3, preorder traversal of Unique BSTs are:
1. 1 2 3
2. 1 3 2
3. 2 1 3
4. 3 1 2
5. 3 2 1

Input: 4
Output: 14
*/
package com.algorithm.dynamicprogramming;

public class TotalBSTreesCount {

    static int countTotalBST(int n){
        int[] ans = new int[n+1];
        ans[0]=1;
        ans[1]=1;

        /*for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                ans[i] = ans[i] + ans[i-j]*ans[j-1];
            }
        }*/

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                ans[i] += (ans[j]*ans[i-j-1]);
            }
        }

        return ans[n];
    }
    public static void main(String[] a){
        int n = 2; // 4->14 , 5-> 42 3 -> 5 2 -> 2
        System.out.println(countTotalBST(n));
    }
}
//Time Complexity: O(n2)