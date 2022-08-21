package com.algorithms.summer.JD;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            int n = sc.nextInt();
            sc.nextLine();
            char[] initColors = sc.nextLine().trim().toCharArray();
            int[] colorCount = new int[3];

            for(char c:initColors){
                if(c=='A') colorCount[0]++;
                if(c=='B') colorCount[1]++;
                if(c=='C') colorCount[2]++;
            }
            if(colorCount[0]==colorCount[1]&&colorCount[1]==colorCount[2]){
                System.out.println(0);
                continue;
            }
            int result = 0;
//            for(int j:colorCount){
//                if(j<n) result++;
//            }
//            System.out.println(result);

            int[] maxContinues = new int[3];
            char prev = initColors[0];
            int count = 0;
            for(char c:initColors){
                if(c==prev){
                    count++;
                }else{
                    if(prev=='A') maxContinues[0]=Math.max(maxContinues[0],count);
                    if(prev=='B') maxContinues[1]=Math.max(maxContinues[1],count);
                    if(prev=='C') maxContinues[2]=Math.max(maxContinues[2],count);
                    prev = c;
                    count=1;
                }
            }
            int k=0;
            while(prev==initColors[k]){
                count++;
                k++;
            }

            if(prev=='A') maxContinues[0]=Math.max(maxContinues[0],count);
            if(prev=='B') maxContinues[1]=Math.max(maxContinues[1],count);
            if(prev=='C') maxContinues[2]=Math.max(maxContinues[2],count);
            result = 0;
//            System.out.println("Color Count A: "+colorCount[0]+"B: "+colorCount[1]+"C: "+colorCount[2]);
//            System.out.println("maxContinues A: "+maxContinues[0]+"B: "+maxContinues[1]+"C: "+maxContinues[2]);
            for(int j:maxContinues){
                if(j<n){
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
