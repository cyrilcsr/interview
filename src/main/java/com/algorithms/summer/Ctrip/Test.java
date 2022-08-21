package com.algorithms.summer.Ctrip;

public class Test {
    public static void main(String[] args) {
        char c = 'A';
        if('A'<=c&&c<='Z'){
            c = (char) ('a'+(c-'A'));
            System.out.println(c);
        }
    }
}
