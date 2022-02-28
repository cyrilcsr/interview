package com.algorithms.jianZhi;

import java.util.Stack;
/*
JianZhi Offer 2-037
Leeetcode 0735
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        search:for(int asteroid:asteroids){
            while(!stack.isEmpty() && stack.peek()>0 && asteroid<0){
                if(stack.peek()>-asteroid){
                    continue search;
                }else if(stack.peek()==-asteroid){
                    stack.pop();
                    continue search;
                }else{
                    stack.pop();
                }
            }
            stack.push(asteroid);

        }
        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
//        return stack.stream().mapToInt(Integer::intValue).toArray();

    }
}
