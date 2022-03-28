package com.algorithms.interview.NetEase;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int layer = 0;
        int temp = n;
        while(temp!=0){
            layer++;
            temp = temp>>1;
        }
        int[] order = new int[n];
        int[] allOdd = (n&1)==1?new int[n/2+1]:new int[n/2];
        int[] allEven = new int[n/2];

        for(int i=0;i<n;i++){
            int num = i+1;
            if((num&1)==1){
                allOdd[num/2] = num;
            }else{
                allEven[num/2-1]=num;
            }
        }
        boolean flag = true;
        if((layer&1)==1){
            flag=false;
        }
        StringBuilder sb = new StringBuilder();

        int oddIndex = 0;
        int evenIndex = 0;
        for(int i=0;i<layer;i++){
            int nodeNum = (int) Math.pow(2,i);
            if(flag){
                for(int j=0;j<nodeNum;j++){
                    if(oddIndex==allOdd.length&&evenIndex== allEven.length){
                        break;
                    }
                    if(evenIndex==allEven.length){
                        sb.append(allOdd[oddIndex]);
                        sb.append(" ");
                        oddIndex++;
                    }else{
                        sb.append(allEven[evenIndex]);
                        sb.append(" ");
                        evenIndex++;
                    }
                }
            }else{
                for(int j=0;j<nodeNum;j++){
                    if(oddIndex==allOdd.length&&evenIndex== allEven.length){
                        break;
                    }
                    if(oddIndex==allOdd.length){
                        sb.append(allEven[evenIndex]);
                        sb.append(" ");
                        evenIndex++;
                    }else{
                        sb.append(allOdd[oddIndex]);
                        sb.append(" ");
                        oddIndex++;
                    }
                }
            }
            if(flag){
                flag=false;
            }else{
                flag=true;
            }

        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
