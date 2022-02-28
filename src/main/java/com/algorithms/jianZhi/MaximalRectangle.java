package com.algorithms.jianZhi;

import java.util.ArrayDeque;

/*
JianZhi Offer 2-040
Leeetcode 0085
 */

public class MaximalRectangle {
    public int maximalRectangle(String[] matrix) {
        if(matrix.length==0||matrix[0].length()==0){
            return 0;
        }

        int colNum = matrix[0].length();

        int[] histogramRow = new int[colNum];
        int result = 0;

        for (String s : matrix) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < colNum; j++) {
                if (chars[j] == '1') {
                    histogramRow[j] = 1 + histogramRow[j];
                } else {
                    histogramRow[j] = 0;
                }
            }
            result = Math.max(result, largestRectangleArea(histogramRow));
        }

        return result;
    }
    public int maximalRectangle2(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return 0;
        }

        int colNum = matrix[0].length;

        int[] histogramRow = new int[colNum];
        int result = 0;

        for (char[] chars : matrix) {
            for (int j = 0; j < colNum; j++) {
                if (chars[j] == '1') {
                    histogramRow[j] = 1 + histogramRow[j];
                } else {
                    histogramRow[j] = 0;
                }
            }
            result = Math.max(result, largestRectangleArea(histogramRow));
        }

        return result;
    }

    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int[] dummyHeights = new int[heights.length+2];
        for(int i=0;i<heights.length;i++){
            dummyHeights[i+1] = heights[i];
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<dummyHeights.length;i++){
            while(!deque.isEmpty()&&deque.peek()!=0
                    &&dummyHeights[i]<dummyHeights[deque.peek()]){
                int index = deque.pop();
                result = Math.max(result,(i-deque.peek()-1)*dummyHeights[index]);
            }
            deque.push(i);
        }

        return result;
    }
}
