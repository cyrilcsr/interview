package com.algorithms.summer.Ctrip;

import java.util.Scanner;

public class Task4 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int m = sc.nextInt();
//            int q = sc.nextInt();
//            sc.nextLine();
//            char[][] matrix = new char[n][m];
//            int[][] opts = new int[q][4];
//            for (int i = 0; i < n; i++) {
//                matrix[i] = sc.nextLine().toCharArray();
//            }
//            for (int i = 0; i < q; i++) {
//                String[] s = sc.nextLine().split(" ");
//                for (int j = 0; j < 4; j++) {
//                    opts[i][j] = Integer.parseInt(s[j])-1;
//                }
//            }
//            for (int i = 0; i < q; i++) {
//                for (int j = opts[i][0]; j <= opts[i][2]; j++) {
//                    for (int k = opts[i][1]; k <= opts[i][3]; k++) {
//                        if ('A' <= matrix[j][k] && matrix[j][k] <= 'Z') {
//                            matrix[j][k] = (char) ('a' + (matrix[j][k] - 'A'));
//                        }else{
//                            matrix[j][k] = (char) ('A' + (matrix[j][k] - 'a'));
//                        }
//                    }
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < m; j++) {
//                    sb.append(matrix[i][j]);
//                }
//                System.out.println(sb.toString());
//            }
//        }
//    }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        char[][] matrix = new char[n][m];
        boolean[][] matrixMap = new boolean[n][m];
        int[][] opts = new int[q][4];
        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < q; i++) {
            int x1 = sc.nextInt()-1;
            int y1 = sc.nextInt()-1;
            int x2 = sc.nextInt()-1;
            int y2 = sc.nextInt()-1;
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if(matrixMap[j][k]){
                        matrixMap[j][k] = false;
                    }else{
                        matrixMap[j][k] = true;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrixMap[i][j]){
                    if ('A' <= matrix[i][j] && matrix[i][j] <= 'Z') {
                        matrix[i][j] = (char) ('a' + (matrix[i][j] - 'A'));
                    }else{
                        matrix[i][j] = (char) ('A' + (matrix[i][j] - 'a'));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]);
            }
            System.out.println(sb.toString());
        }
    }
}
}
