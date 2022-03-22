package com.algorithms.leetcode.Greedy;

/*
Leeetcode 2038
*/
public class WinnerOfGame {
    public boolean winnerOfGame(String colors) {
        int optA=0, optB=0, countA=0, countB=0;
        boolean flag = false;
        for(char c:colors.toCharArray()){
            if(c=='A'){
                if(flag){
                    countA++;
                }else{
                    flag = true;
                    optA +=countA>2?countA-2:0;
                    countA=1;
                }
            }else{
                if(!flag){
                    countB++;
                }else{
                    flag = false;
                    optB +=countB>2?countB-2:0;
                    countB=1;
                }
            }
        }
        optA +=countA>2?countA-2:0;
        optB +=countB>2?countB-2:0;
        return optA > optB;
    }
}
