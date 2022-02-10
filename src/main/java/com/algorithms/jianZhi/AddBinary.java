package com.algorithms.jianZhi;

import java.math.BigInteger;

/*
JianZhi Offer 2-002
Leeetcode 0067
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int digitA = i>=0 ? a.charAt(i) - '0' : 0;
            int digitB = j>=0 ? b.charAt(j) - '0' : 0;
            int sum = digitA + digitB + carry;

            carry  = sum >=2 ? 1 : 0;
            sum = sum >=2 ? sum-2 : sum;
            result.append(sum);
            i--;
            j--;
        }

        if(carry ==1){
            result.append(carry);
        }

        result.reverse();

        return result.toString();
    }

    public String addBinary2(String a, String b) {
        BigInteger intA = new BigInteger(a,2);
        BigInteger intB = new BigInteger(b,2);

        return intA.add(intB).toString(2);
    }

}
