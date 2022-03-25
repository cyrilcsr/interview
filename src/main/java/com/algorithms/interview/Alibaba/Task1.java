package com.algorithms.interview.Alibaba;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        Set<String> hash = new HashSet<>();
        search:while(sc.hasNext()){
            String s = sc.nextLine();
            int len = s.length();
            if(len<6||len>12){
                System.out.println("illegal length");
                continue;
            }
            for(int i=0;i<len;i++){
                char c = s.charAt(i);
                if(('a'<=c&&c<='z')||('A'<=c&&c<='Z')){
                    continue;
                }
                System.out.println("illegal charactor");
                continue search;
            }
            if(hash.contains(s)){
                System.out.println("acount existed");
                continue;
            }
            hash.add(s);
            System.out.println("registration complete");
        }
    }
}
