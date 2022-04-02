package com.algorithms.classical.sort;

public class QuickSort {
    public static void quickSort(int[] arr){

    }

    public static void quickSort(int[] arr, int start, int end){
        if(start>end) return;
        int i=start, j=end;
        while(i<j){
            while(i<j&&arr[j]>=arr[start]) j++;
            while(i<j&&arr[i]<=arr[start]) i++;
            swap(arr,i,j);
        }
        swap(arr,i,start);
        quickSort(arr,start,i-1);
        quickSort(arr,i+1,end);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
