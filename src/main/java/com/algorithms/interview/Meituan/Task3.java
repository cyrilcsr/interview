package com.algorithms.interview.Meituan;

import java.util.Scanner;

public class Task3 {
    static int result;
//    public static void main(String[] args) {
//        result = 0;
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[] cards = new int[num];
//        for(int i=0;i<num;i++){
//            cards[i] = sc.nextInt();
//        }
//        dfs(cards,0,0);
//        System.out.println(result);
//    }

    public static void dfs(int[] cards, int index, int sum){
        if(index==cards.length){
            if(sum%7==0) result = Math.max(result,sum);
            return;
        }
        int v = cards[index];
        if(!(v>0&&v%7==0)){
            dfs(cards,index+1,sum);
        }
        if(v<0&&v%7==0){
            return;
        }
        dfs(cards, index+1,sum+cards[index]);
    }

}
