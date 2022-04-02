package com.algorithms.interview.JD;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inArray = sc.nextLine().split(" ");
        int n = Integer.parseInt(inArray[0]);
        BigInteger node = new BigInteger(inArray[1]);
        char[] opts = sc.nextLine().toCharArray();
        for (char opt : opts) {
            if (opt == 'U') {
                node = node.shiftRight(1);
            }
            if (opt == 'R') {
                node = node.shiftLeft(1).add(new BigInteger("1"));
            }
            if (opt == 'L') {
                node = node.shiftLeft(1);
            }
        }
        System.out.println(node);
    }
}
