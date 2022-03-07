package com.algorithms.leetcode;

/*
Leeetcode 0504
*/
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        if(num==0){return "0";}

        Boolean negative = false;
        if(num<0){
            negative = true;
            num = -num;
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num%7);
            num /= 7;
        }
        if(negative){
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
