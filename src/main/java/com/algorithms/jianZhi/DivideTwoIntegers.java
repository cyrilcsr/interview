package com.algorithms.jianZhi;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        boolean reversed = false;
        if(dividend > 0){
            dividend = -dividend;
            reversed = !reversed;
        }

        if(divisor > 0){
            divisor = -divisor;
            reversed = !reversed;
        }

        int result = 0;
        while(dividend <= divisor){
            int quotient = 1;
            int value = divisor;
            while(dividend>>1 < value){
                quotient <<=1;
                value <<=1;
            }
            dividend-=value;
            result+=quotient;
        }
        return reversed ? -result : result;
    }


    private void test(){
        int a = 0;
        int b = 0;
        divide(a,b);
    }

}
