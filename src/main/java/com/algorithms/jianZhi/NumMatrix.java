package com.algorithms.jianZhi;

import java.util.Arrays;

/*
JianZhi Offer 2-013
Leeetcode 0304
 */
public class NumMatrix {

    private int[][] posSum;

    public NumMatrix(int[][] matrix) {
        this.posSum = new int[matrix.length+1][matrix[0].length+1];
        for(int i = 0;i< matrix.length;i++){
            int rowSum = 0;
            for(int j=0;j< matrix[0].length;j++){
                 rowSum+= matrix[i][j];
                posSum[i+1][j+1] = posSum[i][j+1]+rowSum;
            }
        }

        System.out.println(Arrays.deepToString(posSum));

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return posSum[row2+1][col2+1]- posSum[row1][col2+1]- posSum[row2+1][col1]+posSum[row1][col1];
    }
}
