package com.algorithms.jianZhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
JianZhi Offer 2-007
Leeetcode 0015
 */

public class ThreeSum {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            twoSum(nums, i);
            int temp = nums[i];
            while (i < nums.length && temp == nums[i]) {
                i++;
            }
        }
        return results;
    }

    public void twoSum(int[] numbers, int cursor) {
        int target = -numbers[cursor];
        int low = cursor + 1;
        int high = numbers.length - 1;

        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                results.add(Arrays.asList(numbers[cursor], numbers[low], numbers[high]));
                int temp = numbers[low];
                while (temp == numbers[low] && low < high) {
                    low++;
                }
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
    }
}
