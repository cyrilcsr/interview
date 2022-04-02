package com.algorithms.classical.sort;

public class ShellSort {
    public static void shellSort1(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 分组
            for (int groupStartIndex = 0; groupStartIndex < gap; groupStartIndex++) {
                // 插入排序
                for (int currentIndex = groupStartIndex + gap; currentIndex < arr.length; currentIndex += gap) {
                    // currentNumber 站起来，开始找位置
                    int currentNumber = arr[currentIndex];
                    int preIndex = currentIndex - gap;
                    while (preIndex >= groupStartIndex && currentNumber < arr[preIndex]) {
                        // 向后挪位置
                        arr[preIndex + gap] = arr[preIndex];
                        preIndex -= gap;
                    }
                    // currentNumber 找到了自己的位置，坐下
                    arr[preIndex + gap] = currentNumber;
                }
            }
        }
    }

    public static void shellSort2(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = arr[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // currentNumber 找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }
    }
    public static void shellSortByKnuth(int[] arr) {
        // 找到当前数组需要用到的 Knuth 序列中的最大值
        int maxKnuthNumber = 1;
        while (maxKnuthNumber <= arr.length / 3) {
            maxKnuthNumber = maxKnuthNumber * 3 + 1;
        }
        // 增量按照 Knuth 序列规则依次递减
        for (int gap = maxKnuthNumber; gap > 0; gap = (gap - 1) / 3) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = arr[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // currentNumber 找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }
    }

}
