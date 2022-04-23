package com.algorithms.leetcode.ConvexHull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Leeetcode 0587
 */
public class ErectTheFence {
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n < 4) {
            return trees;
        }
        /* 按照 x 大小进行排序，如果 x 相同，则按照 y 的大小进行排序 */
        Arrays.sort(trees, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<Integer> hull = new ArrayList<Integer>();
        boolean[] used = new boolean[n];
        /* hull[0] 需要入栈两次，不进行标记 */
        hull.add(0);
        /* 求出凸包的下半部分 */
        for (int i = 1; i < n; i++) {
            while (hull.size() > 1 && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                used[hull.get(hull.size() - 1)] = false;
                hull.remove(hull.size() - 1);
            }
            used[i] = true;
            hull.add(i);
        }
        int m = hull.size();
        /* 求出凸包的上半部分 */
        for (int i = n - 2; i >= 0; i--) {
            if (!used[i]) {
                while (hull.size() > m && cross(trees[hull.get(hull.size() - 2)], trees[hull.get(hull.size() - 1)], trees[i]) < 0) {
                    used[hull.get(hull.size() - 1)] = false;
                    hull.remove(hull.size() - 1);
                }
                used[i] = true;
                hull.add(i);
            }
        }
        /* hull[0] 同时参与凸包的上半部分检测，因此需去掉重复的 hull[0] */
        hull.remove(hull.size() - 1);
        int size = hull.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = trees[hull.get(i)];
        }
        return res;
    }

    public int cross(int[] p, int[] q, int[] r) {
        return (q[0] - p[0]) * (r[1] - q[1]) - (q[1] - p[1]) * (r[0] - q[0]);
    }

    public static int[][] outerTrees2(int[][] points) {
        int n = points.length;
        int s = 0;
        int[][] stack = new int[n << 1][];
        // x小的排前面，x一样的，y小的排前面
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            while (s > 1 && cross2(stack[s - 2], stack[s - 1], points[i]) > 0) {
                // 如果a到c的向量，在从a到b的向量右侧，返回正数
                s--; // 即 stack[s - 1] 弹出
            } // points[i] 入栈成为 stack[s - 1]
            stack[s++] = points[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            while (s > 1 && cross2(stack[s - 2], stack[s - 1], points[i]) > 0) {
                // 如果a到c的向量，在从a到b的向量右侧，返回正数
                s--; // 即 stack[s - 1] 弹出
            } // points[i] 入栈成为 stack[s - 1]
            stack[s++] = points[i];
        }
        // 去重返回
        Arrays.sort(stack, 0, s, (a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
        n = 1;
        for (int i = 1; i < s; i++) {
            // 如果i点，x和y，与i-1点，x和y都一样
            // i点与i-1点，在同一个位置，此时，i点不保留
            if (stack[i][0] != stack[i - 1][0] || stack[i][1] != stack[i - 1][1]) {
                stack[n++] = stack[i];
            }
        }
        return Arrays.copyOf(stack, n);
    }

    // 叉乘的实现
    // 假设有a、b、c三个点，并且给出每个点的(x,y)位置
    // 从a到c的向量，在从a到b的向量的哪一侧？
    // 如果a到c的向量，在从a到b的向量右侧，返回正数
    // 如果a到c的向量，在从a到b的向量左侧，返回负数
    // 如果a到c的向量，和从a到b的向量重合，返回0
    public static int cross2(int[] a, int[] b, int[] c) {
        return (b[1] - a[1]) * (c[0] - b[0]) - (b[0] - a[0]) * (c[1] - b[1]);
    }
}
