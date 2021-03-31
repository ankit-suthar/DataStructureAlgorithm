package com.datastructure.matrix;

public class InplaceRotateSquareMatrix90DegreesAntiClockwise {

    void printMatrix(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    void rotateMatrix(int[][] mat){
        int N = mat.length;

        for(int i=0;i<N/2;i++){
            for(int j=i;j<N-i-1;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][N-i-1];
                mat[j][N-i-1] = mat[N-i-1][N-j-1];
                mat[N-i-1][N-j-1] = mat[N-j-1][i];
                mat[N-j-1][i] = temp;
            }
        }
    }

    public static void main(String[] a){
        InplaceRotateSquareMatrix90DegreesAntiClockwise matrix = new InplaceRotateSquareMatrix90DegreesAntiClockwise();
        int mat[][] = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        System.out.println("Original matrix:");
        matrix.printMatrix(mat);
        System.out.println();

        matrix.rotateMatrix(mat);
        System.out.println("90 degree rotated matrix:");
        matrix.printMatrix(mat);
    }
}
