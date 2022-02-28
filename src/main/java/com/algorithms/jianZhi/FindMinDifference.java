package com.algorithms.jianZhi;

import java.util.List;

/*
JianZhi Offer 2-035
Leeetcode 0539
 */
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) {
            return 0;
        }

        boolean[] map = new boolean[1440];

        for (String time : timePoints) {
            int timeNum = timeToNumber(time);
            if (map[timeNum]) {
                return 0;
            }
            map[timeNum] = true;
        }

        int minimum = Integer.MAX_VALUE;

        int first = findNextTrue(map, -1);
        int curr = first;
        int next = findNextTrue(map, curr);
        while (next != -1) {
            minimum = Math.min(minimum, next - curr);
            curr = next;
            next = findNextTrue(map, curr);
        }
        minimum = Math.min(minimum, 1440 - curr + first);

        return minimum;
    }

    private int timeToNumber(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    private int findNextTrue(boolean[] array, int index) {
        for (int i = index + 1; i < array.length; i++) {
            if (array[i]) {
                return i;
            }
        }
        return -1;
    }
}
