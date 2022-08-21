package com.algorithms.autumn.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            char[] orders = s.toCharArray();
            boolean[][] visited = new boolean[n][m];
            int diff = n * m - 1;
            visited[0][0] = true;
            int x = 0, y = 0;
            int cnt = 0;
            for (char c : orders) {
                if (diff == 0) break;
                if (c == 'W') {
                    x--;
                } else if (c == 'A') {
                    y--;
                } else if (c == 'S') {
                    x++;
                } else if (c == 'D') {
                    y++;
                }
                cnt++;
                if (!visited[x][y]) {
                    diff--;
                    visited[x][y] = true;
                }
            }
            if (diff == 0) {
                System.out.println("Yes");
                System.out.println(cnt);
            } else {
                System.out.println("No");
                System.out.println(diff);
            }
        }
    }
}
