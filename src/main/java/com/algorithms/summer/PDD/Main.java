package com.algorithms.summer.PDD;

import java.util.Scanner;
public class Main {
    //Q1
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int len = sc.nextInt();
//            int[] a = new int[len];
//            int[] b = new int[len];
//            for(int i=0;i<a.length;i++){
//                a[i] = sc.nextInt();
//            }
//            for(int i=0;i<b.length;i++){
//                b[i] = sc.nextInt();
//            }
//            Arrays.sort(a);
//            Arrays.sort(b);
//            System.out.println(Arrays.toString(a));
//            System.out.println(Arrays.toString(b));
//
//            int result = 0;
//            for(int i=0;i<len;i++){
//                result +=(a[i]-b[i])*(a[i]-b[i]);
//            }
//            System.out.println(result);
//        }
//    }

    //Q2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(sc.hasNext()) {
            int len = sc.nextInt();
            int v = sc.nextInt();
            int[][] field = new int[len][3];
            int minDay=Integer.MAX_VALUE;
            int maxDay = 0;
            for(int i=0;i<len;i++){
                field[i][0] = sc.nextInt();
                field[i][1] = sc.nextInt();
                field[i][2] = sc.nextInt();
                minDay = Math.min(minDay,field[i][1]);
                maxDay = Math.max(maxDay,field[i][2]);

            }

            int[] melon = new int[maxDay-minDay+1];
            for(int i=0;i<melon.length;i++){
                for(int j=0;j<len;j++){

                }
            }
        }
    }


    //Q3
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            int k = sc.nextInt();
//            sc.nextLine();
//            String b = sc.nextLine().trim();
//            int len = b.length();
//            StringBuilder sb = new StringBuilder();
//            char[] result = new char[len];
//            Arrays.fill(result,'2');
//            for(int i=0;i<len;i++){
//                if(b.charAt(i)=='0'){
//                    if(i-k>=0){
//                        result[i-k]='0';
//                    }
//                    if(i+k<len){
//                        result[i+k]='0';
//                    }
//                    }
//                }
//
//            for(int i=0;i<len;i++){
//                if(b.charAt(i)=='1'){
//                    if(i-k>=0&&result[i-k]=='1'){
//                        continue;
//                    }
//                    if(i+k<len&&result[i+k]=='1'){
//                        continue;
//                    }
//                    if(i-k<0||result[i-k]=='0'){
//                        result[i+k]='1';
//                        continue;
//                    }
//                    if(i+k>=len||result[i+k]=='0'){
//                        result[i-k]='1';
//                        continue;
//                    }
//                    result[i+k]='1';
//
//                }
//            }
//            for(char c:result){
//                if(c=='2'){
//                    sb.append('0');
//                }else{
//                    sb.append(c);
//                }
//            }
//            System.out.println(sb.toString());
//        }
//    }

//Q4
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        sc.nextLine();
//        while(sc.hasNext()) {
//            int n = sc.nextInt();
//            int k = sc.nextInt();
//            sc.nextLine();
//            String s = sc.nextLine().trim();
//            if(n%k!=0){
//                System.out.println("-1");
//                continue;
//            }
//
//            int[] hash = new int[26];
//            for(char c:s.toCharArray()){
//                hash[c-'a']++;
//            }
//
//            if(isNiceString(hash,k)){
//                System.out.println(s);
//                continue;
//            }
//
//            char[] result = s.toCharArray();
//            int i = result.length-1;
//            int nextChar = nextInHash(hash, result[i]-'a',k);
//            if(nextChar!=-1){
//                hash[result[i]-'a']-=1;
//                hash[nextChar]+=1;
//                result[i] = (char)(nextChar);
//            }
//            StringBuilder sb = new StringBuilder();
//            for(char c:result){
//                sb.append(c);
//            }
//            System.out.println(sb.toString());
//        }
//    }
//    private static boolean isNiceString(int[] hash, int k){
//        for (int j : hash) {
//            if (j % k != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static int nextInHash(int[] hash, int i, int k){
//        for(int j=i+1;j<hash.length;j++){
//            if(hash[j]%k!=0){
//                return j;
//            }
//        }
//        return -1;
//    }

}
