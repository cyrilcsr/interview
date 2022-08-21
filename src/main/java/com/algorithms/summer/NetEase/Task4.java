package com.algorithms.summer.NetEase;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        for(int i=1;i<row;i++){
            if(matrix[i][0]==matrix[i-1][0]){
                dp[i][0] = dp[i-1][0]+1;
            }else{
                dp[i][0]=dp[i-1][0]+2;
            }
        }
        for(int i=1;i<col;i++){
            if(matrix[0][i]==matrix[0][i-1]){
                dp[0][i] = dp[0][i-1]+1;
            }else{
                dp[0][i]= dp[0][i-1]+2;
            }
        }

        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                int left = matrix[i][j]==matrix[i][j-1]?dp[i][j-1]+1:dp[i][j-1]+2;
                int up = matrix[i][j]==matrix[i-1][j]?dp[i-1][j]+1:dp[i-1][j]+2;
//                int upLeft = matrix[i][j]==matrix[i-1][j-1]?dp[i-1][j-1]+1:dp[i-1][j-1]+2;
//                dp[i][j] = Math.min(upLeft,Math.min(left,up));
                dp[i][j] = Math.min(left,up);
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[row-1][col-1]);
    }
}
