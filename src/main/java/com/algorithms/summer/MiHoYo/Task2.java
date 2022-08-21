package com.algorithms.summer.MiHoYo;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine().trim();
            int result =0;
            char[] sArray = s.toCharArray();
            int continuousCount = 0;
            for(int i=0;i<sArray.length;i++){
                if(sArray[i]=='1'){
                    continuousCount++;
                }else{
                    if((continuousCount&1)==1){
                        result++;
                    }
                    continuousCount=0;
                }
            }
            if((continuousCount&1)==1){
                result++;
            }

            System.out.println(result);
        }
    }
}
