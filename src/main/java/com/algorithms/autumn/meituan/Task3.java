package com.algorithms.autumn.meituan;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] cards = new int[n];
            for(int i=0;i<n;i++) cards[i] = sc.nextInt();
            Deque<Integer> queue= new ArrayDeque<>(n);
            queue.offer(cards[n-1]);
            if(n>1) queue.offerFirst(cards[n-2]);
            for(int i=n-3;i>=0;i--){
                int c1 = queue.pollLast();
                int c2 = queue.pollLast();
                queue.offerFirst(cards[i]);
                queue.offerFirst(c1);
                queue.offerFirst(c2);
            }
            while(!queue.isEmpty()){
                System.out.print(queue.poll());
                if(!queue.isEmpty()){
                    System.out.print(" ");
                }else{
                    System.out.print("\n");
                }
            }
        }
    }
}
