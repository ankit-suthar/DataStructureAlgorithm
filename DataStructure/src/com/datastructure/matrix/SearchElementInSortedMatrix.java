/*
Given a sorted matrix mat[n][m] and an element ‘x’. Find position of x in the matrix if it is present,
else print -1. Matrix is sorted in a way such that all elements in a row are sorted in increasing order
and for row ‘i’, where 1 <= i <= n-1, first element of row 'i' is greater than or equal to the last element
of row 'i-1'. The approach should have O(log n + log m) time complexity. Examples:

Input : mat[][] = { {1, 5, 9},
                    {14, 20, 21},
                    {30, 34, 43} }
        x = 14
Output : Found at (1, 0)

Input : mat[][] = { {1, 5, 9, 11},
                    {14, 20, 21, 26},
                    {30, 34, 43, 50} }
        x = 42
Output : -1
*/
package com.datastructure.matrix;

public class SearchElementInSortedMatrix {

    static boolean sortedMatrixSearch(int[][] mat,int n,int m,int x){

        int i=0;
        int j=m-1;

        while(i<n && j>=0){
            if(mat[i][j]>x){
                j--;
            }else if(mat[i][j]<x){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args){
        int n = 4, m = 5, x = 38;
        int mat[][] = {{0, 6, 8, 9, 11},
                       {20, 22, 28, 29, 31},
                       {36, 38, 50, 61, 63},
                       {64, 66, 100, 122, 128}};

        if(sortedMatrixSearch(mat, n, m, x)){
            System.out.println("Found");
        }else{
            System.out.println("Not found");
        }
    }
}
//Time complexity: O(log n + log m) n = number of rows, m = number of columns