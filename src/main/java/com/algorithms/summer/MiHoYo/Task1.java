package com.algorithms.summer.MiHoYo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Task1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine().trim();
//            int result = 0;
//            char[] sArray = s.toCharArray();
//            StringBuilder sb = new StringBuilder(s);
//
//            while(sb.length()!=0){
//                int score = 0;
//                sArray = sb.toString().toCharArray();
//                sb = new StringBuilder();
//                for(int i=0;i<sArray.length;i++){
//                    if(i==sArray.length-1){
//                        sb.append(sArray[i]);
//                        break;
//                    }
//                    if(sArray[i]=='{'&& sArray[i+1]=='}'){
//                        score+=3;
//                        i++;
//                    }else if(sArray[i]=='['&& sArray[i+1]==']'){
//                        score+=2;
//                        i++;
//                    }else if(sArray[i]=='('&& sArray[i+1]==')'){
//                        score+=1;
//                        i++;
//                    }
//                    else{
//                        sb.append(sArray[i]);
//                    }
//                }
//
//                result+=score;
//                if(score==0){
//                    break;
//                }
//            }
//            System.out.println(result);
//
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String s = sc.nextLine().trim();
            int result = 0;
            char[] sArray = s.toCharArray();
            Deque<Character> left= new ArrayDeque<>();
            for(int i=0;i<sArray.length;i++){
                if(sArray[i]=='('||sArray[i]=='['||sArray[i]=='{') {
                    left.push(sArray[i]);
                    continue;
                }
                if(left.isEmpty()&&(sArray[i]==')'||sArray[i]==']'||sArray[i]=='}')){
                    continue;
                }
                if(sArray[i]==')'&&left.peek()=='('){
                    result+=1;
                    left.pop();
                }else if(sArray[i]==']'&&left.peek()=='['){
                    result+=2;
                    left.pop();
                }else if(sArray[i]=='}'&&left.peek()=='{'){
                    result+=3;
                    left.pop();
                }else{
                    left.clear();
                }
            }
            System.out.println(result);
        }
    }
}
