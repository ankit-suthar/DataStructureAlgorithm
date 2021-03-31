/*
Given a matrix of integers, task is to find out number of positional elements.
A positional element is one which is either minimum or maximum in a row or in a column.

Examples:

Input : a = {{1, 3, 4}, {5, 2, 9}, {8, 7, 6}}
Output : 7
There are total 7 elements min elements are 1, 2, 6 and 4. And max elements are 9, 8 and 7.

Input : a = {{1, 1}, {1, 1}, {1, 1}}
Output : 6
*/
package com.datastructure.matrix;

public class FindNumberOfPositionalElements {

    static int countPositional(int arr[][],int m,int n){
        int count=0;

        int rMax[] = new int[m];
        int rMin[] = new int[m];
        int cMax[] = new int[n];
        int cMin[] = new int[n];
        int rowMax;
        int rowMin;
        int colMax;
        int colMin;

        for(int i=0;i<m;i++){
            rowMax = Integer.MIN_VALUE;
            rowMin = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(arr[i][j]>rowMax){
                    rowMax=arr[i][j];
                }
                if(arr[i][j]<rowMin){
                    rowMin=arr[i][j];
                }
            }
            rMax[i]=rowMax;
            rMin[i]=rowMin;
        }

        for(int j=0;j<n;j++){
            colMax = Integer.MIN_VALUE;
            colMin = Integer.MAX_VALUE;
            for(int i=0;i<m;i++){
                if(arr[i][j]>colMax){
                    colMax=arr[i][j];
                }
                if(arr[i][j]<colMin){
                    colMin=arr[i][j];
                }
            }
            cMax[j]=colMax;
            cMin[j]=colMin;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==rMax[i] || arr[i][j]==rMin[i] || arr[i][j]==cMax[j] || arr[i][j]==cMin[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] arg){
        int a[][] = new int[][] { { 1, 3, 4 }, { 5, 2, 9 }, { 8, 7, 6 } };
        int m = a.length, n = a[0].length;
        System.out.println(countPositional(a, m, n));
    }
}
