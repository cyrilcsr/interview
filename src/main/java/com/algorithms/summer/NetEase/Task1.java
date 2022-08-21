package com.algorithms.summer.NetEase;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int result = 0;
        while(a>0||b>0){
            int biggerAB = Math.max(a,b);
            if(y>=a&&y>=b){
                result++;
                a-=y;
                b-=y;
                break;
            }
            if(y>x){
                a-=y;
                b-=y;
                result++;
                continue;
            }
            if(x>y*2||a<=0||b<=0){
                if(a>=b){
                    a-=x;
                    result++;
                }else{
                    b-=x;
                    result++;
                }
                continue;
            }
            if((a-y<=0||b-y<=0)||(a-y>0||b-y>0)){
                a-=y;
                b-=y;
                result++;
                continue;
            }
            if(a>=b){
                a-=x;
                result++;
            }else{
                b-=x;
                result++;
            }
        }
        System.out.println(result);
    }
}
