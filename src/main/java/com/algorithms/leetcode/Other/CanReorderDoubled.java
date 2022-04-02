package com.algorithms.leetcode.Other;

import java.util.*;

/*
Leeetcode 0954
*/
public class CanReorderDoubled {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i : arr) {
            hashmap.put(i, hashmap.getOrDefault(i, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(arr.length);
        keys.addAll(hashmap.keySet());

        keys.sort((a, b) -> Math.abs(a) - Math.abs(b));
        for (int i : keys) {
            if (hashmap.get(i) == 0) continue;
            if (!hashmap.containsKey(i * 2)) return false;
            if (hashmap.get(i) > hashmap.get(i * 2)) return false;
            hashmap.put(i * 2, hashmap.get(i * 2) - hashmap.get(i));
            hashmap.put(i, 0);
        }

        return true;
    }
}
