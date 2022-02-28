package com.algorithms.jianZhi;

import java.util.ArrayDeque;
import java.util.Deque;

/*
JianZhi Offer 2-039
Leeetcode 0084
 */
public class LargestRectangleArea {
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
