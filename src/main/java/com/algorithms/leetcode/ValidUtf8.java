package com.algorithms.leetcode;

/*
Leeetcode 0393
 */
public class ValidUtf8 {
    public boolean validUtf8(int[] data) {
        int mask1 = 1<<7;
        int mask2 = (1<<7)+(1<<6);
        int index = 0;
        while(index<data.length){
            if((data[index]&mask1)!=0){
                int len = findByte(data[index]);
                if(len<=1||len>4){
                    return false;
                }
                for(int i=1;i<len;i++){
                    index++;
                    if(index>=data.length){
                        return false;
                    }
                    if((data[index]&mask2)!=mask1){
                        return false;
                    }
                }
            }
            index++;
        }
        return true;
    }

    private int findByte(int num){
        int mask = 1<<7;
        int count = 0;
        for(int i=0;i<8;i++){
            if((num&mask)==mask){
                count++;
                mask = mask>>1;
            }else{
                return count;
            }
        }
        return count;
    }
}
