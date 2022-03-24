package com.algorithms.leetcode.Other;

/*
Leeetcode 0661
*/
public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int rowNum = img.length;
        int colNum = img[0].length;
        int size = 3;
        int[][] result = new int[rowNum][colNum];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                int count = 0;
                int sum = 0;
                for(int x=-1;x<2;x++){
                    for(int y=-1;y<2;y++){
                       if(i+x>=0&&i+x<rowNum&&j+y>=0&&j+y<colNum){
                           count++;
                           sum+=img[i+x][j+y];
                       }
                    }
                }
                result[i][j] = sum/count;
            }
        }
        return result;
    }
}
